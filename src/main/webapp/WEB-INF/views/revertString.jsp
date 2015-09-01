<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>	
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Home</title>
	
	<script type="text/javascript">

	var key = '${authKey}';
	 $(document).ready(function(){
		
		 $("#send").click(function(){ 
		  if($('#string').val()!== ""){
			 var str = null;
			 $.ajax({
				 	contentType:'application/json',
				 	type: 'POST',
				    url: 'string/'+ $('#string').val(),
				    headers: {
				        "KEY":key,
				    },
					success: function(data) {
						str = data.text;
						console.log(data);
					}
				 }).complete(function(data) {
					 
					 if(data.status == "200"){
						$('.response').empty();
						$('.response').append('response: ' + str);
					 } else if(data.status == "400"){
						 $('.response').empty();
						 $('.response').append('your token is invalid please refresh page');
					 } else if(data.status == "500"){
						 $('.response').empty();
						 $('.response').append('Server error');
					 } else {
						console.log(data);
						$('.response').empty();
						$('.response').append('unknown error');
					 }
				});
		 	} else {
				$('.response').empty();
				$('.response').append('enter string');
		 	}
		 });
	 });
	</script>
</head>
<body>
<nav class="top-nav">
 <div class="container"> 
 	<ul id="nav-mobile" class="left">
	 	<li> <a href="/rest/">Main</a> </li>
	 	<li> <a href="register">Register</a>  </li>
	 	<li> <a href="revert">Revert string</a></li>
	</ul>
	<ul id="nav-mobile" class="right" >
	 	<li> <a href="login">Login</a> </li>
	 	<li> <a href="logout">Logout</a> </li>
 	</ul>
  </div>
</nav>
<main>
<div class="container">
<h1>

</h1>
<div class="row">
	<div class="input-field col s12 m6">
		<input class="validate" placeholder="Input string" id="string" type="text">
		<button class="waves-effect waves-light btn-large" id="send">send</button>
	</div>
	<div class="col s12 m6">
		<p class="flow-text response"> </p> 
	</div>
</div>
<!--P>  The time on the server is ${serverTime}. </P-->

</div>
</main>
</body>
</html>
