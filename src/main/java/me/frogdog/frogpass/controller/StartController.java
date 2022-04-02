package me.frogdog.frogpass.controller;

import javafx.event.ActionEvent;
import me.frogdog.frogpass.Controller;
import me.frogdog.frogpass.Main;

import java.io.IOException;

public class StartController {

    public void login(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "login.fxml");
    }

    public void close(ActionEvent event) throws IOException {
        Main.getInstance().close();
    }

}
