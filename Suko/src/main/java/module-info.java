module mokira.suko {
    requires javafx.controls;
    requires javafx.fxml;

    opens mokira.suko to javafx.fxml;
    exports mokira.suko;
}
