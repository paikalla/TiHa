<%-- 
    Document   : pohja
    Created on : 17-Sep-2014, 14:59:28
    Author     : viukari
--%>

<%@tag description="Generic template for Muistilista pages" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="pageTitle"%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body style="text-align:left; background-image:url('listakuva.jpg');">
        <jsp:doBody/>
        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>
    </body>
</html>

