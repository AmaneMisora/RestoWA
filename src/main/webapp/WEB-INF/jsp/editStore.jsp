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
        <title>Magasin</title>
    </head>
    <body>
        <%@include file="jspf/header.jspf" %>
        <div class="col-sm-8 offset-sm-2 mt-5">
            <h1 class="display-4">Magasin</h1>
            <form:form method="POST" modelAttribute="store" action="${cp}/editStore">
                <form:input path="id" type="hidden" />
                <div class="form-group">
                    <label for="nameInput">Nom</label>
                    <form:input path="name" class="form-control" id="nameInput" aria-describedby="nameInput" placeholder="Nom" />
                    <small id="nameInput" class="form-text text-danger font-weight-bold"><form:errors path="name" /></small>
                </div>
                <div class="form-group">
                    <label for="emailInput">Email</label>
                    <form:input path="email" type="email" class="form-control" id="emailInput" aria-describedby="emailInput" placeholder="email@email.email" />
                    <small id="emailInput" class="form-text text-danger font-weight-bold"><form:errors path="email" /></small>
                </div>
                <div class="form-group">
                    <label for="phoneNumberInput">Numéro de téléphone</label>
                    <form:input path="phoneNumber" type="tel" class="form-control" id="phoneNumberInput" aria-describedby="phoneNumberInput" placeholder="0000000000" />
                    <small id="phoneNumberInput" class="form-text text-danger font-weight-bold"><form:errors path="phoneNumber" /></small>
                </div>
                <div class="form-group">
                    <label for="lattitudeInput">Latitude</label>
                    <form:input path="lattitude" type="number" step="any" class="form-control" id="lattitudeInput" aria-describedby="lattitudeInput" placeholder="000,000" />
                    <small id="lattitudeInput" class="form-text text-danger font-weight-bold"><form:errors path="lattitude" /></small>
                </div>
                <div class="form-group">
                    <label for="longitudeInput">Longitude</label>
                    <form:input path="longitude" type="number" step="any" class="form-control" id="longitudeInput" aria-describedby="longitudeInput" placeholder="000,000" />
                    <small id="longitudeInput" class="form-text text-danger font-weight-bold"><form:errors path="longitude" /></small>
                </div>
                <form:form modelAttribute="openingHours">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Heures d'ouverture</th>
                                <td scope="col">Lundi</td>
                                <td scope="col">Mardi</td>
                                <td scope="col">Mercredi</td>
                                <td scope="col">Jeudi</td>
                                <td scope="col">Vendredi</td>
                                <td scope="col">Samedi</td>
                                <td scope="col">Dimanche</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td scope="row">De</td>
                                <td><form:input path="mondayOpeningHour" type="time" value="${openingHours.mondayOpeningHour}" /></td>
                                <td><form:input path="tuesdayOpeningHour" type="time" value="${openingHours.tuesdayOpeningHour}" /></td>
                                <td><form:input path="wednesdayOpeningHour" type="time" value="${openingHours.wednesdayOpeningHour}" /></td>
                                <td><form:input path="thursdayOpeningHour" type="time" value="${openingHours.thursdayOpeningHour}" /></td>
                                <td><form:input path="fridayOpeningHour" type="time" value="${openingHours.fridayOpeningHour}" /></td>
                                <td><form:input path="saturdayOpeningHour" type="time" value="${openingHours.saturdayOpeningHour}" /></td>
                                <td><form:input path="sundayOpeningHour" type="time" value="${openingHours.sundayOpeningHour}" /></td>
                            </tr>
                            <tr>
                                <td scope="row">à</td>
                                <td><form:input path="mondayClosingHour" type="time" value="${openingHours.mondayClosingHour}" /></td>
                                <td><form:input path="tuesdayClosingHour" type="time" value="${openingHours.tuesdayClosingHour}" /></td>
                                <td><form:input path="wednesdayClosingHour" type="time" value="${openingHours.wednesdayClosingHour}" /></td>
                                <td><form:input path="thursdayClosingHour" type="time" value="${openingHours.thursdayClosingHour}" /></td>
                                <td><form:input path="fridayClosingHour" type="time" value="${openingHours.fridayClosingHour}" /></td>
                                <td><form:input path="saturdayClosingHour" type="time" value="${openingHours.saturdayClosingHour}" /></td>
                                <td><form:input path="sundayClosingHour" type="time" value="${openingHours.sundayClosingHour}" /></td>
                            </tr>
                            <tr>
                                <td scope="row">Fermé</td>
                                <td><form:checkbox path="mondayClosed" /></td>
                                <td><form:checkbox path="tuesdayClosed" /></td>
                                <td><form:checkbox path="wednesdayClosed" /></td>
                                <td><form:checkbox path="thursdayClosed" /></td>
                                <td><form:checkbox path="fridayClosed" /></td>
                                <td><form:checkbox path="saturdayClosed" /></td>
                                <td><form:checkbox path="sundayClosed" /></td>
                            </tr>
                            <tr>
                                <td scope="row">24 heures</td>
                                <td><form:checkbox path="mondayAllDay" /></td>
                                <td><form:checkbox path="tuesdayAllDay" /></td>
                                <td><form:checkbox path="wednesdayAllDay" /></td>
                                <td><form:checkbox path="thursdayAllDay" /></td>
                                <td><form:checkbox path="fridayAllDay" /></td>
                                <td><form:checkbox path="saturdayAllDay" /></td>
                                <td><form:checkbox path="sundayAllDay" /></td>
                            </tr>
                        </tbody>
                    </table>
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
                    <button type="submit" class="btn btn-primary">Envoyer</button>
                    </form:form>
                </form:form>
            </form:form>
        </div>
    </body>
</html>