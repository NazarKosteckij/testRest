
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

//binding
$(window).unload(function() {
	saveInLocalStorage();
});

$(document).ready(function(){	
	loadFromLocalStorage();
	$('#register').click(function(){
		getFieldsData();
		if(dataInFormsIsValid()){
			registerNewUser();
		} else {
			Materialize.toast("Some data is invalid", 5000);
		}
	});

	$(FieldNameOfPassword).blur(function(event) {
		validatePassword();
	});
	$(FieldNameOfConfirmationPassword).blur(function(event) {
		validatePassword();	
	});
	
	$(FieldNameOfEmail).blur(function(event) {
		validateEmail();
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
	if($("#male").prop("checked"))
		this.gender = "male";
	else this.gender = "female";
};

function saveInLocalStorage() {
	getFieldsData();
	localStorage['firstName'] = firstName;
	localStorage['lastName'] = lastName;
	localStorage['birthdate'] = birthdate;
	localStorage['email'] = email;
	localStorage['phone'] = phone;
}

function loadFromLocalStorage () {
	if(localStorage["getItem"]("firstName")!=null)
		 firstName = localStorage['firstName'];

	if(localStorage["getItem"]("lastName")!=null)
		 lastName = localStorage['lastName'];

	if(localStorage["getItem"]("birthdate")!=null)
		 birthdate = localStorage['birthdate'];

	if(localStorage["getItem"]("email")!=null)
		 email = localStorage['email'];

	if(localStorage["getItem"]("phone")!=null)
		 phone = localStorage['phone'];

	$(FieldNameOfFirstName).val(firstName);
	$(FieldNameOfLastName).val(lastName);
	$(FieldNameOfBirthdate).val(birthdate);
	$(FieldNameOfEmail).val(email);
	$(FieldNameOfPhone).val(phone);
}

//changing form color
function invalidForm (componentName) {
	if($(componentName).hasClass( "invalid" ) == false)
		$(componentName).toggleClass( "invalid" );
}

function validForm (componentName) {
	if($(componentName).hasClass( "invalid" ) == true)
		$(componentName).toggleClass( "invalid" );
}

//Validation
function validatePassword(){
	this.password = $(this.FieldNameOfPassword).val();
	this.confirmationPassword = $(this.FieldNameOfConfirmationPassword).val();
	if(confirmationPassword !== "" && password !== ""){
		
		if(confirmationPassword === password && confirmationPassword.length>=4){ 
			validForm(FieldNameOfConfirmationPassword);
			validForm(FieldNameOfPassword);
			return true;
		} 
		invalidForm(FieldNameOfConfirmationPassword);
		invalidForm(FieldNameOfPassword);
	}
	
		invalidForm(FieldNameOfConfirmationPassword);
		invalidForm(FieldNameOfPassword);
	return false;
}

function validateEmail() {
    this.email = $(this.FieldNameOfEmail).val();
	 if(!email.indexOf(' ') >= 0){
	    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	    var isValid = re.test(this.email);
	    if(isValid){
	    	checkEmailExistingAjax();	    	
	    } else {
	    	invalidForm(this.FieldNameOfEmail);
	    }
	    return isValid;
	}  return false;
}

function dataInFormsIsValid(){
	if(validatePassword()&&validateEmail())
		return true;
	else 
		return false;
};

//registration
function registerNewUser() {
	sendAjaxForRegister();
}

function formToJSON() {
    return JSON.stringify({
        "firstName": this.firstName,
	    "lastName": this.lastName,
	    "password": calcMD5(this.password),
	    "birthdate": this.birthdate,
	    "email": this.email,
	    "phone": this.phone,
	    "gender": this.gender    
    });
}