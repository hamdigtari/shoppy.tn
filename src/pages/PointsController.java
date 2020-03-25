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
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PointsController implements Initializable {

    @FXML private TableView<Ticket> tableView;
    @FXML private TableColumn<Ticket, Integer> id_col;
    @FXML private TableColumn<Ticket, Integer> portfolio_id_col;
    @FXML private TableColumn<Ticket, Integer> montant_col;
    @FXML private TableColumn<Ticket, Date> date_exp_col;
    @FXML private TextField search_input;
    @FXML private MenuButton search_col;
    @FXML private MenuItem search_col_id;
    @FXML private MenuItem search_col_pid;
    @FXML private MenuItem search_col_m;
    @FXML private MenuItem search_col_d;
  
    
    
    
    private ObservableList<Ticket> tablist= FXCollections.observableArrayList();
    private String searchcol;
    

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
         ResultSet r=Interaction_Points.getAllTickets();
        updateTable(r);
}

    @FXML
    private void search(KeyEvent event) {
        ResultSet r=Interaction_Points.searchTicketsBy(searchcol,search_input.getText());
        updateTable(r);
        
    }
 
    
    
    
    void updateTable(ResultSet r){
        tablist.clear();
        try{
         while(r.next()){
             
             tablist.add(new Ticket(r.getInt("id"),r.getInt("portfolio_id"),r.getInt("montant"),r.getDate("date_exp")));
         }
         tableView.setItems(tablist);
    }    
        catch(SQLException e){
            
        }
    }


    @FXML
    private void setSearchCol(ActionEvent event) {
        switch(((MenuItem) event.getSource()).getId()){
            case "search_col_id": searchcol="id"; break;
            case "search_col_pid": searchcol="portfolio_id"; break;
            case "search_col_m": searchcol="montant"; break;
            case "search_col_d": searchcol="date_exp"; break;
            
        }
        search_col.setText(searchcol);
}


  
}
