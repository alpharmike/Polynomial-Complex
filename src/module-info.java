module ComplexGUI {
    requires javafx.fxml;
    requires javafx.controls;

    exports Complex;
    opens Complex;
    opens sample;
}