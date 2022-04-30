package com.example.firstwebapp_springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tipurimasini {

    private String brand;
    private String tipcaroserie;
    private int anfabricatie;
    private float pret ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTipcaroserie() {
        return tipcaroserie;
    }

    public void setTipcaroserie(String tipcaroserie) {
        this.tipcaroserie = tipcaroserie;
    }

    public int getAnfabricatie() {
        return anfabricatie;
    }

    public void setAnfabricatie(int anfabricatie) {
        this.anfabricatie = anfabricatie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

}
