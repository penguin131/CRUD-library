<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="css/index.css" rel="stylesheet" type="text/css">
<html>
<head>
    <meta charset="UTF-8">
    <title>Library</title>
</head>
<body>
<h1>Welcome to super-puper Library!</h1><br>
<html:form action="/Main" method="post">
    <html:select property="sortParam" name="MainPageForm">
        <html:option value="ASC">Ascending</html:option>
        <html:option value="DESC">Descending</html:option>
    </html:select>
    <html:submit value="Show"/>
</html:form>
<%
    ArrayList<?> books = (ArrayList<?>) request.getAttribute("books");
    if (books != null) {
%>
<table>
    <tr><th>Books:</th></tr>
    <tr>
        <td>Title</td>
        <td>Cost</td>
        <td>Year</td>
        <td>Author</td>
        <td>Publishing</td>
    </tr>
<%for (Object o : books) {
    BooksEntity book = (BooksEntity) o;%>
    <tr>
        <td>
            <%=book.getTitle()%>
        </td>
        <td>
            <%=book.getCost()%>
        </td>
        <td>
            <%=book.getYear()%>
        </td>
        <td>
            <%=book.getAuthor().getName()%>
        </td>
        <td>
            <%=book.getPublishing().getName()%>
        </td>
        <td>
            <button onclick="window.location.href='book.jsp?bookName=<%=book.getTitle()%>'">Open</button>
        </td>
    </tr>
<%
        }
    }
%>
</table>
<a href="newBook.jsp">Add new book</a><br>
<a href="author.jsp">Add new author</a><br>
<a href="publishing.jsp">Add new publishing</a>
</body>
</html>
