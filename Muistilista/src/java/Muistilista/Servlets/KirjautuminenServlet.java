/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muistilista.Servlets;

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
public class KirjautuminenServlet extends KayttajaServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String salasana = request.getParameter("salasana");
        String kayttajatunnus = request.getParameter("kayttajatunnus");

       
        if (kayttajatunnus == null || salasana == null) {
            request.setAttribute("virheViesti", "Virhe!");
            NaytaJSP("Kirjautuminen.jsp", request, response);
            return;
        }

        //Tarkistetaan että vaaditut kentät on täytetty:
        if (kayttajatunnus == null || kayttajatunnus.equals("")) {

            NaytaJSP("Kirjautuminen.jsp", request, response);
            return;
        }

        /* Välitetään näkymille tieto siitä, mikä tunnus yritti kirjautumista */
        request.setAttribute("kayttaja", kayttajatunnus);

        if (salasana == null || salasana.equals("")) {
            NaytaJSP("Kirjautuminen.jsp", request, response);
            return;

        }
        
        Kayttaja kayttaja = Kayttaja.etsiKayttajaTunnuksilla(kayttajatunnus, salasana);
        
        if (kayttaja != null){
    /* Jos tunnus on oikea, ohjataan käyttäjä HTTP-ohjauksella muistilistaan. */
            session.setAttribute("kirjautunut", kayttaja.getKayttaja());
            response.sendRedirect("Kayttajanakyma");
        } else { 
            request.setAttribute("kayttajatunnus", kayttajatunnus);
            request.setAttribute("virheViesti", "Väärä salasana!");
        NaytaJSP("Kirjautuminen.jsp", request, response);
                    
  }
    } 




@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



    }
