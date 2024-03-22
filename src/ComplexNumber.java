

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    public static ComplexNumber add(ComplexNumber x, ComplexNumber y){
        return new ComplexNumber(x.getReal()+y.getReal(),x.getImaginary()+y.getImaginary());

    }
    public static ComplexNumber mulityply(ComplexNumber x, ComplexNumber y){
        return new ComplexNumber(x.getReal()*y.getReal()-x.getImaginary()*y.getImaginary(),x.getImaginary()*y.getReal()+x.getReal()*y.getImaginary());

    }
    public static double absoluteValue(ComplexNumber x){
        return Math.sqrt(x.getReal()*x.getReal()+x.getImaginary()*x.getImaginary());
    }
}
