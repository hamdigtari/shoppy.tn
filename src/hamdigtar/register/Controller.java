package hamdigtar.register;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {


    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void signinPop(){
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("/hamdigtar/Login/sample.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(hamdigtar.Login.Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(new Scene(root));

    }
}
