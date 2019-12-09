<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="myApp.model.PullFromDatabase" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<link href="css/newBook.css" rel="stylesheet" type="text/css">
<head>
    <title>book</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
    <h4 class="failValidation"><html:errors property="numbers" /></h4>
    <h4 class="failValidation"><html:errors property="length" /></h4>
    <h4 class="failValidation"><html:errors property="year" /></h4>
    <h4 class="failValidation"><html:errors property="cost" /></h4>
    <table>
        <tr class="butt">
            <td>Title: </td>
            <td><%=currentBook.getTitle()%></td>
            <td style="display: none" class="field"><html:text name="EditBookForm" property="title"/></td>
        </tr>
        <tr>
            <td>Publishing year: </td>
            <td><%=String.valueOf(currentBook.getYear())%></td>
            <td style="display: none"><html:text name="EditBookForm" property="year"/></td>
        </tr>
        <tr>
            <td>Cost: </td>
            <td><%=String.valueOf(currentBook.getCost())%></td>
            <td style="display: none"><html:text name="EditBookForm" property="cost"/></td>
        </tr>
        <tr>
            <td/>
            <td><%=String.valueOf(currentBook.getAuthor().getName())%></td>
            <td style="display: none">
                <html:select property="author" >
                    <html:optionsCollection name="EditBookForm" property="authorList"
                                        label="name" value="authorId" />
                </html:select>
            </td>
        </tr>
        <tr>
            <td/>
            <td><%=String.valueOf(currentBook.getPublishing().getName())%></td>
            <td style="display: none">
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
<script src="js/newBook.js"></script>
</body>
</html>
