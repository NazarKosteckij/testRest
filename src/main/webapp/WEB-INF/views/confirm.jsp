<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>	
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Confirm registration</title>
</head>
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
<body>
	<p class="center flow-text">
		${status}
	</p>
</body>
</html>