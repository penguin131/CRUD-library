<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="css/validation.css" rel="stylesheet" type="text/css">
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="index.jsp">Go to main page</a><br>
<hr/>
Fill new book form:<br>
<html:form action="/AddBook" method="post">
    <table>
        <tr class="butt">
            <td>Title: </td>
            <td><html:text name="AddBookForm" property="title"/></td>
        </tr>
        <tr>
            <td>Publishing year: </td>
            <td><html:text name="AddBookForm" property="year"/></td>
        </tr>
        <tr>
            <td>Cost: </td>
            <td><html:text name="AddBookForm" property="cost"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td>
                <html:select property="author" >
                    <html:optionsCollection name="AddBookForm" property="authorList"
                                            label="name" value="authorId" />
                </html:select>
            </td>
        </tr>
        <tr>
            <td>Publishing</td>
            <td>
                <html:select property="publishing" >
                    <html:optionsCollection name="AddBookForm" property="publishingList"
                                            label="name" value="publishingId" />
                </html:select>
            </td>
        </tr>
    </table>
    <html:submit value="Save"/>
</html:form>
<logic:messagesPresent >
    <h4 class="failValidation"><html:errors property="numbers" /></h4>
    <h4 class="failValidation"><html:errors property="length" /></h4>
    <h4 class="failValidation"><html:errors property="cost" /></h4>
    <h4 class="failValidation"><html:errors property="year" /></h4>
</logic:messagesPresent>
</body>
</html>