package controller;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.user;

public class lepersonnelController {

    @FXML
    private TableColumn<String, String> cmailp;

    @FXML
    private TableColumn<String, String> cnomp;

    @FXML
    private TableColumn<Integer, Integer> ctelp;

    @FXML
    private TableColumn<String, String> ctypep;

    @FXML
    private ImageView imp;

    @FXML
    private AnchorPane p;

    @FXML
    private TextField tfidp;

    @FXML
    private TextField tfmailp;

    @FXML
    private PasswordField tfmdpp;

    @FXML
    private TextField tfnomp;

    @FXML
    private TextField tfphotop;

    @FXML
    private TextField tftelp;

    @FXML
    private JFXComboBox<String> tftypep;

    @FXML
    private TableView<user> tvpersonnel;
    
    private ObservableList<String> item = FXCollections.observableArrayList();
    
    public void initialize() { 	
    	item.add("admin");
    	item.add("client");
    	item.add("gestionnaire");
    	tftypep.setItems(item);
    	item.add("");
    }

    @FXML
    void ajouter_personnel(ActionEvent event) {

    }

    @FXML
    void inserer(ActionEvent event) {

    }

    @FXML
    void modifier_personnel(ActionEvent event) {

    }

    @FXML
    void rechercher(ActionEvent event) {

    }

    @FXML
    void supprimer_personnel(ActionEvent event) {

    }

}