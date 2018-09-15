/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dersaneprojesi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "Student")
public class Ogrenci {
    @Id
    @SequenceGenerator(name = "sq_tblmusteri",
            sequenceName = "sq_tblmusteri_id",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "sq_tblmusteri")
    private int id;
    @Column(length = 255,nullable = false)
    private String ad;
    private String soyad;
    private String telefon;
    private String adres;
    private int okulno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getOkulno() {
        return okulno;
    }

    public void setOkulno(int okulno) {
        this.okulno = okulno;
    }

}
