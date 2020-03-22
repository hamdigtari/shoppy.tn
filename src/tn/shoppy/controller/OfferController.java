package tn.shoppy.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import tn.shoppy.model.Offer;
import tn.shoppy.model.Shop;
import tn.shoppy.services.OfferService;
import tn.shoppy.services.ShopService;
import tn.shoppy.utils.ConnectionDB;
import tn.shoppy.utils.InputCheck;

/**
 *
 * @author Haroun
 */
public class OfferController implements Initializable {

    Connection cnx = ConnectionDB.getCnx();

    /**
     * UI attributes
     */
    @FXML
    private TableView<Offer> offerTable;
    @FXML
    private TableColumn<Offer, Integer> offerIdColumn;
    @FXML
    private TableColumn<Offer, String> offerNameColumn;

    private ObservableList<Offer> offerData = FXCollections.observableArrayList();

    @FXML
    private TextField searchOfferField;
    @FXML
    private Label searchOfferLabel;

    @FXML
    private ImageView offerHelpImage;
    private Tooltip helpTooltip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        offerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        List<Offer> offerList = new ArrayList<>();
        OfferService offerService = OfferService.getInstance();
        offerList = offerService.getAllOffers();
        offerData.clear();
        if (offerList != null) {
            offerData.addAll(offerList);
            offerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            //TODO complete the table view !!    
            offerTable.setItems(offerData);
            searchOfferLabel.setText("Résultat : " + offerList.size() + " ligne(s).");
        } else {
            searchOfferLabel.setText("Aucun résultat.");
            offerTable.setPlaceholder(new Label("Il n'y a aucune offre dans la base de données. Veuillez en rajouter! "));
        }

        helpTooltip = new Tooltip("Vous êtes dans l'onglet de getion des offres.\n"
                + "Ici, vous pouvez visualiser la liste des offres des partenaires de Shoppy,\n "
                + "en rechercher par identifiant, nom et biensûr par identifiant de magasin.\n"
                + "Il est aussi possible d'en ajouter de nouvelles ou de modifier une existante.\n"
                + "Il est aussi posible d'en supprimer une ou plusieures.\n"
                + "Pour la sélection multiple, il vous suffit de maintenir la touche Ctrl de votre clavier\n"
                + "enfoncée lors du clic de sélection.");
        Tooltip.install(offerHelpImage, helpTooltip);
    }

    //********************* C **************************//
    //********************* R **************************//
    public void refreshTableData() {
        List<Offer> offerList = new ArrayList<>();
        OfferService offerService = OfferService.getInstance();
        offerList = offerService.getAllOffers();
        offerData.clear();
        if (offerList != null) {
            offerData.addAll(offerList);
            offerTable.setItems(offerData);
            searchOfferLabel.setText("Résultat : " + offerList.size() + " ligne(s).");
        } else {
            searchOfferLabel.setText("Aucun résultat.");
            offerTable.setPlaceholder(new Label("Il n'y a aucune offre dans la base de données. Veuillez en rajouter! "));
        }
    }

    //********************* U **************************//
    //********************* D **************************//
    @FXML
    public void deleteOfferAction() {
        ObservableList<Offer> selectedItems = offerTable.getSelectionModel().getSelectedItems();
        System.out.println(selectedItems);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr(e) de vouloir supprimer ces " + selectedItems.size() + " éléments de la base de données ?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            OfferService offerService = OfferService.getInstance();
            for (Offer offer : selectedItems) {
                offerService.deleteOffer(offer);
            }
            refreshTableData();
            a.close();
        } else {
            a.close();
        }
    }

    //************ SEARCH *********************//
}
