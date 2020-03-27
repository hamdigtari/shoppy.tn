/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.shoppy.model;

import java.time.LocalDateTime;


/**
 *
 * @author asus
 */
public class Order {
      private int idCmd ; 
    private int QteTot;
    private float total ; 
    private String  adresseLiv;
    private int id_Acheteur ; 
    private  LocalDateTime  DateCreation ; 
    
    public Order(int idCmd, int QteTot, float total, String adresseLiv, int id_Acheteur, LocalDateTime DateCreation) {
        this.idCmd = idCmd;
        this.QteTot = QteTot;
        this.total = total;
        this.adresseLiv = adresseLiv;
        this.id_Acheteur = id_Acheteur;
        this.DateCreation = DateCreation;
    }
 public Order(int idCmd, int QteTot, float total, String adresseLiv, int id_Acheteur) {
        this.idCmd = idCmd;
        this.QteTot = QteTot;
        this.total = total;
        this.adresseLiv = adresseLiv;
        this.id_Acheteur = id_Acheteur;
    }
 
    public Order() {
       
    }
    public Order(int QteTot, float total) {
        this.QteTot = QteTot;
        this.total = total;
    }

    public Order(int QteTot, float total, String adresseLiv) {
        this.QteTot = QteTot;
        this.total = total;
        this.adresseLiv = adresseLiv;
    }

    public Order(int idCmd, int QteTot, float total, String adresseLiv) {
        this.idCmd = idCmd;
        this.QteTot = QteTot;
        this.total = total;
        this.adresseLiv = adresseLiv;
    }

    public int getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(int idCmd) {
        this.idCmd = idCmd;
    }
       public int getId_Acheteur() {
        return id_Acheteur;
    }

    public void setId_Acheteur(int id_Acheteur) {
        this.id_Acheteur = id_Acheteur;
    }

    public LocalDateTime getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(LocalDateTime DateCreation) {
        this.DateCreation = DateCreation;
    }


    public int getQteTot() {
        return QteTot;
    }

    public void setQteTot(int QteTot) {
        this.QteTot = QteTot;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getAdresseLiv() {
        return adresseLiv;
    }

    public void setAdresseLiv(String adresseLiv) {
        this.adresseLiv = adresseLiv;
    }
}
