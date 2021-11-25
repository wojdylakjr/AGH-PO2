import java.lang.Math;

public class Complex {
    private double im;
    private double re;

    public Complex() {
        this.im = 0;
        this.re = 0;
    }

    public Complex(double Re) {
        this.im = 0;
        this.re = Re;
    }

    public Complex(double Re, double Im) {
        this.im = Im;
        this.re = Re;
    }

    @Override
    public String toString() {
        if (this.im >= 0) {
            return "" + this.re + " + " + this.im + "i";
        } else {
            return "" + this.re + " - " + Math.abs(this.im) + "i";
        }

    }

    public double getIm() {
        // return 0;
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getRe() {
        // return 0;
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double mod() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
        // return 0;
    }

    public Complex conjugate() {
        // this.im = 0 - this.im;
        return new Complex(this.re, -this.im);
    }

    public Complex opposite() {
        return new Complex(-this.re, -this.im);
    }

    //dodawania
    public static Complex add(Complex a, Complex b) {
        return new Complex(a.re + b.re, a.im + b.im);

    }

    public static Complex add(double a, Complex b) {
        Complex c = new Complex(a);
        return Complex.add(c, b);
    }

    public static Complex add(Complex a, double b) {
        Complex c = new Complex(b);
        return Complex.add(a, c);
    }

    //odejmowanie
    public static Complex minus(Complex a, Complex b) {
        return new Complex(a.re - b.re, a.im - b.im);

    }

    public static Complex minus(double a, Complex b) {
        Complex c = new Complex(a);
        return Complex.minus(c, a);
    }

    public static Complex minus(Complex a, double b) {
        Complex c = new Complex(b);
        return Complex.minus(a, c);
    }

    //mnozenie
    public static Complex multiply(Complex a, Complex b) {
        return new Complex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);

    }

    public static Complex multiply(double a, Complex b) {
        Complex c = new Complex(a);
        return Complex.multiply(c, b);
    }

    public static Complex multiply(Complex a, double b) {
        Complex c = new Complex(b);
        return Complex.multiply(a, c);
    }

    //dzielenie
    public static Complex divide(Complex a, Complex b) {
        return new Complex((a.re * b.re + a.im * b.im) / b.re * b.re, a.im * b.re - a.re * b.im);

    }

    public static Complex divide(double a, Complex b) {
        Complex c = new Complex(a);
        return Complex.divide(c, b);
    }

    public static Complex divide(Complex a, double b) {
        Complex c = new Complex(b);
        return Complex.divide(a, c);
    }


    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Complex other = (Complex) obj;
        if (Double.doubleToLongBits(im) != Double.doubleToLongBits(other.im))
            return false;
        return Double.doubleToLongBits(re) == Double.doubleToLongBits(other.re);
    }


}