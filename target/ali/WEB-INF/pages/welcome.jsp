<%--
  Created by IntelliJ IDEA.
  User: khura
  Date: 14-5-2020
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome back ${sessionScope.nametoadd}</h1>
    <form method ="post">
    <input type="submit" name="action" value="logout">
</form>
</body>
</html>
