package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane	p = new AnchorPane();
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/AcceuilView.fxml"));
			p=loader.load();
			Scene scene = new Scene(p);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		launch(args);
		Application.launch(Main.class, args);
	}
}
