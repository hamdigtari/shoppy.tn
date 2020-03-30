/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import Entities.Portfolio;
import java.sql.*;
import InteractionDB.Interaction_Portfolios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author os
 */
public class PortfoliosController implements Initializable {

    @FXML
    private TableView<Portfolio> tableView;
    @FXML
    private TableColumn<Portfolio, Integer> id_col;
    @FXML
    private TableColumn<Portfolio, Integer> user_id_col;
    @FXML
    private TableColumn<Portfolio, Integer> montant_col;
    @FXML
    private TextField search_input;
    @FXML
    private MenuButton search_col;
    @FXML
    private MenuItem search_col_id;
    @FXML
    private MenuItem search_col_uid;
    @FXML
    private MenuItem search_col_m;

    private ObservableList<Portfolio> tablist= FXCollections.observableArrayList();
    private String searchcol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
         user_id_col.setCellValueFactory(new PropertyValueFactory<>("user_id"));
         montant_col.setCellValueFactory(new PropertyValueFactory<>("montant"));
         ResultSet r=Interaction_Portfolios.getAllPortfolios();
        updateTable(r);
    }    

    @FXML
    private void search(KeyEvent event) {
        ResultSet r=null;
        if (searchcol=="montant") {
             r=Interaction_Portfolios.getAllPortfolios();
            try{
            while (r.next()){
                Portfolio p = new Portfolio(r.getInt("id"),r.getInt("user_id"));
                
                if (String.valueOf(Interaction_Portfolios.getMontant(p)).indexOf(search_input.getText())!=0 ) 
                {
                    System.out.println(r.getInt("id"));
                    r.deleteRow();
                    System.out.println(r.getInt("id"));
r.rowDeleted();
                }
            }
            }
            catch(SQLException s){
                
            }
        }

        else{
             r=Interaction_Portfolios.searchPortfoliosBy(searchcol,search_input.getText());
        }
        updateTable(r);
    }
    
    
    @FXML
    private void setSearchCol(ActionEvent event) {
         switch(((MenuItem) event.getSource()).getId()){
            case "search_col_id": searchcol="id"; break;
            case "search_col_uid": searchcol="user_id"; break;
            case "search_col_m": searchcol="montant"; break;
            
        }
        search_col.setText(searchcol);
    }
    
    
    void updateTable(ResultSet r){
        tablist.clear();
        try{
         while(r.next()){
             Portfolio p=new Portfolio(r.getInt("id"),r.getInt("user_id"));
             p=new Portfolio(p.getId(),p.getUser_id(),Interaction_Portfolios.getMontant(p));
             tablist.add(p);
         }
         tableView.setItems(tablist);
    }    
        catch(SQLException e){
            
        }
    }
    
}
