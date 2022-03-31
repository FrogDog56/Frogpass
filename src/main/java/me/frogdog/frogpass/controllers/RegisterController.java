package me.frogdog.frogpass.controllers;

import javafx.event.ActionEvent;
import me.frogdog.frogpass.Controller;

import java.io.IOException;

public class RegisterController {

    public void back(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "start.fxml");
    }
}
