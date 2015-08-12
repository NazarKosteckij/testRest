var firstName = "";
var lastName = "";
var password = "";
var confirmationPassword = "";

var FieldNameOfFirstName = "#first_name";
var FieldNameOfLastName = "#last_name";
var FieldNameOfPassword = "#password";
var FieldNameOfConfirmationPassword = "#password-confirmation";

$(document).ready(function(){
	$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
	$('#register').click(function(){
		firstName = $(FieldNameOfFirstName).val();
		lastName = $(FieldNameOfLastName).val();
		password = $(FieldNameOfPassword).val();
		confirmationPassword = $(FieldNameOfConfirmationPassword).val();
		alert(lastName);
	});
});