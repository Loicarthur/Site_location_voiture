package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.ConnexionDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Sign_inController {

	@FXML
	private Button connect;

	@FXML
	private TextField id;

	@FXML
	private TextField passe;

	@FXML
	void connect(ActionEvent event) throws SQLException {

		Connection conn = ConnexionDB.connect();
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE mail= ? AND password= ?";

		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, id.getText().toString());
			stat.setString(2, passe.getText().toString());
			rs = stat.executeQuery();
			if (rs.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setContentText("Connection réussi !");
				alert.showAndWait();
				connect.getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/view/AcceuilView.fxml"));
				Parent main = loader.load();
				Scene scene = new Scene(main);
				stage.setScene(scene);
				stage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alert");
				alert.setHeaderText("Erreur");
				alert.setContentText("mot de pass ou login incorrect");
				alert.showAndWait();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
