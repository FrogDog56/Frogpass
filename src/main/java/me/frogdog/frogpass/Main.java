package me.frogdog.frogpass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.frogdog.frogpass.password.PasswordManager;
import me.frogdog.frogpass.user.UserManager;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.util.Objects;

public class Main extends Application {
    public static final String TITLE = "Frogpass";
    public static final String VERSION = "v1.0";
    public static Main INSTANCE = null;
    private final UserManager userManager;
    private final PasswordManager passwordManager;
    private final File directory;

    private final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private final int centerX = (int) ((d.getWidth() - 500) / 2);
    private final int centerY = (int) ((d.getHeight() - 400) / 2);

    public Main() {
        INSTANCE = this;

        this.directory = new File(System.getProperty("user.home"), "frogpass");

        if (!this.directory.exists()) {
            this.directory.mkdir();
        }

        this.userManager = new UserManager();
        this.userManager.load();
        this.passwordManager = new PasswordManager();
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("start.fxml")));
            Scene scene = new Scene(root);
            stage.setMinWidth(500);
            stage.setMinHeight(400);
            stage.setX(centerX);
            stage.setY(centerY);
            stage.setTitle(TITLE + " " + VERSION);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static Main getInstance() {
        return INSTANCE;
    }

    public PasswordManager getPasswordManager() {
        return this.passwordManager;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public File getDirectory() {
        return this.directory;
    }
}