package me.frogdog.frogpass.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.frogdog.frogpass.Controller;
import me.frogdog.frogpass.Main;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    private boolean usernameCheck;
    private boolean passwordCheck;

    public void login(ActionEvent event) throws IOException {
        if (Main.getInstance().getUserManager().getRegistry().get(0).getUsername().equals(username.getText())) {
            usernameCheck = true;
        }

        if (Main.getInstance().getUserManager().getRegistry().get(0).getPassword().equals(password.getText())) {
            passwordCheck = true;
        }

        if (usernameCheck && passwordCheck) {
            Controller.getInstance().switchRoot(event, "home.fxml");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "start.fxml");
    }
}
