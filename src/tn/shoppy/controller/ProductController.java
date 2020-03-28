package tn.shoppy.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import tn.shoppy.model.Product;
import tn.shoppy.model.Shop;
import tn.shoppy.services.ProductService;
import tn.shoppy.services.ShopService;
import tn.shoppy.utils.ConnectionDB;
import tn.shoppy.utils.InputCheck;

/**
 *
 * @author anas fattoum
 */
public class ProductController implements Initializable{
    
    Connection cnx = ConnectionDB.getCnx();
    
    /**
     * UI elements
     */
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productShopColumn;
    @FXML
    private TableColumn<Product, String> productBrandColumn;
    @FXML
    private TableColumn<Product, String> productDescriptionColumn;
    @FXML
    private TableColumn<Product, Integer> productQuantityColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;
    @FXML
    private TableColumn<Product, Date> productUpdatedAtColumn;
    
    @FXML
    private TextField addProductNameField;
    @FXML
    private TextField addProductQuantityField;
    @FXML
    private TextField addProductPriceField;
    @FXML
    private TextField addProductBrandField;
    @FXML
    private TextArea addProductDescriptionArea;
    @FXML
    private ComboBox<Shop> addProductShopComboBox;
    
    @FXML
    private Label searchProductLabel;
    private ObservableList<Product> productData = FXCollections.observableArrayList();
    private ObservableList<Shop> shopData = FXCollections.observableArrayList();

    @FXML
    private ImageView productHelpImage;
    private Tooltip helpTooltip;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        List<Product> productList = new ArrayList<>();
        ProductService productService = ProductService.getInstance();
        productList = productService.getAllProducts();
        productData.clear();
        if (productList != null) {
            productData.addAll(productList);
            productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            productNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            productShopColumn.setCellValueFactory(new PropertyValueFactory<>("id_magasin"));
            productBrandColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
            productDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
            productUpdatedAtColumn.setCellValueFactory(new PropertyValueFactory<>("updated_at"));

           

            productTable.setItems(productData);
            searchProductLabel.setText("Résultat : " + productList.size() + " ligne(s).");
        } else {
            searchProductLabel.setText("Aucun résultat.");
           productTable.setPlaceholder(new Label("Il n'y a aucun produit dans la base de données. Veuillez en rajouter! "));
        }
        
        List<Shop> shopList = new ArrayList<>();
        ShopService shopService = ShopService.getInstance();
        shopList = shopService.getAllShops();    
        shopData.clear();
        if (shopList != null) {
            shopData.addAll(shopList);
            addProductShopComboBox.getItems().addAll(shopData);
//            updateOfferShopComboBox.getItems().addAll(shopData);
        }

        helpTooltip = new Tooltip("Vous êtes dans l'onglet de getion des produits.\n"
                + "Ici, vous pouvez visualiser la liste des produits des partenaires de Shoppy,\n "
                + "en rechercher par identifiant, nom et biensûr par identifiant de magasin.\n"
                + "Il est aussi possible d'en ajouter de nouveaux ou de modifier ceux existants.\n"
                + "Il est aussi posible d'en supprimer un ou plusieures.\n"
                + "Pour la sélection multiple, il vous suffit de maintenir la touche Ctrl de votre clavier\n"
                + "enfoncée lors du clic de sélection.");
        Tooltip.install(productHelpImage, helpTooltip);
    }

    
     //********************* C **************************//
    @FXML
    public void addProductAction() throws SQLException {
        ProductService productService = ProductService.getInstance();
        InputCheck inputCheck = InputCheck.getInstance();
        int shopID = 2;
        String name = addProductNameField.getText();
        String quantity = addProductQuantityField.getText();
        String description = addProductDescriptionArea.getText();
        String price = addProductPriceField.getText();
        String brand = addProductBrandField.getText();

        boolean result = false;

        if (inputCheck.testTextInput(name) && inputCheck.testDoubleInput(price)
                && (inputCheck.testNumberInput(quantity)) && inputCheck.testTextInput(brand) ) {
            Double priceDouble = Double.parseDouble(price);
            Integer quantityInt = Integer.parseInt(quantity);
            if(addProductShopComboBox.getValue()!= null)
            {
                shopID = addProductShopComboBox.getValue().getId();
            }
            Product p = new Product(0,shopID,name,quantityInt,description,priceDouble,brand);
            System.out.println(p);
            result = productService.addProduct(p) ;
        } 
        else 
        {
            System.out.println("WIP : Error dialog => Wrong input format !");
        }
        if (result) {
            productData.clear();
//            refreshTableData();
            System.out.println("Succès de l'ajout du produit !");
        } else {
            System.out.println("Echec de l'ajout du produit !");

        }

    }
    
    
}
