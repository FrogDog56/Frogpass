package me.frogdog.frogpass.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import me.frogdog.frogpass.Controller;

import java.io.IOException;
import java.util.Objects;

public class StartController {

    public void login(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "login.fxml");
    }

    public void register(ActionEvent event) throws IOException {
        Controller.getInstance().switchRoot(event, "register.fxml");
    }

}
