<%--
  Created by IntelliJ IDEA.
  User: sea
  Date: 2018年3月27日 0027
  Time: 21:08:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${tip}

<s:form action="myLogin">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="password" label="密码"/>
    <s:submit value="登录"/>
</s:form>

</body>
</html>
