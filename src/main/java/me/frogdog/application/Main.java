package me.frogdog.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {
	
    final private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    final private int centerX = (int) ((d.getWidth() - 900) / 2);
    final private int centerY = (int) ((d.getHeight() - 500) / 2);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(String.valueOf(getClass().getResource("application.css")));
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
