<%-- 
    Document   : Askareet
    Created on : 18-Sep-2014, 12:41:16
    Author     : viukari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                <tr>

                    <td>1</td>
                    <td>Aamiainen Tiffanylla</td>
                    <td>Tooosi tärkeä tilaisuus</td>
                    <td>Työ</td>
                    <td> <form action="MuokkaaAskaretta" method="POST">
                            <button type="submit" style="color:black">Muokkaa</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Varaa lääkäriaika</td>
                    <td>Hoida pois alta!</td>
                    <td>Vapaa-aika</td>
                    <td> <form action="MuokkaaAskaretta" method="POST">
                            <button type="submit" style="color:black">Muokkaa</button>
                        </form> 
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Uusi tentti 10.12.Blaah. </td>
                    <td>Evvk</td>
                    <td>Opiskelu</td>
                    <td> <form action="MuokkaaAskaretta" method="POST">
                            <button type="submit" style="color:black">Muokkaa</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</t:pohja>