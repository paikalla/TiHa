/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muistilista.Models;

import Muistilista.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viukari
 */
public class AskareenLisays {

    private int luokkaID;
    private String luokkaNimi;

    private int tarkeysID;
    private int arvo;
    private String perustelu;

    private int askareID;
    private String askareNimi;
    private int kayttajaID;
    private Askareet askare;

    public AskareenLisays(Askareet askare) {
        this.askare = askare;
    }

    public AskareenLisays(int KayttajaID) {
        this.kayttajaID = KayttajaID;
    }

//Lisätään tiedot Askare-tauluun.    
    public void AskareenLisays() {
        PreparedStatement kysely = null;
        ResultSet rs = null;
        Connection yhteys = null;
        try {
            Yhteys y = new Yhteys();
            yhteys = y.getYhteys();
        } catch (Exception e) {
        }

        try {
            kysely = yhteys.prepareStatement("INSERT INTO Tarkeysaste(arvo, perustelu, KayttajaID) VALUES(?,?,?) RETURNING TarkeysID");
            kysely.setInt(1, askare.getArvo());
            kysely.setString(2, askare.getPerustelu());
            kysely.setInt(3, askare.getKayttajaid());

            rs = kysely.executeQuery();
            rs.next();

            this.tarkeysID = rs.getInt(1);
            
            kysely = yhteys.prepareStatement("INSERT INTO Luokka(LuokkaNimi, KayttajaID) VALUES(?,?) RETURNING LuokkaID");
            kysely.setString(1, askare.getLuokkaNimi());
            kysely.setInt(2, askare.getKayttajaid());

            rs = kysely.executeQuery();
            rs.next();

            this.luokkaID = rs.getInt(1);

            kysely = yhteys.prepareStatement("INSERT INTO Askare(askareNimi, TarkeysID, KayttajaID, LuokkaID) VALUES(?,?,?,?) RETURNING AskareID");
            
            kysely.setString(1, askare.getAskareNimi());
            kysely.setInt(2, this.tarkeysID);
            kysely.setInt(3, askare.getKayttajaid());            
            kysely.setInt(4, this.luokkaID);

            rs = kysely.executeQuery();
            rs.next();

            this.askareID = rs.getInt(1);

            
            
        } catch (SQLException ex) {
        }

        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            if (kysely != null) {
                kysely.close();
            }
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }

    }

}
