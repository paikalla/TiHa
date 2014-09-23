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
public class Listaukset {

    private int LuokkaID;
    private String LuokkaNimi;

    private int TarkeysID;
    private int Arvo;
    private String Perustelu;

    private int AskareID;
    private String AskareNimi;
    private int KayttajaID;
    
public Listaukset(int KayttajaID){
    this.KayttajaID = KayttajaID;
}    

//Listataan kaikki tietyn käyttäjän askareet.    
    public List<Askareet> listaaAskareet() {
        PreparedStatement kysely = null;
        ResultSet rs = null;

        Connection yhteys = null;
        try {
            Yhteys y = new Yhteys();
            yhteys = y.getYhteys();
        } catch (Exception e) {
        }

        ArrayList<Askareet> listaus = new ArrayList();
        try {
            kysely = yhteys.prepareStatement("select * from Askare, Tarkeysaste, Luokka where Askare.KayttajaID = ? and Askare.LuokkaID = Luokka.LuokkaID and Askare.TarkeysID = Tarkeysaste.TarkeysID ORDER BY Tarkeysaste.arvo");
            kysely.setInt(1, KayttajaID);
            rs = kysely.executeQuery();

            while (rs.next()) {
                int AskareID = rs.getInt("AskareID");
                int Arvo = rs.getInt("Arvo");
                String AskareNimi = rs.getString("AskareNimi");
                String Perustelu = rs.getString("perustelu");
                String LuokkaNimi = rs.getString("LuokkaNimi");

                Askareet askare = new Askareet();
                askare.setArvo(Arvo);
                askare.setAskareid(AskareID);
                askare.setAskareNimi(AskareNimi);
                askare.setPerustelu(Perustelu);
                askare.setLuokkaNimi(LuokkaNimi);
                
                listaus.add(askare);
            }
        }catch (SQLException ex) {}
        
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            if(kysely!=null){
            kysely.close();
            }
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }
        
        return listaus ;
    }

}
