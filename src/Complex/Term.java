package Complex;

public class Term {
    private float coefficient;
    private int exponent;

    public Term(float coeffiecient, int exponent) {
        this.coefficient = coeffiecient;
        this.exponent = exponent;
    }

    public float getCoeffiecient() {
        return coefficient;
    }

    public void setCoeffiecient(float coeffiecient) {
        this.coefficient = coeffiecient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
}
