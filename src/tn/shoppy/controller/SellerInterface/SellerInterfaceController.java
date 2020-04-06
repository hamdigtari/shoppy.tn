package tn.shoppy.controller.SellerInterface;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import tn.shoppy.model.Shop;
import tn.shoppy.utils.ConnectionDB;

/**
 * This controller class is used to control the whole seller interface window. 
 * (Precisely controlling the tabs and handeleing their events.)
 * WARNING: This controller is not used to handle events INSIDE the tab panes. 
 * To do that, refer to each tab's specific controller class.
 * @author Haroun
 */
public class SellerInterfaceController implements Initializable {

    private Shop sessionShop;
    Connection cnx = ConnectionDB.getCnx();
    
    /**
     * UI attributes
     */


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//         while seesionShop == null disable all tabs
    }

    /**
     * Session shop operations
     */
    public void setSessionShop(Shop shop)
    {
        this.sessionShop = shop;
        
        //Setting the controller for the offer tab
        FXMLLoader offerLoader = new FXMLLoader(getClass().getResource("/tn/shoppy/view/SellerInterface/OfferTab.fxml"));
        SellerOfferController oc = new SellerOfferController();
        oc.setSessionShop(shop);
        offerLoader.setController(oc);
//        System.out.println(getClass().getResource("/tn/shoppy/view/SellerInterface/OfferTab.fxml"));
//        System.out.println(oc);
        
        //Setting the controller for the products tab
        FXMLLoader productLoader = new FXMLLoader(getClass().getResource("/tn/shoppy/view/SellerInterface/ProductTab.fxml"));
        SellerProductController pc = new SellerProductController();
        oc.setSessionShop(shop);
        productLoader.setController(pc);
//        System.out.println(getClass().getResource("/tn/shoppy/view/SellerInterface/ProductTab.fxml"));
//        System.out.println(pc);
        
    }
    
    public Shop getSessionShop()
    {
        return this.sessionShop;
    }
    
    /**
     * 
     */
}
