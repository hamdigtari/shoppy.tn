package tn.shoppy.core;

import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tn.shoppy.controller.DashboardController;

import tn.shoppy.utils.ConnectionDB;

/**
 *
 * @author Haroun
 */
public class Main extends Application {
    
//    private DashboardController dashboardController = new DashboardController();

    public static void main(String[] args) {
        ConnectionDB cbd = ConnectionDB.getInstance();
        Connection cnx = cbd.getCnx();
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/tn/shoppy/view/Dashboard.fxml")); 

        primaryStage.setTitle("Shoppy Desktop");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/tn/shoppy/resources/images/logo.png")));
        
        Scene scene = new Scene(root);   
        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);          
        primaryStage.show();
    }

    
}
