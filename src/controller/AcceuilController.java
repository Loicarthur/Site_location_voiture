package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AcceuilController {

	@FXML
    private AnchorPane child;

    @FXML
    private JFXButton lepersonnel;

    @FXML
    private JFXButton lesachats;

    @FXML
    private JFXButton lesclients;

    @FXML
    private JFXButton leslocations;

    @FXML
    private JFXButton lesparametres;

    @FXML
    private JFXButton lesvoitures;

    @FXML
    private Label nom;

    @FXML
    private ImageView photo;
    
    @FXML
    private Parent fxml ;
    
    public void initialize() {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/Presentation.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void lesclients(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/lesclients.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void lepersonnel(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/lepersonnel.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void lesachats(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/lesachats.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    

    @FXML
    void lesparametres(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/lesachats.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void leslocations(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/leslocations.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void lesvoitures(ActionEvent event) {
    	try {
    		fxml=FXMLLoader.load(getClass().getResource("/view/lesvoitures.fxml"));
    		child.getChildren().removeAll();
    		child.getChildren().setAll(fxml);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}
