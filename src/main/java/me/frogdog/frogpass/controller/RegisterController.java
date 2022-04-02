package me.frogdog.frogpass.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.frogdog.frogpass.Controller;
import me.frogdog.frogpass.Main;
import me.frogdog.frogpass.user.User;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void back(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "start.fxml");
    }

    public void register(ActionEvent event) throws IOException {
        Main.getInstance().getUserManager().register(new User(username.getText(), password.getText()));
    }
}
