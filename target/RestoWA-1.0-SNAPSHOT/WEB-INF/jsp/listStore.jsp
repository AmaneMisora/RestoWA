<%-- 
    Document   : listStore
    Created on : May 2, 2019, 4:17:02 PM
    Author     : yanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='${cp}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
        <script src='${cp}/webjars/jquery/3.3.1/jquery.min.js'></script>
        <script src='${cp}/webjars/bootstrap/4.3.1/js/bootstrap.min.js'></script>
        <title>Magasins</title>
    </head>
    <body>
        <%@include file="jspf/loggedHeader.jspf" %>
        <div class="album py-5 bg-light">
        <div class="container">
            <div class="col-md-13 mb-3">
                <form action="${cp}/listStore" method="POST" class="card card-sm">
                    <div class="card-body row no-gutters align-items-center">
                        <div class="col-auto">
                            <i class="fas fa-search h4 text-body"></i>
                        </div>
                        <!--end of col-->
                        <div class="col">
                            <input class="form-control form-control-lg form-control-borderless" name="search" type="search" placeholder="mot-clés">
                        </div>
                        <!--end of col-->
                        <div class="col-auto">
                            <button class="btn btn-lg btn-primary" type="submit">Trier</button>
                        </div>
                        <!--end of col-->
                    </div>
                </form>
            </div>
              
          <div class="row">
            <c:forEach items="${stores}" var="store">
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="https://previews.123rf.com/images/jemastock/jemastock1705/jemastock170504748/77744603-floue-silhouette-dessin-anim%C3%A9-fa%C3%A7ade-boutique-magasin-vector-illustration.jpg" data-holder-rendered="true">
                <div class="card-body">
                    <h4 class="text-primary">${store.name}</h4>
                    <p class="card-text">
                        <b>Clé :</b> ${store.keyStore}<br />
                        <b>Email :</b> ${store.email}<br />
                        <b>Téléphone :</b> ${store.phoneNumber}<br />
                        <b>Coordonnées :</b> ${store.lattitude} - ${store.longitude}<br />
                        <b>Adresse :</b><br />
                        ${store.address.street},<br />
                        ${store.address.zipCode} ${store.address.city} ${store.address.state},<br />
                        ${store.address.country}<br />
                        <b>Horaires d'ouvertures :</b>
                        <small>
                        <pre>Lun.   Mar.   Mer.   Jeu.   Ven.   Sam.   Dim.
${store.openingHours.mondayOpeningHour}  ${store.openingHours.tuesdayOpeningHour}  ${store.openingHours.wednesdayOpeningHour}  ${store.openingHours.thursdayOpeningHour}  ${store.openingHours.fridayOpeningHour}  ${store.openingHours.saturdayOpeningHour}  ${store.openingHours.sundayOpeningHour}
${store.openingHours.mondayClosingHour}  ${store.openingHours.tuesdayClosingHour}  ${store.openingHours.wednesdayClosingHour}  ${store.openingHours.thursdayClosingHour}  ${store.openingHours.fridayClosingHour}  ${store.openingHours.saturdayClosingHour}  ${store.openingHours.sundayClosingHour}</pre>
                        </small>
                    </p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                        <form action="${cp}/editStore" method="GET">
                            <input name="storeId" type="hidden" value="${store.id}">
                            <input name="action" type="hidden" value="update">
                            <input type="submit" value="Modifier" class="text-muted">
                        </form>
                    </div>
                    <small class="text-muted">Appartient à ${store.lastModifiedBy.lastName} ${store.lastModifiedBy.firstName}</small>
                  </div>
                </div>
              </div>
            </div>
            </c:forEach>
              
          </div>
        </div>
      </div>
    </body>
</html>
