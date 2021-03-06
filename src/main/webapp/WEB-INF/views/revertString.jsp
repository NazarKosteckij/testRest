<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>	
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<script src="<c:url value="/resources/js/ajaxFunctions.js"/>"></script>
	<script src="<c:url value="/resources/js/revertString.js"/>"></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Home</title>
	
	<script type="text/javascript">

	var key = '${authKey}';
	
	</script>
</head>
<body>
<jsp:include page="navigationBar.jsp" />
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
