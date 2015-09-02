function sendAjaxForRegister() {
	var that = this;
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        dataType: "json",
        headers:{
        	"g-recaptcha-response" : $('#g-recaptcha-response').val()
        },
        data: formToJSON(),
        error: function(data) {
        	console.log(data);
        	if (data.status==400) {
	          	console.log('sd');
	            window.location.href = "register";
        	}

       }
	}).done(
		function(data) {
			window.localStorage['clear']();
       		console.log(data);
       		$('#modal1').openModal({    
       			complete: function() { 	
       				window.location.href = "/rest" 
       			}
       		});
		});
}
function checkEmailExistingAjax(){
	$.ajax({
		url: window.location.pathname + '/checEmail',
		type: 'POST',
		dataType: 'json',
		data: {email: this.email}
	})
	.done(function(data) {
		validForm(FieldNameOfEmail);
		console.log(data);
	})
	.fail(function() {
		Materialize.toast("this email is used", 5000);
		invalidForm(FieldNameOfEmail);
		return false;
		console.log("error");
	})
}