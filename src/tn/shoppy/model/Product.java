/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.shoppy.model;

/**
 *
 * @author anas fattoum
 */
public class Product {
    private int id;
    private String nom;
    private int quantite;
    private String description;
    private float prix;
    private String marque;

    public Product() {
        this(0,"default product",0,"product description here",0,"brand");
    }

    public Product(int id, String nom, int quantite, String description, float prix, String marque) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
        this.prix = prix;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    
    
    
}
