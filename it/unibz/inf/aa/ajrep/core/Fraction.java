package it.unibz.inf.aa.ajrep.core;

import static java.lang.Math.abs;

/**
 * This class describes Fraction. Fractions are used in equation calculation.
 * 
 * @author Andrius
 */
public class Fraction {
    private int num, den;
    
    public Fraction () {
    }
    
    /**
     * Creates Fraction from double variable.
     * 
     * @param d 
     */
    public Fraction(double d) {
        boolean sign = d < 0 ? true : false;
        d = abs(d);
        String s = String.valueOf(d);
        int digitsDec = s.length() - 1 - s.indexOf('.');        

        int denominator = 1;
        for(int i = 0; i < digitsDec; i++){
           d *= 10;
           denominator *= 10;
        }
        int numerator = (int) Math.round(d);
        
        this.num = sign ? (-1) * numerator : numerator;
        this.den = denominator;
        
        this.simplify();
    }
    
    /**
     * Sets numerator & denominator of fraction.
     * 
     * @param num
     * @param den 
     */
    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
        
        this.simplify();
    }
    
    /**
     * 
     * @return numerator of fraction
     */
    public int getNumerator() {
        return num;
    }
    
    /**
     * 
     * @return denominator of fraction
     */
    public int getDenomintor() {
        return den;
    }
    
    /**
     * Sets numerator of fraction.
     * 
     * @param num 
     */
    public void setNumerator(int num) {
        this.num = num;
    }
    
    /**
     * Sets denominator of fraction.
     * 
     * @param den 
     */
    public void setDenominator(int den) {
        this.den = den;
    }
    
    /**
     * Simplifies Fraction.
     * 
     */
    public void simplify() {
        boolean sign = this.isNegative() ? true : false; 
        num = abs(num);
        den = abs(den);
        
        int n = num < den ? num : den;

        for (int i = n; i > 0; i--) {
            if (num % i == 0 && den % i == 0) {
                num = num / i;
                den = den /i;
                break;
            }
        }
        
        if (num == 0) {den = 0;}
        if (num == den && num != 0 && den != 0) {num = 1; den = 1;}
        
        num = sign ? (-1)*num : num;
    }
    
    /**
     * 
     * @return true if negative, false if not negative
     */
    public boolean isNegative() {
        if (num < 0 ^ den < 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @return true if positive, false if not positive
     */
    public boolean isPositive() {
        if (num > 0 && den > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @return true if fraction is zero, false if fraction not zero
     */
    public boolean isZero() {
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Changes fraction sign.
     */
    public void changeSign() {
        num = num * -1;
    }
    
    /**
     * @return Fraction like string
     */
    public String toString() {
        if (den == 1) {
            return "" + num;
        } else if (num == 0) {
            return "0";
        } else {
            return num + "/" + den;
        }
    }
}
