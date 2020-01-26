package Complex;

public class PolarArithmetic implements ComplexArithmetic {
    private PolarComplex firstNumber;
    private PolarComplex secondNumber;

    public PolarArithmetic(PolarComplex firstNumber, PolarComplex secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public Complex add() {
        double real = firstNumber.getRadius() * Math.cos(firstNumber.getAngle()) + secondNumber.getRadius() * Math.cos(secondNumber.getAngle());
        double imaginary = firstNumber.getRadius() * Math.sin(firstNumber.getAngle()) + secondNumber.getRadius() * Math.sin(secondNumber.getAngle());
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex subtract() {
        double real = firstNumber.getRadius() * Math.cos(firstNumber.getAngle()) - secondNumber.getRadius() * Math.cos(secondNumber.getAngle());
        double imaginary = firstNumber.getRadius() * Math.sin(firstNumber.getAngle()) - secondNumber.getRadius() * Math.sin(secondNumber.getAngle());
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex multiply() {
        double radius = firstNumber.getRadius() * secondNumber.getRadius();
        double theta = firstNumber.getAngle() + secondNumber.getRadius();
        return new PolarComplex(radius, theta);
    }

    @Override
    public Complex divide() {
        double radius = firstNumber.getRadius() / secondNumber.getRadius();
        double theta = firstNumber.getAngle() - secondNumber.getAngle();
        return new PolarComplex(radius, theta).convert();

    }
}
