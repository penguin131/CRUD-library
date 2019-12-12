<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>
<script type="text/javascript">
    window.setTimeout(function () {
        location.href = "index.jsp";
    }, 1000);
</script>