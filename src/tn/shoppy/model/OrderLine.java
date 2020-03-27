/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.shoppy.model;

/**
 *
 * @author asus
 */
public class OrderLine {
  
    
  private int idLC ;  
  private int id_cmd ;
  private int id_product ; 
  private  float totalLc; 
  private int qte ; 

  
    public OrderLine(float totalLc, int qte) 
    
    {
        this.totalLc = totalLc;
        this.qte = qte;
    }

    public OrderLine(int idLC, float totalLc, int qte) 
   
    {
        this.idLC = idLC;
        this.totalLc = totalLc;
        this.qte = qte;
    }
    
    

    public int getIdLC() {
        return idLC;
    }

    public void setIdLC(int idLC) {
        this.idLC = idLC;
    }
 public int getId_cmd() {
        return id_cmd;
    }

    public void setId_cmd(int id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    public float getTotalLc() {
        return totalLc;
    }

    public void setTotalLc(float totalLc) {
        this.totalLc = totalLc;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
   
}
