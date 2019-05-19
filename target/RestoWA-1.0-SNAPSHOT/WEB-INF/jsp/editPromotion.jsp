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
        <title>Promotion</title>
    </head>
    <body>
        <%@include file="jspf/header.jspf" %>
        <div class="col-sm-8 offset-sm-2 mt-5">
            <h1 class="display-4">Promotion</h1>
            <form:form method="POST" modelAttribute="promotion" action="${cp}/editPromotion" enctype="multipart/form-data">
                <form:input path="id" type="hidden" />
                <div class="form-group">
                    <label for="titleInput">Titre</label>
                    <form:input path="title" type="text" class="form-control" id="titleInput" aria-describedby="titleInput" placeholder="Titre" />
                    <small id="titleInput" class="form-text text-danger font-weight-bold"><form:errors path="title" /></small>
                </div>
                <div class="form-group">
                    <label for="shortDescriptionInput">Petite description</label>
                    <form:input path="shortDescription" type="text" class="form-control" id="shortDescriptionInput" aria-describedby="shortDescriptionInput" placeholder="Petite description" />
                    <small id="shortDescriptionInput" class="form-text text-danger font-weight-bold"><form:errors path="shortDescription" /></small>
                </div>
                <div class="form-group">
                    <label for="longDescriptionInput">Longue description</label>
                    <form:textarea path="longDescription" class="form-control" id="longDescriptionInput" aria-describedby="longDescriptionInput" placeholder="Longue description" />
                    <small id="longDescriptionInput" class="form-text text-danger font-weight-bold"><form:errors path="longDescription" /></small>
                </div>
                <div class="form-group">
                    <label for="positionInput">Position</label>
                    <form:input path="position" type="number" class="form-control" id="positionInput" aria-describedby="positionInput" placeholder="0" />
                    <small id="positionInput" class="form-text text-danger font-weight-bold"><form:errors path="position" /></small>
                </div>
                <div class="form-group">
                    <form:checkbox path="disabled" id="disabledInput" aria-describedby="disabledInput" />
                    <label for="disabledInput">Désactivé</label>
                    <small id="disabledInput" class="form-text text-danger font-weight-bold"><form:errors path="disabled" /></small>
                </div>
                <div class="form-group">
                    <label for="startDateInput">Début</label>
                    <form:input path="startDate" type="date" class="form-control" id="startDateInput" aria-describedby="startDateInput" value="${promotion.startDate}" />
                    <small id="startDateInput" class="form-text text-danger font-weight-bold"><form:errors path="startDate" /></small>
                </div>
                <div class="form-group">
                    <label for="endDateInput">Fin</label>
                    <form:input path="endDate" type="date" class="form-control" id="endDateInput" aria-describedby="endDateInput" value="${promotion.endDate}" />
                    <small id="endDateInput" class="form-text text-danger font-weight-bold"><form:errors path="endDate" /></small>
                </div>
                <div class="form-group">
                    <label for="imageURLInput">Image</label>
                    <form:label path="imageURL" class="form-control-file" id="imageURLInput" aria-describedby="imageURLInput">Select a file to upload</form:label>
                    <input type="file" name="file" />
                </div>
                <button type="submit" class="btn btn-primary">Envoyer</button>
            </form:form>
        </div>
    </body>
</html>