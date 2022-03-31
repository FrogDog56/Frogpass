package me.frogdog.frogpass.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    String[] passwords = {"hecks"};

    @FXML
    private ListView<String> list;

    @FXML
    private Label user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }

    public void load() {
        list.getItems().addAll(passwords);
        user.setText("Logged in as FrogDog");
    }
}
