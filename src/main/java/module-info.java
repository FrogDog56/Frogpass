module me.frogdog.frogpass {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.datatransfer;
    requires java.desktop;
    requires com.google.gson;

    opens me.frogdog.frogpass to javafx.fxml;
    exports me.frogdog.frogpass;

    opens me.frogdog.frogpass.controllers to javafx.fxml;
    exports me.frogdog.frogpass.controllers;
}