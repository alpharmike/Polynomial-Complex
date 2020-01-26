package Complex;

public interface Complex {
    double getMagnitude();
    double getAngle();
    double getArg();
    Complex getConjugate();
    Complex convert();
    Complex getCosine();
    Complex getSine();
    Complex getHyperbolicCosine();
    Complex getHyperbolicSine();
    Complex getPrincipleLogarithm();
}
