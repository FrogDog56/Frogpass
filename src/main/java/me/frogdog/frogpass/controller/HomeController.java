package me.frogdog.frogpass.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.password.Password;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    ArrayList<String> passwords = new ArrayList<>();

    @FXML
    private ListView<String> list;

    @FXML
    private Label user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }

    public void load() {
        Main.getInstance().getPasswordManager().getRegistry().forEach(p -> {
            passwords.add(p.getPassword());
        });

        list.getItems().addAll(passwords);
        user.setText("Logged in as " + Main.getInstance().getUserManager().getRegistry().get(0).getUsername());
    }

    private void reload() {
        list.getItems().clear();
        list.getItems().addAll(passwords);
    }

    public void remove() {
        int index = list.getSelectionModel().getSelectedIndex();
        Main.getInstance().getPasswordManager().getRegistry().remove(index);
        passwords.remove(index);
        reload();
    }

    public void add() {
            Stage addPopup = new Stage();

            TextField textField = new TextField();
            textField.setMaxWidth(200);
            textField.setAlignment(Pos.CENTER);
            textField.setPromptText("Password");

            Button button = new Button("Submit");
            button.setOnAction(event -> {
                passwords.add(textField.getText());
                Main.getInstance().getPasswordManager().register(new Password(textField.getText()));
                reload();
                addPopup.close();
            });

            VBox layout = new VBox(10);
            layout.getChildren().addAll(textField, button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout, 300, 150);

            addPopup.setTitle(Main.getInstance().TITLE + " " + Main.getInstance().VERSION);
            addPopup.setScene(scene);
            addPopup.showAndWait();
    }
}
