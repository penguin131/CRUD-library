<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<head>
    <title>New author</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<input type="button" onclick="window.location.href = 'index.jsp';" value="Go to main page"/>
<hr/>
Fill new publishing form:<br>
<html:form action="/AddPublishing" method="post">
    Enter publishing name: <html:text property="name" name="AddPublishingForm" />
    <h4 class="failValidation"><html:errors property="length"/></h4>
    <html:submit value="Add"/>
</html:form>
</body>
</html>
