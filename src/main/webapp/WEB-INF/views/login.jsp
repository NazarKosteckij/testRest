<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<script src="<c:url value="/resources/js/md5.js"/>"></script>
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Login</title>
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
<div class="container">
	<a href="<c:url value="/index" />">
	
	</a><br/>
	
	<c:if test="${not empty param.error}">
		<font color="red"> Error
		: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
	</c:if>
	<form method="POST" action="<c:url value="/j_spring_security_check" />">
			
		<div class="input-field col s6">
			<input id="email"  type="text" name="j_username" class="validate">
			<label for="email">Email</label>
		</div>
		<div class="input-field col s6">
			<input id="password" type="password"  name="j_password"  class="validate">
			<label for="password">Password</label>
		</div>
			<div class="row">
			 <p>
			 <input type="checkbox" id="remember" name="_spring_security_remember_me"/>
    			 <label for="remember">remember</label>
    		 </p>
    		</div>
			<input class="btn" type="submit" value="Login" />
			<input class="btn" type="reset" value="Reset" />
			
	</form>
</div>
</body>
</html>