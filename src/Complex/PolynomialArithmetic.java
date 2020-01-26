package Complex;

public class PolynomialArithmetic {
    private Polynomial firstPolynomial;
    private Polynomial secondPolynomial;

    public PolynomialArithmetic(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        this.firstPolynomial = firstPolynomial;
        this.secondPolynomial = secondPolynomial;
    }

    public Polynomial addPoly() {
        Polynomial resultPoly = new Polynomial();
        for (Term term : this.firstPolynomial.getTerms()) {
            Term matchingTerm;
            Term resultTerm;
            if ((matchingTerm = secondPolynomial.findTerm(term.getExponent())) != null) {
                resultTerm = new Term(term.getCoeffiecient() + matchingTerm.getCoeffiecient(), term.getExponent());
            } else {
                resultTerm = term;
            }
            resultPoly.getTerms().add(resultTerm);
        }
        for (Term term : this.secondPolynomial.getTerms()) {
            if ((resultPoly.findTerm(term.getExponent())) == null) {
                resultPoly.getTerms().add(term);
            }
        }
        resultPoly = resultPoly.sortPolynomialDescending();
        resultPoly.clear();
        return resultPoly;

    }

    public Polynomial subPoly() {
        Polynomial resultPoly = new Polynomial();
        for (Term term : this.firstPolynomial.getTerms()) {
            Term matchingTerm;
            Term resultTerm;
            if ((matchingTerm = secondPolynomial.findTerm(term.getExponent())) != null) {
                resultTerm = new Term(term.getCoeffiecient() - matchingTerm.getCoeffiecient(), term.getExponent());
            } else {
                resultTerm = term;
            }
            resultPoly.getTerms().add(resultTerm);
        }
        for (Term term : this.secondPolynomial.getTerms()) {
            if ((resultPoly.findTerm(term.getExponent())) == null) {
                resultPoly.getTerms().add(new Term(-term.getCoeffiecient(), term.getExponent()));
            }
        }
        resultPoly = resultPoly.sortPolynomialDescending();
        resultPoly.clear();
        return resultPoly;
    }

    public Polynomial dividePoly(int numberOfTerms) {
        Polynomial firstPolynomialAscending = firstPolynomial.sortPolynomialAscending();
        Polynomial secondPolynomialAscending = secondPolynomial.sortPolynomialAscending();
        Polynomial resultPoly = new Polynomial();
        PolynomialArithmetic polynomialArithmetic;
        secondPolynomialAscending.clear();
        while (!firstPolynomialAscending.getTerms().isEmpty() && numberOfTerms > 0) {
            firstPolynomialAscending.clear();
            float multiplierCoeff = firstPolynomialAscending.getTerms().get(0).getCoeffiecient() / secondPolynomialAscending.getTerms().get(0).getCoeffiecient();
            int multiplierExp = firstPolynomialAscending.getTerms().get(0).getExponent() - secondPolynomialAscending.getTerms().get(0).getExponent();
            Term multiplierTerm = new Term(multiplierCoeff, multiplierExp);
            resultPoly.getTerms().add(multiplierTerm);
            Polynomial multipliedPoly = secondPolynomialAscending.multiplyAtTerm(multiplierTerm).sortPolynomialAscending();
            polynomialArithmetic = new PolynomialArithmetic(firstPolynomialAscending, multipliedPoly);
            firstPolynomialAscending = polynomialArithmetic.subPoly().sortPolynomialAscending();
            --numberOfTerms;
        }
        return resultPoly;
    }

    public Polynomial mulPoly() {
        Polynomial result = new Polynomial();
        for (Term term : this.firstPolynomial.getTerms()) {
            for (Term secondTerm : this.secondPolynomial.getTerms()) {
                Term newTerm = new Term(term.getCoeffiecient() * secondTerm.getCoeffiecient(), term.getExponent() + secondTerm.getExponent());
                result.getTerms().add(newTerm);
            }
        }
        return result;
    }

    public Polynomial calcDerivative(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Term term : polynomial.getTerms()) {
            result.getTerms().add(new Term(term.getCoeffiecient() * term.getCoeffiecient(), term.getExponent() - 1));
        }
        return result;
    }

    public Polynomial calcIntegral(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Term term : polynomial.getTerms()) {
            result.getTerms().add(new Term(term.getCoeffiecient() * 1 / (term.getExponent() + 1), term.getExponent() + 1));
        }
        return result;
    }

    public static Polynomial modifyPolynomial(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Term term : polynomial.getTerms()) {
            Term newTerm = new Term(term.getCoeffiecient(), -term.getExponent());
            result.getTerms().add(newTerm);
        }
        return result;
    }

}
