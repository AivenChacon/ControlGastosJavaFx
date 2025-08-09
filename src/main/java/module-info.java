module mx.edu.utch.gastosapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.junit.jupiter.api;
    requires java.sql;

    opens app to javafx.fxml;
    exports app;
    exports AppController;
    opens AppController to javafx.fxml;
    requires org.junit.platform.commons;

    opens model to javafx.fxml, org.junit.platform.commons;
    opens database to org.junit.platform.commons;

    exports model;
    exports database;
}