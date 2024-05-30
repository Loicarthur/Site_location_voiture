package controller;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MainController {

	@FXML
	private Pane pane;

	@FXML
	private Button inscrit;

	@FXML
	private Button connect;
	
	private Parent fxml;

	public void initialize() throws IOException {
		TranslateTransition t = new TranslateTransition(Duration.seconds(0.5),pane);
		t.setToX(pane.getLayoutX());
		t.play();
		t.setOnFinished(e ->{
			try {
				fxml = FXMLLoader.load(getClass().getResource("/view/Sign_up.fxml"));
				pane.getChildren().removeAll();
				pane.getChildren().setAll(fxml);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	@FXML
	void connect(ActionEvent event) throws IOException {
		TranslateTransition t = new TranslateTransition(Duration.seconds(1),pane);
		t.setToX(pane.getLayoutX()+320);
		t.play();
		t.setOnFinished(e ->{
			try {
				fxml = FXMLLoader.load(getClass().getResource("/view/Sign_in.fxml"));
				pane.getChildren().removeAll();
				pane.getChildren().setAll(fxml);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	@FXML
	void inscrit(ActionEvent event) throws IOException {
		TranslateTransition t = new TranslateTransition(Duration.seconds(1),pane);
		t.setToX(pane.getLayoutX());
		t.play();
		t.setOnFinished(e ->{
			try {
				fxml = FXMLLoader.load(getClass().getResource("/view/Sign_up.fxml"));
				pane.getChildren().removeAll();
				pane.getChildren().setAll(fxml);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
