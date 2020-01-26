import Complex.Polynomial;
import Complex.PolynomialArithmetic;
import Complex.Term;

import java.util.ArrayList;

public class Series {

    public static Polynomial laurentSeries(Polynomial poly1, Polynomial poly2, int numberOfTerms) {
        Polynomial result;
        PolynomialArithmetic polynomialArithmetic = new PolynomialArithmetic(poly1, poly2);
        result = polynomialArithmetic.dividePoly(numberOfTerms);
        return result;
    }

    public static Polynomial taylorSeries(Polynomial numerator, Polynomial denominator, int numberOfTerms) {
        Polynomial modifiedNumerator = PolynomialArithmetic.modifyPolynomial(numerator);
        Polynomial modifiedDenominator = PolynomialArithmetic.modifyPolynomial(denominator);
        PolynomialArithmetic polynomialArithmetic = new PolynomialArithmetic(modifiedNumerator, modifiedDenominator);
        Polynomial result = polynomialArithmetic.dividePoly(numberOfTerms);
        Polynomial finalResult = PolynomialArithmetic.modifyPolynomial(result);
        return result;
    }
}
