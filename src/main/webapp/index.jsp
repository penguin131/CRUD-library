<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="myApp.utils.HibernateUtil" %>
<%@ page import="java.util.List" %>
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
<%
    final Session session1 = HibernateUtil.getHibernateSession();
    session1.beginTransaction();
    List books = session1.createQuery("from BooksEntity order by title").list();
    session1.close();
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
            <button onclick="window.location.href='newBook.jsp?bookId=<%=book.getBookId()%>'">Edit</button>
        </td>
        <td>
            <html:form action="/DeleteBook" method="post">
                <html:hidden property="bookId" name="DeleteBookForm" value="<%=String.valueOf(book.getBookId())%>"/>
                <html:submit value="Delete"/>
            </html:form>
        </td>
    </tr>
<%
        }
    }
%>
</table>
<a href="newBook.jsp">Add new book</a><br>
<a href="newAuthor.jsp">Add new author</a><br>
<a href="newPublishing.jsp">Add new publishing</a>
</body>
</html>
