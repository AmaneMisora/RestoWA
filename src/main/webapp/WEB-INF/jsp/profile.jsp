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
        <title>Inscription</title>
    </head>
    <body>
        <%@include file="jspf/header.jspf" %>
        <div class="col-sm-6 offset-sm-3 mt-5">
            <h1 class="display-4">Profile</h1>
            <form:form method="POST" modelAttribute="user" action="${cp}/profile">
                <div class="form-group">
                    <label for="firstNameInput">Prénom</label>
                    <form:input path="firstName" class="form-control" id="firstNameInput" aria-describedby="firstNameInput" placeholder="Prénom" />
                    <small id="firstNameInput" class="form-text text-danger font-weight-bold"><form:errors path="firstName" /></small>
                </div>
                <div class="form-group">
                    <label for="lastNameInput">Nom</label>
                    <form:input path="lastName" class="form-control" id="lastNameInput" aria-describedby="lastNameInput" placeholder="Nom" />
                    <small id="lastNameInput" class="form-text text-danger font-weight-bold"><form:errors path="lastName" /></small>
                </div>
                <div class="form-group">
                    <label for="emailInput">Email</label>
                    <form:input path="email" type="email" class="form-control" id="emailInput" aria-describedby="emailInput" placeholder="email@email.email" />
                    <small id="emailInput" class="form-text text-danger font-weight-bold"><form:errors path="email" /></small>
                </div>
                <div class="form-group">
                    <label for="passwordInput">Mot de passe</label>
                    <form:input path="password" type="password" class="form-control" id="passwordInput" aria-describedby="passwordInput" />
                    <small id="passwordInput" class="form-text text-danger font-weight-bold"><form:errors path="password" /></small>
                </div>
                <div class="form-group">
                    <label for="phoneNumberInput">Numéro de téléphone</label>
                    <form:input path="phoneNumber" type="tel" class="form-control" id="phoneNumberInput" aria-describedby="phoneNumberInput" placeholder="0000000000" />
                    <small id="phoneNumberInput" class="form-text text-danger font-weight-bold"><form:errors path="phoneNumber" /></small>
                </div>
                <form:form modelAttribute="address">
                    <div class="form-group">
                        <label for="streetInput">Rue</label>
                        <form:input path="street" class="form-control" id="streetInput" aria-describedby="streetInput" placeholder="Rue" />
                        <small id="streetInput" class="form-text text-danger font-weight-bold"><form:errors path="street" /></small>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cityInput">Ville</label>
                            <form:input path="city" type="text" class="form-control" id="cityInput" aria-describedby="cityInput" placeholder="Ville" />
                            <small id="cityInput" class="form-text text-danger font-weight-bold"><form:errors path="city" /></small>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="stateInput">Etat</label>
                            <form:input path="state" type="text" class="form-control" id="stateInput" aria-describedby="stateInput" placeholder="Etat" />
                            <small id="stateInput" class="form-text text-danger font-weight-bold"><form:errors path="state" /></small>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="zipCodeInput">Zip code</label>
                            <form:input path="zipCode" type="number" class="form-control" id="zipCodeInput" aria-describedby="zipCodeInput" />
                            <small id="zipCodeInput" class="form-text text-danger font-weight-bold"><form:errors path="zipCode" /></small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="countryInput">Pays</label>
                        <form:input path="country" class="form-control" id="countryInput" aria-describedby="countryInput" placeholder="Pays" />
                        <small id="countryInput" class="form-text text-danger font-weight-bold"><form:errors path="country" /></small>
                    </div>
                <button type="submit" class="btn btn-primary">Modifier son profile</button>
                </form:form>
            </form:form>
        </div>
    </body>
</html>