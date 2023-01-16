module com.franciscodelosrios.proyctohilos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.franciscodelosrios.proyctohilos to javafx.fxml;
    exports com.franciscodelosrios.proyctohilos;
}