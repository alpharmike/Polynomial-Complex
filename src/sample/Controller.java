package sample;

import Complex.CartesianArithmetic;
import Complex.CartesianComplex;
import Complex.Complex;
import Complex.PolarArithmetic;
import Complex.PolarComplex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    @FXML
    private TextField real1;
    @FXML
    private TextField real2;
    @FXML
    private TextField imaginary1;
    @FXML
    private TextField imaginary2;
    @FXML
    private TextField radius1;
    @FXML
    private TextField radius2;
    @FXML
    private TextField theta1;
    @FXML
    private TextField theta2;
    @FXML
    private TextField cartesianResult;
    @FXML
    private TextField polarResult;
    @FXML
    private TextField firstValueField;
    @FXML
    private TextField secondValueField;
    @FXML
    private TextField extraResult;
    @FXML
    private ChoiceBox modeChoice = new ChoiceBox();
    @FXML
    private Label firstValueLabel;
    @FXML
    private Label secondValueLabel;
    @FXML
    private Button magnitude;
    @FXML
    private Button cartAdd;

    private CartesianComplex cartesianComplex1;
    private CartesianComplex cartesianComplex2;
    private  CartesianComplex extraCartesianComplex;
    private  PolarComplex extraPolarComplex;
    private PolarComplex polarComplex1;
    private PolarComplex polarComplex2;
    private CartesianArithmetic cartesianArithmetic;
    private PolarArithmetic polarArithmetic;
    private Complex resultInCartesian;
    private Complex resultInPolar;

    private boolean init = false;

    public double getValue(TextField textField) {
        String inputValue = textField.getText();
        double value;
        try {
            value = Double.parseDouble(inputValue);
            return value;
        } catch (Exception exception) {
            return Double.NEGATIVE_INFINITY;
        }
    }

    public boolean initCartesianValues() {
        double real1Value = getValue(real1);
        double real2Value = getValue(real2);
        double imaginary1Value = getValue(imaginary1);
        double imaginary2Value = getValue(imaginary2);
        if (real1Value == Double.NEGATIVE_INFINITY || real2Value == Double.NEGATIVE_INFINITY || imaginary1Value == Double.NEGATIVE_INFINITY || imaginary2Value == Double.NEGATIVE_INFINITY) {
            return false;
        }
        cartesianComplex1 = new CartesianComplex(real1Value, imaginary1Value);
        cartesianComplex2 = new CartesianComplex(real2Value, imaginary2Value);
        cartesianArithmetic = new CartesianArithmetic(cartesianComplex1, cartesianComplex2);
        return true;
    }

    public boolean initPolarValues() {
        double radius1Value = getValue(radius1);
        double radius2Value = getValue(radius2);
        double theta1Value = getValue(theta1);
        double theta2Value = getValue(theta2);
        if (radius1Value == Double.NEGATIVE_INFINITY || radius2Value == Double.NEGATIVE_INFINITY || theta1Value == Double.NEGATIVE_INFINITY || theta2Value == Double.NEGATIVE_INFINITY) {
            return false;
        }
        polarComplex1 = new PolarComplex(radius1Value, theta1Value);
        polarComplex2 = new PolarComplex(radius2Value, theta2Value);
        polarArithmetic = new PolarArithmetic(polarComplex1, polarComplex2);
        return true;
    }

    public Complex initExtraValues() {
        double firstValue = getValue(firstValueField);
        double secondValue = getValue(secondValueField);
        if (firstValue == Double.NEGATIVE_INFINITY || secondValue == Double.NEGATIVE_INFINITY) {
            return null;
        }
        if (modeChoice.getValue() == "Cartesian") {
            if (extraCartesianComplex == null) {
                extraCartesianComplex = new CartesianComplex(firstValue, secondValue);
                return extraCartesianComplex;
            }
            else {
                extraCartesianComplex.setReal(firstValue);
                extraCartesianComplex.setImaginary(secondValue);
                return extraCartesianComplex;
            }
        } else {
            if (extraPolarComplex == null) {
                extraPolarComplex = new PolarComplex(firstValue, secondValue);
                return extraPolarComplex;
            }
            else {
                extraPolarComplex.setRadius(firstValue);
                extraPolarComplex.setTheta(secondValue);
                return extraPolarComplex;
            }
        }
    }

    public void cartesianAdd() {
        if (!initCartesianValues()) {
            handleException();
            return;
        }
        resultInCartesian = cartesianArithmetic.add();
        this.cartesianResult.setText(resultInCartesian.toString());
    }

    public void cartesianSubtract() {
        if (!initCartesianValues()) {
            handleException();
            return;
        }
        resultInCartesian = cartesianArithmetic.subtract();
        this.cartesianResult.setText(resultInCartesian.toString());

    }

    public void cartesianMultiply() {
        if (!initCartesianValues()) {
            handleException();
            return;
        }
        resultInCartesian = cartesianArithmetic.multiply();
        this.cartesianResult.setText(resultInCartesian.toString());
    }

    public void cartesianDivide() {
        if (!initCartesianValues()) {
            handleException();
            return;
        }
        resultInCartesian = cartesianArithmetic.divide();
        this.cartesianResult.setText(resultInCartesian.toString());

    }

    public void polarAddFunc() {
        if (!initPolarValues()) {
            handleException();
            return;
        }
        resultInPolar = polarArithmetic.add();
        this.polarResult.setText(resultInPolar.toString());
    }

    public void polarSubtract() {
        if (!initPolarValues()) {
            handleException();
            return;
        }
        resultInPolar = polarArithmetic.subtract();
        this.polarResult.setText(resultInPolar.toString());
    }

    public void polarMultiply() {
        if (!initPolarValues()) {
            handleException();
            return;
        }
        resultInPolar = polarArithmetic.multiply();
        this.polarResult.setText(resultInPolar.toString());
    }

    public void polarDivide() {
        if (!initPolarValues()) {
            handleException();
            return;
        }
        if (!initPolarValues()) {
            handleException();
            return;
        }
        this.polarResult.setText(resultInPolar.toString());
    }

    public void initChoice() {
        if (init) {
            return;
        }
        ObservableList<String> modes = FXCollections.observableArrayList();
        modes.addAll("Cartesian", "Polar");
        modeChoice.getItems().setAll(modes);
        modeChoice.setOnAction(actionEvent -> updateMode());
        init = true;
    }

    public void updateMode() {
        if (modeChoice == null || modeChoice.getItems() == null) {
            return;
        }
        String mode = modeChoice.getValue().toString();
        if (mode.equals("Cartesian")) {
            firstValueLabel.setText("Real");
            secondValueLabel.setText("Imaginary");
        } else {
            firstValueLabel.setText("Radius");
            secondValueLabel.setText("Theta");
        }
    }

    public void getMagnitude() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        double magnitude = complex.getMagnitude();
        extraResult.setText(String.valueOf(magnitude));
    }

    public void getArgValue() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        double argValue = complex.getArg();
        extraResult.setText(String.valueOf(argValue));

    }

    public void getConjugate() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex conjugate = complex.getConjugate();
        extraResult.setText(conjugate.toString());
    }

    public void convertMode() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex convertedComplex = complex.convert();
        extraResult.setText(convertedComplex.toString());
    }

    public void getSine() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex sineComplex = complex.getSine();
        extraResult.setText(sineComplex.toString());
    }

    public void getCosine() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex cosineComplex = complex.getCosine();
        extraResult.setText(cosineComplex.toString());
    }

    public void getSinh() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex sinhComplex = complex.getHyperbolicSine();
        extraResult.setText(sinhComplex.toString());
    }

    public void getCosh() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex coshComplex = complex.getHyperbolicCosine();
        extraResult.setText(coshComplex.toString());
    }

    public void getLogarithm() {
        Complex complex = initExtraValues();
        if (complex == null) {
            handleException();
            return;
        }
        Complex logComplex = complex.getPrincipleLogarithm();
        extraResult.setText(logComplex.toString());
    }

    public void handleException() {
        PopupView.display("Error", "An error occurred while handling your request, this might be due to invalid parameters passed to the fields");
    }







}
