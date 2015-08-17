
var firstName = "";
var lastName = "";
var password = "";
var confirmationPassword = "";
var birthdate = "";
var email = "";
var phone = "";
var gender = "";

var FieldNameOfFirstName = "#first_name";
var FieldNameOfLastName = "#last_name";
var FieldNameOfPassword = "#password";
var FieldNameOfConfirmationPassword = "#password-confirmation";
var FieldNameOfBirthdate = "#birthdate";
var FieldNameOfEmail = "#email";
var FieldNameOfPhone = "#telephone";
var FieldNameOfGender= "#gender"; 

$(document).ready(function(){	

	$('#register').click(function(){
		getFieldsData();
		register();
		alert(lastName + ' ' + firstName + ' ' + password + ' ' + email + ' ' + phone );
	});
	
});

function getFieldsData(){
	this.firstName = $(this.FieldNameOfFirstName).val();
	this.lastName = $(this.FieldNameOfLastName).val();
	this.password = $(this.FieldNameOfPassword).val();
	this.confirmationPassword = $(this.FieldNameOfConfirmationPassword).val();
	this.birthdate = $(this.FieldNameOfBirthdate).val();
	this.email = $(this.FieldNameOfEmail).val();
	this.phone = $(this.FieldNameOfPhone).val();
	this.gender = $(this.FieldNameOfGender).val();
};

function validate(){

};

function register () {
	var that = this;
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        dataType: "json",
        headers:{
        	"g-recaptcha-response" : $('#g-recaptcha-response').val()},
        data: formToJSON(),
       	success: function(data) {
        	console.log(data);
        	if (data.status==200) {
          		
			}
        },
        error: function(data) {
        	console.log(data);
        	if (data.status==400) {
	          	console.log('sd');
	            window.location.href = "register";
        	}
       }
	})
}


function formToJSON() {
    return JSON.stringify({
        "firstName": this.firstName,
	    "lastName": this.lastName,
	    "password": this.password,
	    "birthdate": this.birthdate,
	    "email": this.email,
	    "phone": this.phone,
	    "gender": this.gender    	
    });
}