package me.frogdog.frogpass;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    public static final Controller INSTANCE = new Controller();

    private Scene scene;
    private Stage stage;
    private Parent root;

    public void switchRoot(ActionEvent event, String url) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(url)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(this.scene);
        stage.show();
    }

    public static Controller getInstance() {
        return INSTANCE;
    }
}
