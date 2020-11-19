<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- 로그인 후 /board/list로 이동 -->
<script type="text/javascript">
	self.location="/board/list";
</script>
</body>
</html>
