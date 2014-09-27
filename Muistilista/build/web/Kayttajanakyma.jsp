<%-- 
    Document   : Kayttajanakyma
    Created on : 18-Sep-2014, 12:37:54
    Author     : viukari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br> 
                <h2>&nbsp;&nbsp;&nbsp;Tervetuloa &nbsp;&nbsp;&nbsp;seuraamaan &nbsp;&nbsp;&nbsp;muistilistaasi
                </h2>
                <br>
                <br> 
                <div class="panel panel-default">
                    <ul class="nav">
                        <li class="active"><a href="Askareet">Näytä muistilista</a></li>
                        <li><a href="LisaaAskareServlet">Lisää uusi askare</a></li>
                        <li><a href="MuokkaaAskaretta">Muokkaa askareita</a></li>
                        <li><a href="KirjauduUlos">Kirjaudu ulos</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</t:pohja>

