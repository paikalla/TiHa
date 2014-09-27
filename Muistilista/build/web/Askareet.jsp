<%-- 
    Document   : Askareet
    Created on : 18-Sep-2014, 12:41:16
    Author     : viukari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pohja pageTitle="Muistilista">
    <div class="container">
        <h1>Muistilistasi</h1>
        <br>
        <br>
        <table class="table" style="font-size:120%;">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Askare</th>
                    <th>Kommentti</th>
                    <th>Luokka</th>
                    <th>Muokkaa</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="askare" items="${listaus}">
                <tr>
                    <td class="askare"><c:out value="${askare.arvo}"/></td>
                    <td class="askare"><c:out value="${askare.askareNimi}"/></td>
                    <td class="askare"><c:out value="${askare.perustelu}"/></td>
                    <td class="askare"><c:out value="${askare.luokkaNimi}"/></td>
                    <td> <form action="MuokkaaAskaretta" method="POST">
                            <button type="submit" style="color:black">Muokkaa</button>
                        </form> 
                    </td>
                </tr>
              
            </c:forEach>

            </tbody>
        </table>
    </div>
</t:pohja>