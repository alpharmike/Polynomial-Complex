package Complex;

public class CartesianArithmetic implements ComplexArithmetic {
    private CartesianComplex firstNumber;
    private CartesianComplex secondNumber;

    public CartesianArithmetic(CartesianComplex firstNumber, CartesianComplex secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public Complex add() {
        double real = firstNumber.getReal() + secondNumber.getReal();
        double imaginary = firstNumber.getImaginary() + secondNumber.getImaginary();
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex subtract() {
        double real = firstNumber.getReal() - secondNumber.getReal();
        double imaginary = firstNumber.getImaginary() - secondNumber.getImaginary();
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex multiply() {
        double real = (firstNumber.getReal() * secondNumber.getReal()) - (firstNumber.getImaginary() - secondNumber.getImaginary());
        double imaginary = (firstNumber.getReal() * secondNumber.getImaginary() + secondNumber.getReal() * firstNumber.getImaginary());
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex divide() {
        double radius = firstNumber.getMagnitude() / secondNumber.getMagnitude();
        double theta = firstNumber.getAngle() - secondNumber.getAngle();
        return new PolarComplex(radius, theta);
    }
}
