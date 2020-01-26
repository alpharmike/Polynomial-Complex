package Complex;

public class PolarComplex implements Complex {
    private double radius;
    private double theta;

    public PolarComplex(double radius, double theta) {
        this.radius = radius;
        this.theta = theta;
    }

    @Override
    public double getMagnitude() {
        return radius;
    }

    @Override
    public double getAngle() {
        return theta;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    @Override
    public double getArg() {
        if (this.theta > -Math.PI && this.theta <= Math.PI) {
            return this.theta;
        }
        double principleValue = this.theta;
        while (principleValue > Math.PI) {
            principleValue -= 2 * Math.PI;
        }
        while (principleValue <= -Math.PI) {
            principleValue += 2 * Math.PI;
        }
        return principleValue;
    }

    @Override
    public Complex getConjugate() {
        return new PolarComplex(radius, -theta);
    }

    @Override
    public Complex convert() {
        double real = radius * Math.cos(theta);
        double imaginary = radius * Math.sin(theta);
        return new CartesianComplex(real, imaginary);
    }

    @Override
    public Complex getCosine() {
        double real = this.radius * Math.cos(theta);
        double imaginary = this.radius * Math.sin(theta);
        double newReal = Math.cos(real) * Math.cosh(imaginary);
        double newImaginary = -Math.sin(real) * Math.sinh(imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getSine() {
        double real = this.radius * Math.cos(theta);
        double imaginary = this.radius * Math.sin(theta);
        double newReal = Math.sin(real) * Math.cosh(imaginary);
        double newImaginary = Math.cos(real) * Math.sinh(imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getHyperbolicCosine() {
        double real = this.radius * Math.cos(theta);
        double imaginary = this.radius * Math.sin(theta);
        double newReal = Math.cosh(real) * Math.cos(imaginary);
        double newImaginary = Math.sinh(real) * Math.sin(imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getHyperbolicSine() {
        double real = this.radius * Math.cos(theta);
        double imaginary = this.radius * Math.sin(theta);
        double newReal = Math.sinh(real) * Math.cos(imaginary);
        double newImaginary = Math.cosh(real) * Math.sin(imaginary);
        return new CartesianComplex(newReal, newImaginary);
    }

    @Override
    public Complex getPrincipleLogarithm() {
        double real = Math.log(this.radius);
        double imaginary = this.getArg();
        return new CartesianComplex(real, imaginary);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Complex getPower(double power) {
        double newRadius = Math.pow(radius, power);
        double newTheta = theta * power;
        return new PolarComplex(newRadius, newTheta);
    }

    @Override
    public String toString() {
        return String.format("%.3g exp((%.3g)i) (%.3g(%.3g + i * %.3g))", radius, theta, radius, Math.cos(theta), Math.sin(theta));
    }

}
