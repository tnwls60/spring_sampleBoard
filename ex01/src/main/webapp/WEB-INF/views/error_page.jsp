<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h4><c:out value="${exception.getMessage()}"></c:out></h4>

	<ul>
		<c:forEach items="${exception.getStackTrace()}" var="stack">
			<li><c:out value=${stack}></c:out></li>
		</c:forEach>
	</ul>

</body>
</html>