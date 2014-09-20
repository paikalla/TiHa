package Muistilista.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Muistilista.Models.Kayttaja;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author viukari
 */
public class KayttajaServlet extends HttpServlet {

    protected boolean onkoKirjautunut(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        HttpSession session = request.getSession();
        Kayttaja kirjautunut = (Kayttaja)session.getAttribute("kirjautunut");
        if (kirjautunut!= null) {
                return true;
        }else{
            response.sendRedirect("KirjautuminenServlet");
            return false;
        }
    }


    protected void NaytaJSP(String tiedosto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(tiedosto);
        dispatcher.forward(request, response);
    }
}
