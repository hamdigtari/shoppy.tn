package hamdigtar.Login;

import hamdigtar.DB.DBConnection;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    private VBox errBox;

    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;

     JFXSnackbar errorMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMsg = new JFXSnackbar(errBox);
    }
    @FXML
    public void BCloseAction(){
        System.out.println("close ...");
        Platform.exit();
    }
    @FXML
    private void LoginAction() {
 /*       if(usernameField.getText().isEmpty()) {
          //  errorMsg.show("Username is empty !", 1500);
          return ; // + ------ -------      -------- -------- +
        }
        if(passwordField.getText().isEmpty()) {
          //  errorMsg.show("Password is empty !", 1500);
            return;
        }
        System.out.println("Username : " + usernameField.getText());
        System.out.println("Password : " + passwordField.getText());

       // errorMsg.show("Success !", 2000);

        if (!usernameField.getText().matches("[a-zA-Z0-9_]{4,}")) {
            return;
        }
        if (passwordField.getText().isEmpty()) {
            return;
        }
*/
        int status = DBConnection.checkLogin(usernameField.getText().trim().toLowerCase(), passwordField.getText());

        switch (status) {
            case 0: {
                Stage stage = (Stage) usernameField.getScene().getWindow();

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/hamdigtar/Home/sample.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene(root));
            }
            break;
            case -1:
                JOptionPane.showMessageDialog(null, "Connection Failed");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                break;
        }
    }

    @FXML
    public void signupPop(){
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hamdigtar/register/sample.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(new Scene(root));

    }
}

