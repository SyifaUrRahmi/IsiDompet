module com.dompet {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dompet to javafx.fxml;
    exports com.dompet;
}
