<%-- 
    Document   : listPromotion
    Created on : May 9, 2019, 3:48:34 PM
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
        <title>Promotions</title>
    </head>
    <body>
        <%@include file="jspf/header.jspf" %>
        <div class="album py-5 bg-light mt-4">
        <div class="container">
            <div class="col-md-13 mb-3">
                <form action="${cp}/listPromotion" method="POST" class="card card-sm">
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
            <c:forEach items="${promotions}" var="promotion">
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" data-src="${promotion.imageURL}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${promotion.imageURL}" data-holder-rendered="true">
                <div class="card-body">
                    <h4 class="text-primary">${promotion.title}</h4>
                    <p class="card-text">
                        <b>Résumé : </b>${promotion.shortDescription}<br />
                        <b>Description : </b>${promotion.longDescription}<br />
                        <b>Début : </b>${promotion.startDate}<br />
                        <b>Fin : </b>${promotion.endDate}<br />
                        <c:if test = "${userAccount.type == 'Administrateur'}">
                        <b>Désactivé : </b>${promotion.disabled}
                        </c:if>
                    </p>
                  <div class="d-flex justify-content-between align-items-center">
                    <c:if test="${userAccount.type == 'Administrateur'}">
                    <div class="btn-group">
                        <form action="${cp}/editPromotion" method="GET">
                            <input name="promotionId" type="hidden" value="${promotion.id}">
                            <input name="action" type="hidden" value="update">
                            <input type="submit" value="Edit" class="btn btn-primary">
                        </form>
                        <form action="${cp}/editPromotion" method="POST">
                            <input name="promotionId" type="hidden" value="${promotion.id}">
                            <input name="action" type="hidden" value="delete">
                            <input type="submit" value="Del" class="btn btn-danger">
                        </form>
                    </div>
                    </c:if>
                    <small class="text-muted">Clé : ${promotion.keyPromotion}</small>
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
