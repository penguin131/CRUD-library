<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<head>
    <title>New Book</title>
</head>
<body>
Fill new book form:<br>
<html:form action="/AddBook" method="post">
    <table>
        <tr><td class="failValidation"><html:errors property="numbers" /></td></tr>
        <tr><td class="failValidation"><html:errors property="length" /></td></tr>
        <tr>
            <td>Title: <html:text name="AddBookForm" property="title"/></td>
        </tr>
        <tr>
            <td>Publishing year: <html:text name="AddBookForm" property="year"/></td>
            <td class="failValidation"><html:errors property="year" /></td>
        </tr>
        <tr>
            <td>Cost: <html:text name="AddBookForm" property="cost"/></td>
            <td class="failValidation"><html:errors property="cost" /></td>
        </tr>
        <tr><td>
                <html:select property="author" >
                    <html:optionsCollection name="AddBookForm" property="authorList"
                                            label="name" value="authorId" />
                </html:select>
            </td></tr>
        <tr><td>
                <html:select property="publishing" >
                    <html:optionsCollection name="AddBookForm" property="publishingList"
                                            label="name" value="publishingId" />
                </html:select>
            </td></tr>
    </table>
    <html:submit value="Add"/>
</html:form>
<a href="index.jsp">Go to main page</a><br>
</body>
</html>
