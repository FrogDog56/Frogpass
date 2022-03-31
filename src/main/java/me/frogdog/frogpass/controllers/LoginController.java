package me.frogdog.frogpass.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.frogdog.frogpass.Controller;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void login(ActionEvent event) throws IOException {
        if (username.getText().equalsIgnoreCase("FrogDog")) {
            Controller.getInstance().switchRoot(event, "home.fxml");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "start.fxml");
    }
}
