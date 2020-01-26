package Complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polynomial {
    private List<Term> terms = new ArrayList<Term>();

    public Polynomial() {
        this.terms = new ArrayList<>();
    }

    public Polynomial(List<Term> terms) {
        this.terms = terms;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    public int getMaxExponent() {
        int maxExponent;
        maxExponent = this.terms.get(0).getExponent();
        for (Term term : this.terms) {
            if (term.getExponent() > maxExponent) {
                maxExponent = term.getExponent();
            }
        }
        return maxExponent;

    }

    public Polynomial sortPolynomialDescending() {
        Polynomial sortedPolynomial = new Polynomial();
        for (Term term : this.terms) {
            if (sortedPolynomial.terms.isEmpty()) {
                sortedPolynomial.getTerms().add(term);
            } else {
                int index = 0;
                boolean inserted = false;
                for (Term availableTerm : sortedPolynomial.getTerms()) {
                    if (availableTerm.getExponent() > term.getExponent()) {
                        ++index;
                    } else {
                        sortedPolynomial.getTerms().add(index, term);
                        inserted = true;
                        break;
                    }
                }
                if (!inserted) {
                    sortedPolynomial.getTerms().add(term);
                }
            }
        }
        return sortedPolynomial;
    }

    public Polynomial sortPolynomialAscending() {
        Polynomial reversedPolynomial = new Polynomial(this.terms);
        Collections.reverse(reversedPolynomial.terms);
        return reversedPolynomial;
    }

    public Term findTerm(int exponent) {
        for (Term term : this.terms) {
            if (term.getExponent() == exponent) {
                return term;
            }
        }
        return null;
    }

    public Polynomial multiplyAtTerm(Term term) {
        Polynomial resultPoly = new Polynomial();
        for (Term availableTerm : this.terms) {
            resultPoly.getTerms().add(new Term(availableTerm.getCoeffiecient() * term.getCoeffiecient(), availableTerm.getExponent() + term.getExponent()));
        }
        return resultPoly;
    }

    public void clear() {
        for (Term term : this.terms) {
            if (term.getCoeffiecient() == 0) {
                this.terms.remove(term);
            }
        }
    }
}
