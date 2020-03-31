/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author os
 */
public class Ticket {
    
    private int id;
    private int portfolio_id;
    private int montant;
    private Date date_exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPortfolio_id() {
        return portfolio_id;
    }

    public void setPortfolio_id(int user_id) {
        this.portfolio_id = user_id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDate_exp() {
        return date_exp;
    }

    public void setDate_exp(Date date_exp) {
        this.date_exp = date_exp;
    }
    
    public Ticket(int id, int portfolio_id, int montant, Date date_exp){
        this.id=id;
        this.portfolio_id=portfolio_id;
        this.montant=montant;
        this.date_exp=date_exp;
    }
    public Ticket( int portfolio_id, int montant, Date date_exp){
        this.portfolio_id=portfolio_id;
        this.montant=montant;
        this.date_exp=date_exp;
    }
    
    @Override
    public String toString(){
        return "ID: " + id + "\nPID: "+portfolio_id + "\nMontant: " + montant + "\nDate_exp: "+ date_exp;
    }
    @Override
    public boolean equals(Object o){
        return (o.getClass()==getClass() && ((Ticket)o).getId()==getId());
    }
}
