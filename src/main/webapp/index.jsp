<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="myApp.utils.DbConfiguration" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="myApp.utils.PullFromDatabase" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Welcome to super-puper Library!</h1><br>
<%
    List books = null;
    try {
        books = PullFromDatabase.getBooks();
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (books != null) {
%>
<input type="button" onclick="window.location.href = 'createBook.jsp';" value="Add new book"/><br><br>
<input type="button" onclick="window.location.href = 'createAuthor.jsp';" value="Add new author"/><br><br>
<input type="button" onclick="window.location.href = 'createPublishing.jsp';" value="Add new publishing"/><br>
<h2>Books:</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Cost</th>
        <th>Year</th>
        <th>Author</th>
        <th>Publishing</th>
        <th/>
        <th/>
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
        <td style="align-content: center; width: 60px">
            <button onclick="window.location.href='editBook.jsp?bookId=<%=book.getBookId()%>'">Edit</button>
        </td>
        <td style="align-content: center; width: 60px">
            <html:form action="/DeleteBook" method="post">
                <html:hidden property="bookId" name="DeleteBookForm" value="<%=String.valueOf(book.getBookId())%>"/>
                <div >
                    <html:submit value="Delete" onclick="javascript:return confirm('Are you sure want to delete book?');"/>
                </div>
            </html:form>
        </td>
    </tr>
<%
        }
    }
%>
</table>
<input type="button" onclick="window.location.href = 'logout.jsp';" value="Logout" style="position: absolute; top: 10px; right: 10px;"/>
</body>
</html>
