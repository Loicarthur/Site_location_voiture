module location_voiture {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires com.jfoenix;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	
	opens application to javafx.graphics, javafx.fxml, javafx.controls, javafx.base, javafx.media, javafx.swing, javafx.swt, javafx.web;
	opens controller to javafx.graphics, javafx.fxml, javafx.controls, javafx.base, javafx.media, javafx.swing, javafx.swt, javafx.web;
}
