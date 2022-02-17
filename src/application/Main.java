package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private int centerX = (int) ((d.getWidth() - 900) / 2);
    private int centerY = (int) ((d.getHeight() - 500) / 2);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StartScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMinWidth(900);
			primaryStage.setMinHeight(500);
			primaryStage.setX(centerX);
			primaryStage.setY(centerY);
			primaryStage.setTitle("Password Generator by Kieran Whelan");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
