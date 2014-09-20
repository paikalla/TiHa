/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Muistilista.Tietokanta.Yhteys;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class TestiServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection yhteys = null;
        PrintWriter out = response.getWriter();
        try {
            Yhteys y = new Yhteys();
            yhteys = y.getYhteys(); //Haetaan tietokantaluokalta yhteysolio
        } catch (Exception e) {
            out.println("Yhteysvirhe: " + e.getMessage());
        }

        try {
            //Alustetaan muuttuja jossa on Select-kysely, joka palauttaa lukuarvon:
            String sqlkysely = "SELECT 1+1 as two";
            PreparedStatement kysely = yhteys.prepareStatement(sqlkysely);
            ResultSet tulokset = kysely.executeQuery();
            if (tulokset.next()) {
                int tulos = tulokset.getInt("two");
                out.println("Tulos: " + tulos);
            } else {
                out.println("Virhe!");
            }
        } catch (Exception e) {
            out.println("Virhe: " + e.getMessage());
        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KayttajaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KayttajaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
