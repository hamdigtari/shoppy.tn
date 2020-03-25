/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;
/**
 * FXML Controller class
 *
 * @author os
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Entities.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import InteractionDB.Interaction_Points;

public class PointsController implements Initializable {

    @FXML private TableView<Ticket> tableView;
    @FXML private TableColumn<Ticket, Integer> id_col;
    @FXML private TableColumn<Ticket, Integer> portfolio_id_col;
    @FXML private TableColumn<Ticket, Integer> montant_col;
    @FXML private TableColumn<Ticket, Date> date_exp_col;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
         portfolio_id_col.setCellValueFactory(new PropertyValueFactory<>("portfolio_id"));
         montant_col.setCellValueFactory(new PropertyValueFactory<>("montant"));
         date_exp_col.setCellValueFactory(new PropertyValueFactory<>("date_exp"));
         ObservableList<Ticket> tablist= FXCollections.observableArrayList();
         ResultSet r=Interaction_Points.getAllTickets();
        try{
         while(r.next()){
             
             tablist.add(new Ticket(r.getInt("id"),r.getInt("portfolio_id"),r.getInt("montant"),r.getDate("date_exp")));
         }
         tableView.setItems(tablist);
    }    
        catch(SQLException e){
            
        }
}
    
}
