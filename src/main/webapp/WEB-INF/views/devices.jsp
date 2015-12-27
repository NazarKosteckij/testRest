<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 19.12.2015
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
  <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
  <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
  <script src="<c:url value="/resources/js/materialize.js"/>"></script>
  <link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <title>Devices | ${username}</title>
</head>
<body>
<jsp:include page="navigationBar.jsp" />
<div class="container">
  <table CLASS="striped highlight">
    <thead>
    <tr>
      <th data-field="id">Name</th>
      <th data-field="name">Endpoint</th>
      <th data-field="price">Is Alive</th>
      <th data-field="price">Actions</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach var="device" items="${devices}">
          <tr class="device" id="<c:out value="${device.id}"/>">
            <td> <c:out value="${device.name}"/> </td>
            <td> <c:out value="${device.locationUrl}"/> </td>
            <td> <c:out value="${device.isAlive}"/> </td>
            <td> <a class="btn small red">remove</a> </td>
          </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
