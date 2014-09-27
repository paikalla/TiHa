<%-- 
    Document   : LisaaAskare
    Created on : 18-Sep-2014, 12:44:03
    Author     : viukari
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pohja pageTitle="Muistilista">
    <div class="container">
        <h1>Lisää askare</h1>
        <br>
        <br>
        <form class="form-horizontal" role="form" action="/Muistilista/LisaaAskareServlet" method="POST">
            <c:forEach var="virhe" items="${virheet}"> <c:out value="${virhe}"/>  </c:forEach>
            <div class="form-group">
                <label for="inputAskare1" class="col-md-2 control-label">Uusi askare</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputAskare1" name="askareNimi" placeholder="Askare">
                </div>
            </div>

            <div class="form-group">
                <label for="inputNumeroi1" class="col-md-2 control-label">Numeroi tärkeys</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputNumeroi1" name="arvo" placeholder="Numeroi">
                </div>
            </div>

            <div class="form-group">
                <label for="inputKuvaus1" class="col-md-2 control-label">Lisää kuvaus</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputKuvaus1" name="perustelu" placeholder="Kuvaus">
                </div>
            </div>

            <div class="form-group">
                <label for="inputLuokka1" class="col-md-2 control-label">Lisää luokka</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputLuokka1" name="LuokkaNimi" placeholder="Luokka">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                </div>
            </div>

    </div>

    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <button type="submit" class="btn btn-default">Tallenna</button>
        </div>
    </div>
</t:pohja>