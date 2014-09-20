<%-- 
    Document   : Askareet
    Created on : 18-Sep-2014, 12:41:16
    Author     : viukari
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
           <div class="container">
            <h1>Muokkaa askareitasi</h1>
            <br>
            <br>
            <form class="form-horizontal" role="form" action="lomake.html" method="POST">

                <div class="form-group">
                    <label for="inputNumeroi1" class="col-md-2 control-label">Numeroi</label>
                    <div class="col-md-10">
                        <input type="numeroi" class="form-control" id="inputNumeroi1" name="numeroi" placeholder="Numeroi">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputAskare1" class="col-md-2 control-label">Askare</label>
                    <div class="col-md-10">
                        <input type="askare" class="form-control" id="inputAskare1" name="askare" placeholder="Askare">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputKuvaus1" class="col-md-2 control-label">Kuvaus</label>
                    <div class="col-md-10">
                        <input type="kuvaus" class="form-control" id="inputKuvaus1" name="" placeholder="Kuvaus">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputLuokka1" class="col-md-2 control-label">Luokka</label>
                    <div class="col-md-10">
                        <input type="luokka" class="form-control" id="inputLuokka1" name="luokka" placeholder="Luokka">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                    </div>
                </div>
        </div>
        
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-default">Päivitä</button>
            </div>
        </div>
</t:pohja>
