package Complex;

public class CartesianComplex implements Complex {
    private double real;
    private double imaginary;
    public CartesianComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public double getMagnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    @Override
    public double getAngle() {
        double angle = Math.atan(imaginary / real);
        if (this.real < 0) { // angles between pi / 2 and 3pi / 2
            return angle + Math.PI;
        } else {
            return angle;
        }
    }

    @Override
    public double getArg() { // the principle value of theta which is between -pi and pi
        double angle = this.getAngle();
        if (angle > -Math.PI && angle <= Math.PI) {
            return angle;
        }
        while (angle > Math.PI) {
            angle -= 2 * Math.PI;
        }

        while (angle <= -Math.PI) {
            angle += 2 * Math.PI;
        }
        return angle - 2 * Math.PI;
    }

    @Override
    public Complex getConjugate() {
        return new CartesianComplex(real, -imaginary);
    }

    @Override
    public Complex convert() {
        double radius = getMagnitude();
        double angle = getAngle();
        return new PolarComplex(radius, angle);
    }

    @Override
    public Complex getCosine() {
        double newReal = Math.cos(this.real) * Math.cosh(this.imaginary);
        double newImaginary = -Math.sin(this.real) * Math.sinh(this.imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getSine() {
        double newReal = Math.sin(this.real) * Math.cosh(this.imaginary);
        double newImaginary = Math.cos(this.real) * Math.sinh(this.imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getHyperbolicCosine() {
        double newReal = Math.cosh(this.real) * Math.cos(this.imaginary);
        double newImaginary = Math.sinh(this.real) * Math.sin(this.imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getHyperbolicSine() {
        double newReal = Math.sinh(this.real) * Math.cos(this.imaginary);
        double newImaginary = Math.cosh(this.real) * Math.sin(this.imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getPrincipleLogarithm() {
        double magnitude = this.getMagnitude();
        double newReal = Math.log(magnitude);
        double newImaginary = this.getArg();
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return String.format("%.3g + (%.3g)i", this.real, this.imaginary);
    }
}
