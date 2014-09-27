/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muistilista.Servlets;

import Muistilista.Models.AskareenLisays;
import Muistilista.Models.Askareet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
public class LisaaAskareServlet extends KayttajaServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        NaytaJSP("LisaaAskare.jsp", request, response);
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
response.setContentType("text/html;charset=UTF-8");
        Askareet uusiaskare = new Askareet();

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (onkoKirjautunut(request, response)) {

            try {

                uusiaskare.setAskareNimi(request.getParameter("askareNimi"));
                uusiaskare.setArvo(Integer.parseInt(request.getParameter("arvo")));
                uusiaskare.setPerustelu(request.getParameter("perustelu"));
                uusiaskare.setLuokkaNimi(request.getParameter("LuokkaNimi"));
                uusiaskare.setKayttajaid(Integer.parseInt(session.getAttribute("kirjautunut").toString()));

                if (uusiaskare.onkoKelvollinen()) {

                    AskareenLisays uudetaskareet = new AskareenLisays(uusiaskare);

                    uudetaskareet.AskareenLisays();

                    session.setAttribute("ilmoitus", "Askare lisätty onnistuneesti.");
                    response.sendRedirect("Askareet");

                } else {
                    Collection<String> virheet = uusiaskare.getVirheet();
                    request.setAttribute("virheet", virheet);
                    NaytaJSP("LisaaAskare.jsp", request, response);
                }

            } finally {
                out.close();

            }
        }
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
