<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td><a href="${cp}/login">Login</a>
                </td>
                <td><a href="${cp}/register">Register</a>
                </td>
            </tr>
        </table>
    </body>
    </html>
<!--
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Spring 5 Web MVC via Annotations</title> 
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" /> 
        <script src="${cp}/resources/js/js.js"></script> 
    </head> 
    <body> 
        <h1>${cp}</h1> 
        <h4>Spring 5 Web MVC via Annotations</h4> 
        Spring says: <span class="blue">${msg}</span> 
        User id: <span class="blue">${userId}</span> 
        User name: <span class="blue">${userName}</span> 
        <br /> 
        <br /> 
        <a href="javascript:void(0)" onclick="test()">Click to test JS</a> 
    </body> 
</html>
-->