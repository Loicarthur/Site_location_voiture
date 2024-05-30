package controller;

import java.sql.SQLException;

import DAO.UsersDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.user;

	public class Sign_upController {

	    @FXML
	    private Button connect;

	    @FXML
	    private TextField id;

	    @FXML
	    private TextField passe;

	    @FXML
	    private TextField tel;
	    
	    @FXML
	    private ComboBox<String> type;

		private ObservableList<String> item = FXCollections.observableArrayList();
	    
	    public void initialize() {
	    	item.add("");
	    	item.add("admin");
	    	item.add("client");
	    	item.add("gestionnaire");
	    	type.setItems(item);
	    }

	    @FXML
	    void connect(ActionEvent event) throws SQLException {
			if(id.getText().split("@").length==2 && id.getText().split("@")
					[1].contains(".com") && tel.getText().length()>10) {
				user u = new user(id.getText(),id.getText(),Integer.parseInt(tel.getText()),passe.getText(),"",type.getValue());
				UsersDAO.save(u);
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setContentText("Adresse mail incorrecte !");
				alert.showAndWait();
			}
	    	
	    }


}
