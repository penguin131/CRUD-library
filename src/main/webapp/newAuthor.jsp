<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<head>
    <title>New author</title>
</head>
<body>
Fill new author form:<br>
<html:form action="/AddAuthor" method="post">
    <table>
        <tr>
            <td>Enter author name: <html:text property="name" name="AddAuthorForm" /></td>
            <td class="failValidation"><html:errors property="length"/></td>
        </tr>
    </table>
    <html:submit value="Add"/>
</html:form>
<a href="index.jsp">Go to main page</a><br>
</body>
</html>
