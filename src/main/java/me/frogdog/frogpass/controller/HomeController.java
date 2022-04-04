package me.frogdog.frogpass.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
        Main.getInstance().getPasswordManager().register(new Password("hecker"));
        reload();
    }

    public void reload() {
        Main.getInstance().getPasswordManager().getRegistry().forEach(p -> {
            passwords.add(p.getPassword());
        });

        list.getItems().addAll(passwords);
        user.setText("Logged in as " + Main.getInstance().getUserManager().getRegistry().get(0).getUsername());
    }
}
