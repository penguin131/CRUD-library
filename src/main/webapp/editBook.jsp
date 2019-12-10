<%@ page import="myApp.model.BooksEntity" %>
<%@ page import="myApp.model.PullFromDatabase" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/validation.css" rel="stylesheet" type="text/css">
<link href="css/book.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
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
<a href="index.jsp">Go to main page</a><br>
<hr/>
Fill new book form:<br>
<html:form action="/EditBook" method="post">
    <table>
        <tr class="edit">
            <td>Title: </td>
            <td>
                <div><%=currentBook.getTitle()%></div>
                <div class="field" style="display: none">
                    <html:text name="EditBookForm" property="title"/>
                </div>
            </td>
        </tr>
        <tr class="edit">
            <td>Publishing year: </td>
            <td>
                <div><%=String.valueOf(currentBook.getYear())%></div>
                <div class="field" style="display: none">
                    <html:text name="EditBookForm" property="year"/>
                </div>
            </td>
        </tr>
        <tr class="edit">
            <td>Cost: </td>
            <td>
                <div><%=String.valueOf(currentBook.getCost())%></div>
                <div class="field" style="display: none">
                    <html:text name="EditBookForm" property="cost"/>
                </div>
            </td>
        </tr>
        <tr class="edit">
            <td>Author</td>
            <td>
                <div><%=String.valueOf(currentBook.getAuthor().getName())%></div>
                <div class="field" style="display: none">
                    <html:select property="author" >
                        <html:optionsCollection name="EditBookForm" property="authorList"
                                                label="name" value="authorId" />
                    </html:select>
                </div>
            </td>
        </tr>
        <tr class="edit">
            <td>Publishing</td>
            <td>
                <div><%=String.valueOf(currentBook.getPublishing().getName())%></div>
                <div class="field" style="display: none">
                    <html:select property="publishing" >
                        <html:optionsCollection name="EditBookForm" property="publishingList"
                                                label="name" value="publishingId" />
                    </html:select>
                </div>
            </td>
        </tr>
    </table>
    <html:hidden property="bookId" name="EditBookForm" value="<%=String.valueOf(currentBook.getBookId())%>"/>
    <div id="watchMode">
        <input type="button" class="modify" alt="Modify book" value="Modify">
    </div>
    <div id="editMode" style="display: none">
        <html:submit value="Save"/>
        <input type="button" alt="close" id="x-mark" class="modify"/>
    </div>
    <h4 style="color: crimson">Empty fields will not change!</h4>
</html:form>
<h4 class="failValidation"><html:errors property="numbers" /></h4>
<h4 class="failValidation"><html:errors property="year" /></h4>
<h4 class="failValidation"><html:errors property="cost" /></h4>
<script src="javaScript/editBook.js"></script>
</body>
</html>
