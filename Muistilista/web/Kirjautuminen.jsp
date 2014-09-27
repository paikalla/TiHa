<%-- 
    Document   : sivujsp
    Created on : 17-Sep-2014, 12:44:58
    Author     : viukari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pohja pageTitle="Muistilista">
<div class="container">
            <ul>
                <h1>Muistilista</h1>
                <h2>Mitäs askareita pitikään tehdä? </h2>
                <h3>Kirjaudu sisään. Tee muistilista.</h3>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>             
                <div class="container">
                    <div class="alert alert-danger">Virhe! ${virheViesti}</div>
                    <h3>Kirjaudu sisään</h3>
                    <form class="form-horizontal" role="form" action="KirjautuminenServlet" method="POST">
                        <div class="form-group">
                            <label for="inputUsername1" class="col-md-2 control-label">Tunnus</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" value="${kayttajatunnus}" id="inputUsername1" name="kayttajatunnus" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword1" class="col-md-2 control-label">Salasana</label>
                            <div class="col-md-10">
                                <input type="password" class="form-control" id="inputPassword1" name="salasana" placeholder="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Muista kirjautuminen
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-10" style="color:black;">
                                <button type="submit">Kirjaudu sisään</button>
                            </div>
                        </div>
                    </form>
                </div>
            </ul>

        </div>
</t:pohja>
