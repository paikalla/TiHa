package Muistilista.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viukari
 */
public class NaytaJSP extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        /* Asetetaan virheviesti */
        request.setAttribute("virheViesti", "Väärä käyttäjätunnus tai salasana");
        /* Luodaan RequestDispatcher-olio, joka osaa näyttää lista.jsp:n */
        RequestDispatcher dispatcher = request.getRequestDispatcher("Kirjautuminen.jsp");
        /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
        dispatcher.forward(request, response);
    }
}
