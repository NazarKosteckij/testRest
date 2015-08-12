<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<script src="<c:url value="/resources/js/register.js"/>"></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Register</title>
</head>
<body>
<nav class="top-nav">
 	<div class="container"> <a href="/rest/">Main</a> </div>
</nav>
<main>
	<div class="container">
		<h1></h1>
		<div class="row">
		 <div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s3"><a  class="active" href="#info1">General <span class="hide-on-small-only">information</span></a></li>
		        <li class="tab col s3"><a href="#info2">Personal  <span class="hide-on-small-only">information</span></a></li>
		        <li class="tab col s3"><a href="#info3">Contact  <span class="hide-on-small-only">information</span></a></li>
		      </ul>
		    </div>
		    <div id="info1" class="col s12">
				<div class="container">
				<div class="row">
				<br>
				    <form class="col s12">
				      <div class="row">
				        <div class="input-field col s6">
				          <input id="first_name" type="text" class="validate">
				          <label for="first_name">First Name</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="last_name" type="text" class="validate">
				          <label for="last_name">Last Name</label>
				        </div>
				      </div>
				      <div class="row">
				        <div class="input-field col s6">
				          <input id="password" type="password" class="validate">
				          <label for="password">Password</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="password-confirmation" type="password" class="validate">
				          <label for="password-confirmation">Confirm password</label>
				        </div>
				      </div>
				      <div class="row right">
				      	<a class="waves-effect waves-light btn" onclick="  $('ul.tabs').tabs('select_tab', 'info2');" id="next-1">Next</a>
				      </div>
				    </form>
				  </div>
				</div>
			</div>
		    <div id="info2" class="col s12">
		      <div class="container">
				<div class="row">
				<br>
				    <form class="col s12">
				     <div class="row">
				      <div class="col s6">
				       <label for="datepicker">Birthdate</label>
				       <input type="date" class="datepicker">
				      </div>
				      </div>
				      <div class="row">
					    <p>
					      <input name="group1" type="radio" id="female" />
					      <label for="female">Female</label>
					    </p>
					    <p>
					      <input name="group1" type="radio" id="male" />
					      <label for="male">Male</label>
					    </p>
				      </div>
				      <div class="row right">
				      	<a class="waves-effect waves-light btn" onclick="  $('ul.tabs').tabs('select_tab', 'info3');" id="next-2">Next</a>
				      </div>
				    </form>
				  </div>
				</div>
			</div>
		    <div id="info3" class="col s12">
			  <div class="container">
				<div class="row">
				<br>
				    <form class="col s12">
				      <div class="row">
				      
				        <div class="input-field col s6">
				          <input id="email" type="email" class="validate">
				          <label for="email">Email</label>
				        </div>
				        <div class="input-field col s6">
				          <i class="material-icons prefix">phone</i>
				          <input id="icon_telephone" type="tel" class="validate">
				          <label for="icon_telephone">Telephone</label>
				        </div>
				      </div>
				      <div class="row">
				    	 Captcha ${captcha} <br>
						<input id="captcha"/>
					  </div>
				      <div class="row right">
				      <a class="waves-effect waves-light btn-large" id="register">register</a>
				      </div>
				    </form>
				  </div>
				</div></div>
		  </div>
		</div>
	</div>
</main>
</body>
</html>