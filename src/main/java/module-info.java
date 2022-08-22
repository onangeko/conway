module com.example.conway {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.conway to javafx.fxml;
    opens view to javafx.fxml;

    exports com.example.conway.model to javafx.graphics;
}
