<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nkostets
  Date: 9/10/2015
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="top-nav">
  <div class="container">
    <ul id="nav-mobile" class="left">
      <li> <a href="<c:url value="/" />">Main</a> </li>
      <li> <a href="<c:url value="/register" />">Register</a>  </li>
      <li> <a href="<c:url value="/revert" />">Revert string</a></li>
      <li> <a href="<c:url value="/mydevices" />">My devices</a></li>
    </ul>
    <ul id="nav-mobile" class="right" >
      <li> <a href="<c:url value="/login" />">Login</a> </li>
      <li> <a href="<c:url value="/logout" />">Logout</a> </li>
    </ul>
  </div>
</nav>
