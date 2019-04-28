<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel='stylesheet' href='${cp}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
        <script src='${cp}/webjars/jquery/3.3.1/jquery.min.js'></script>
        <script src='${cp}/webjars/bootstrap/4.3.1/js/bootstrap.min.js'></script>
        <title>Connection</title>
    </head>
    <body>
        <%@include file="jspf/unloggedHeader.jspf" %>
        <div class="col-sm-6 offset-sm-3 mt-5">
            <h1 class="display-4">Connection</h1>
            <form:form method="POST" modelAttribute="userAccount" action="${cp}/login">
                <div class="form-group">
                    <label for="nameInput">Nom</label>
                    <form:input path="firstName" class="form-control" id="nameInput" aria-describedby="nameInput" placeholder="Nom" />
                    <small id="nameInput" class="form-text text-danger font-weight-bold"><form:errors path="firstName" /></small>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </body>
</html>