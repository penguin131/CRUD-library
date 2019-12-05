<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="myApp.model.PullFromDatabase" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<head>
    <title>book</title>
</head>
<body>
<%
    BooksEntity currentBook;
    try {
        currentBook = PullFromDatabase.getBookForId(Integer.parseInt(request.getParameter("bookId")));
    } catch (Exception ex) {
        return;
    }
    if (currentBook == null) {
    	return;
    }
%>
Fill new book form:<br>
<html:form action="/EditBook" method="post">
    <table>
        <tr><td class="failValidation"><html:errors property="numbers" /></td></tr>
        <tr><td class="failValidation"><html:errors property="length" /></td></tr>
        <tr>
            <td>Old params</td>
            <td>New params</td>
        </tr>
        <tr>
            <td><%=currentBook.getTitle()%></td>
            <td>Title: <html:text name="EditBookForm" property="title"/></td>
        </tr>
        <tr>
            <td><%=String.valueOf(currentBook.getYear())%></td>
            <td>Publishing year: <html:text name="EditBookForm" property="year"/></td>
            <td class="failValidation"><html:errors property="year" /></td>
        </tr>
        <tr>
            <td><%=String.valueOf(currentBook.getCost())%></td>
            <td>Cost: <html:text name="EditBookForm" property="cost"/></td>
            <td class="failValidation"><html:errors property="cost" /></td>
        </tr>
        <tr>
            <td><%=String.valueOf(currentBook.getAuthor().getName())%></td>
            <td>
                <html:select property="author" >
                    <html:optionsCollection name="EditBookForm" property="authorList"
                                        label="name" value="authorId" />
                </html:select>
            </td>
        </tr>
        <tr>
            <td><%=String.valueOf(currentBook.getPublishing().getName())%></td>
            <td>
                <html:select property="publishing" >
                    <html:optionsCollection name="EditBookForm" property="publishingList"
                                            label="name" value="publishingId" />
                </html:select>
            </td>
        </tr>
    </table>
    <html:hidden property="bookId" name="EditBookForm" value="<%=String.valueOf(currentBook.getBookId())%>"/>
    <html:submit value="Save"/>
</html:form>
<a href="index.jsp">Go to main page</a><br>
</body>
</html>
