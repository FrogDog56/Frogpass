module me.frogdog.application.password {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.datatransfer;
    requires java.desktop;

    opens me.frogdog.application to javafx.fxml;
    exports me.frogdog.application;
}