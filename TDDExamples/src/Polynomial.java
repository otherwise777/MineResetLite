//# BEGIN SKELETON

/**
 * Abstract Data Type for mutable
 * <a href="http://en.wikipedia.org/wiki/Polynomial"><i>polynomials</i></a>
 * with integer coefficients and one real-valued indeterminate ({@code x}). A
 * polynomial has a
 * <a
 * href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial"><i>degree</i></a>:
 * the largest exponent with non-zero coefficient. If all coefficients are zero,
 * the degree is defined to be minus one (in this ADT; elsewhere, you can find
 * other definitions).
 * <p>
 * There are constructors for the zero polynomial and for a polynomial of the
 * form {@code c * x^n} (monomial) for given non-zero {@code c} and non-negative
 * {@code n}.
 * <p>
 * There are queries for getting the degree, the coefficient of a term with
 * given exponent, and the value of the polynomial for a given value of the
 * indeterminate {@code x}.
 * <p>
 * There are operations to add two polynomials and to multiply two polynomials.
 * <p>
 * Contracts will be expressed in terms of a model. We ignore overflow problems.
 * <p>
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="green"><b>Ligtenberg Wouter 0864271 24-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public abstract class Polynomial {

    /**
     * Checks whether the representation invariants hold.
     *
     * @return whether the representation invariants hold
     * @throws IllegalStateException if precondition violated
     * @pre representation invariants hold
     * @modifies None
     * @post {@code \result}
     */
    public abstract boolean isRepOk() throws IllegalStateException;

    /**
     * Constructs the zero polynomial (all coefficients are zero).
     *
     * @pre true
     * @post {@code this == 0}
     */
    public Polynomial() {
    }

    /**
     * Constructs a monomial (one-term polynomial) with given coefficient and
     * degree.
     *
     * @param c the coefficient
     * @param n the exponent
     * @pre {@code c != 0 && 0 <= n}
     * @throws IllegalArgumentException if precondition violated
     * @post {@code this == c * x^n}
     */
    public Polynomial(int c, int n) throws IllegalArgumentException {
    }

//# BEGIN TODO Specifications of the operations
//  Specification:
    /**
     * Adds 2 polynomials
     *
     * @throws IllegalStateException if precondition violated
     * @pre {@code isPolynomial(a, b) && isPolynomial(c, d)}
     * @param a base of first polynomial
     * @param b exponent of first polynomial
     * @param c base of second polynomial
     * @param d exponent of second polynomial
     * @post {@code this == \old(this) plus [ (c, d) ]}
     */
    public abstract void add(int a, int b, int c, int d) throws IllegalStateException;

    /**
     * multiples 2 polynomials.
     *
     * @param a base of first polynomial
     * @param b exponent of first polynomial
     * @param c base of second polynomial
     * @param d exponent of second polynomial
     * @throws IllegalStateException if precondition violated
     * @pre {@code isPolynomial(a, b) && isPolynomial(c, d)}
     */
    public abstract void multiply(int a, int b, int c, int d) throws IllegalStateException;

    /**
     * gets the degree of the polynomial.
     *
     * @param a base of polynomial
     * @param b exponent of polynomial
     * @return {@code \return == a}
     * @throws IllegalStateException if precondition violated
     * @pre {@code isPolynomial(a, b)}
     */
    public abstract int getdegree(int a, int b) throws IllegalStateException;

    /**
     * gets the coefficient of the polynomial.
     *
     * @param term term pf the polynomial
     * @param exponent exponent of the polynomial
     * @return {@code \return == exponent}
     * @throws IllegalStateException if precondition violated
     * @pre {@code isPolynomial(a, b)}
     */
    public abstract int getcoefficient(int term, int exponent) throws IllegalStateException;

    /**
     * gets the value of the indeterminate
     *
     * @param a base of polynomial
     * @param b exponent of polynomial
     * @return {@code \return == a^b}
     * @throws IllegalStateException if precondition violated
     * @pre {@code isPolynomial(a, b)}
     */
    public abstract int getValueOfIndeterminate(int a, int b) throws IllegalStateException;

//# END TODO
}
//# END SKELETON
