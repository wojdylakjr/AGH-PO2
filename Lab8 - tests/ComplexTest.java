import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class ComplexTest {
    //konstruktory
    @Test
    public void constructorTest1() {
        Complex a = new Complex();
        assertEquals("0.0 + 0.0i", a.toString());
    }

    @Test
    public void constructorTest2() {
        Complex a = new Complex(2);
        assertEquals("2.0 + 0.0i", a.toString());
    }

    @Test
    public void constructorTest3() {
        Complex a = new Complex(1, 2);
        assertEquals("1.0 + 2.0i", a.toString());
    }

    @Test
    public void constructorTest4() {
        Complex a = new Complex(1, -2);
        assertEquals("1.0 - 2.0i", a.toString());
    }

    @Test
    public void constructorTest5() {
        Complex a = new Complex(1, 0);
        assertEquals("1.0 + 0.0i", a.toString());
    }

    //gettery i settery
    @Test
    public void setterAndGetterTest1() {
        Complex a = new Complex();
        a.set(1, 1);
        assertEquals(1.0, a.getIm(),0);
        assertEquals(1.0, a.getRe(),0);
    }

    @Test
    public void setterAndGetterTest2() {
        Complex a = new Complex();
        a.setRe(1);
        a.setIm(2);
        assertEquals(2, a.getIm(),0);
        assertEquals(1, a.getRe(),0);
    }

    @Test
    public void setterTest() {
        Complex a = new Complex();
        a.setRe(1);
        a.setIm(-2);
        assertEquals("1.0 - 2.0i", a.toString());
    }

    //mod
    @Test
    public void modTest() {
        Complex a = new Complex(3, 4);
        assertEquals(5, a.mod(),0);
    }

    @Test
    public void modTest2() {
        Complex a = new Complex(-3, -4);
        assertEquals(5, a.mod(),0);
    }

    @Test
    public void modTest3() {
        Complex a = new Complex(0, -4);
        assertEquals(4, a.mod(),0);
    }

    //conjugate
    @Test
    public void conjugateTest1() {
        Complex a = new Complex(0, -4);
        Complex b = a.conjugate();
        assertEquals(4, b.getIm(),0);
    }

    @Test
    public void conjugateTest2() {
        Complex a = new Complex(5, 3);
        Complex b = a.conjugate();
        assertEquals("5.0 - 3.0i", b.toString());
    }

    //oppposite

    @Test
    public void oppositeTest1() {
        Complex a = new Complex(2, -4);
        Complex b = a.opposite();
        assertEquals(4, b.getIm(),0);
        assertEquals(-2, b.getRe(),0);
    }

    @Test
    public void oppositeTest2() {
        Complex a = new Complex(10, 3);
        Complex b = a.opposite();
        assertEquals("-10.0 - 3.0i", b.toString());
    }

    //add
    @Test
    public void addTest1() {
        Complex a = new Complex(10, 3);
        Complex b = a.opposite();
        assertEquals("0.0 + 0.0i", Complex.add(a, b).toString());
    }

    @Test
    public void addTest2() {
        Complex a = new Complex(-10, 3);
        assertEquals("10.0 + 3.0i", Complex.add(a, 20).toString());
    }

    @Test
    public void addTest3() {
        Complex a = new Complex(-10, 3);
        assertEquals("10.0 + 3.0i", Complex.add(20,a).toString());
    }

    //substraction
    @Test
    public void subtractionTest1() {
        Complex a = new Complex(10, 3);
        Complex b = a.opposite();
        assertEquals("20.0 + 6.0i", Complex.minus(a, b).toString());
    }

    @Test
    public void subtractionTest2() {
        Complex a = new Complex(-10, 3);
        assertEquals("-30.0 + 3.0i", Complex.minus(a, 20).toString());
    }

    //multiply
    @Test
    public void multiplyTest1() {
        Complex a = new Complex(10, 3);
        Complex b = a.opposite();
        assertEquals("-91.0 - 60.0i", Complex.multiply(a, b).toString());
    }

    @Test
    public void multiplyTest2() {
        Complex a = new Complex(-10, 3);
        assertEquals("-20.0 + 6.0i", Complex.multiply(a, 2).toString());
    }
}