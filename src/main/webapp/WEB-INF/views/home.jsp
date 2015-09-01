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
<h1>Welcome</h1>

</div>

</main>

</body>
</html>
