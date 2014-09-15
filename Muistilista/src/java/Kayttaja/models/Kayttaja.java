/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttaja.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author viukari
 */
public class Kayttaja {

    private int Kayttajaid;
    private String kayttajatunnus;
    private String etunimi;
    private String sukunimi;
    private String salasana;

    public Kayttaja(int Kayttajaid, String kayttajatunnus, String etunimi, String sukunimi, String salasana) {
        this.Kayttajaid = Kayttajaid;
        this.kayttajatunnus = kayttajatunnus;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.salasana = salasana;

    }

}
