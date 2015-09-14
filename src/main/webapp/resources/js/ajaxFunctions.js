function sendAjaxForRegister() {
	var that = this;
	$.ajax({
		type: 'POST',
        contentType: 'application/json',
        dataType: "json",
        headers:{
        	"g-recaptcha-response" : $('#g-recaptcha-response').val()
        },
        data: formToJSON()
	}).done(
		function(data) {
			window.localStorage['clear']();
       		console.log(data);
       		$('#modal1').openModal({    
       			complete: function() { 	
       				window.location.href = "/rest" 
       			}
       		});
		}).fail(function(data) {
			console.log(data);
			if (data.status==400) {
				console.log('sd');
				window.location.href = "register";
			}

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

// used in revertString.jsp
function doRevertStringAjax(){
		$.ajax({
	 	contentType:'application/json',
	 	type: 'POST',
	    url: 'string/'+ $('#string').val(),
	    headers: {
	        "KEY":key,
		}
	 }).complete(function(data) {
			str = JSON.parse(data.responseText).text;
			console.log(data);
			 if(data.status == "200"){
				$('.response').empty();
				$('.response').append('response: ' + str);
			 } else if(data.status == "400"){
				 $('.response').empty();
				 $('.response').append('your token is expired please refresh page');
			 } else if(data.status == "500"){
				 $('.response').empty();
				 $('.response').append('Server error');
			 } else {
				console.log(data);
				$('.response').empty();
				$('.response').append('unknown error');
			 }
		});
}