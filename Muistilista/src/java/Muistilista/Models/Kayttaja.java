/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muistilista.Models;

import Muistilista.Tietokanta.Yhteys;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kayttaja {

    private int kayttajaid;
    private String kayttajatunnus;
    private String etunimi;
    private String sukunimi;
    private String salasana;

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }

    public void setKayttajaid(int kayttajaid) {
        this.kayttajaid = kayttajaid;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public static Kayttaja etsiKayttajaTunnuksilla(String kayttaja, String salasana) {

        Connection yhteys = null;
        try {
            Yhteys y = new Yhteys();
            yhteys = y.getYhteys();
        } catch (Exception e) {
        }

        String sql = "SELECT Kayttajaid, kayttajatunnus, salasana from Kayttaja where kayttajatunnus = ? AND salasana = ?";
        /*Connection yhteys = Tietokanta.getYhteys();*/
        PreparedStatement kysely = null;
        Kayttaja kirjautunut = null;
        ResultSet rs = null;
     
        
        try {
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, kayttaja);
            kysely.setString(2, salasana);
            rs = kysely.executeQuery();
            if (rs.next()) {
        //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
                //ja asetetaan palautettava olio:
                kirjautunut = new Kayttaja();
                kirjautunut.setKayttajaid(rs.getInt("kayttajaid"));
                kirjautunut.setKayttajatunnus(rs.getString("kayttajatunnus"));
                kirjautunut.setSalasana(rs.getString("salasana"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
     

  //next-metodia on kutsuttava aina, kun käsitellään 
        //vasta kannasta saatuja ResultSet-olioita.
        //ResultSet on oletuksena ensimmäistä edeltävällä -1:llä rivillä.
        //Kun sitä kutsuu ensimmäisen kerran siirtyy se ensimmäiselle riville 0.
        //Samalla metodi myös palauttaa tiedon siitä onko seuraavaa riviä olemassa.
        

  //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.
        //Suljetaan kaikki resurssit:
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }

}

