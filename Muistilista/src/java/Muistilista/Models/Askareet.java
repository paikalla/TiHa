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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viukari
 */
public class Askareet {

    private int askareid;
    private String askareNimi;
    private int tarkeysid;
    private int kayttajaid;
    private int luokkaid;
    private String Perustelu;
    private String LuokkaNimi;
    private int Arvo;

    Askareet() {

    }

    public void setAskareid(int askareid) {
        this.askareid = askareid;
    }

    public void setAskareNimi(String askareNimi) {
        this.askareNimi = askareNimi;
    }

    public void setTarkeysid(int tarkeysid) {
        this.tarkeysid = tarkeysid;
    }

    public void setKayttajaid(int kayttajaid) {
        this.kayttajaid = kayttajaid;
    }

    public void setLuokkaid(int luokkaid) {
        this.luokkaid = luokkaid;
    }

    public void setPerustelu(String Perustelu) {
        this.Perustelu = Perustelu;
    }

    public void setLuokkaNimi(String LuokkaNimi) {
        this.LuokkaNimi = LuokkaNimi;
    }

    public void setArvo(int Arvo) {
        this.Arvo = Arvo;
    }

    
    
    public int getArvo() {
        return Arvo;        
    }

    public int getAskareid() {
        return askareid;
    }

    public String getAskareNimi() {
        return askareNimi;
    }

    public int getTarkeysid() {
        return tarkeysid;
    }

    public int getKayttajaid() {
        return kayttajaid;
    }

    public int getLuokkaid() {
        return luokkaid;
    }

    public String getPerustelu() {
        return Perustelu;
    }

    public String getLuokkaNimi() {
        return LuokkaNimi;
    }

}

/*public static Askareet listaaAskareet(int askareid, String askareNimi, int tarkeysid, int kayttajaid, int luokkaid) {

 Connection yhteys = null;
 try {
 Yhteys y = new Yhteys();
 yhteys = y.getYhteys();
 } catch (Exception e) {
 }

 String sql = "SELECT AskareID, AskareNimi, TarkeysID, KayttajaID, LuokkaID from Askare"; /*where KayttajaID= ?

 PreparedStatement kysely = null;
 Askareet askarelista = null;
 ResultSet rs = null;

 try {
 kysely = yhteys.prepareStatement(sql);
 kysely.setInt(1, askareid);
 kysely.setString(2, askareNimi);
 kysely.setInt(3, tarkeysid);
 kysely.setInt(4, kayttajaid);
 kysely.setInt(5, luokkaid);
 rs = kysely.executeQuery();
 if (rs.next()) {

 askarelista = new Askareet();
 askarelista.setAskareid(rs.getInt("AskareID"));
 askarelista.setAskareNimi(rs.getString("AskareNimi"));
 askarelista.setTarkeysid(rs.getInt("TarkeysID"));
 askarelista.setKayttajaid(rs.getInt("KayttajaID"));
 askarelista.setLuokkaid(rs.getInt("LuokkaID"));
 }
 } catch (SQLException ex) {
 }

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

 //listaus palautetaan.
 return askarelista;
 }

 }*/
