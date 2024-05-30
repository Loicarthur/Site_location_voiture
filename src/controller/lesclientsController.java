package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class lesclientsController {

    @FXML
    private TableColumn<?, ?> cdatee;

    @FXML
    private TableColumn<?, ?> cmailcl;

    @FXML
    private TableColumn<?, ?> cnomcl;

    @FXML
    private TableColumn<?, ?> cpointcl;

    @FXML
    private TableColumn<?, ?> ctelcl;

    @FXML
    private DatePicker dpdatee;

    @FXML
    private AnchorPane p;

    @FXML
    private TableView<?> tbclient;

    @FXML
    private TextField tfidcl;

    @FXML
    private TextField tfmailcl;

    @FXML
    private TextField tfnomcl;

    @FXML
    private TextField tfpointcl;

    @FXML
    private TextField tftelcl;

    @FXML
    void ajouter_client(ActionEvent event) {

    }

    @FXML
    void modifier_client(ActionEvent event) {

    }

    @FXML
    void rechercher_client(ActionEvent event) {

    }

    @FXML
    void supprimer_client(ActionEvent event) {

    }

}
