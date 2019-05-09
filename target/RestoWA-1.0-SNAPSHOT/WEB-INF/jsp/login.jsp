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
        <%@include file="jspf/header.jspf" %>
        <div class="col-sm-6 offset-sm-3 mt-5">
            <h1 class="display-4">Connection</h1>
            <form method="POST" action="${cp}/login">
                <div class="form-group">
                    <c:if test="${errorMessage != null}">
                    <div class="alert alert-danger" role="alert">
                    ${errorMessage}
                    </div>      
                    </c:if>
                    <label for="emailInput">Email</label>
                    <input name="email" path="email" class="form-control" id="emailInput" aria-describedby="emailInput" placeholder="email" />
                    <label for="passwordInput">Mot de passe</label>
                    <input name="password" path="password" type="password" class="form-control" id="passwordInput" aria-describedby="passwordInput" />
                </div>
                <button type="submit" class="btn btn-primary">Se connecter</button>
            </form>
        </div>
    </body>
</html>