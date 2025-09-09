// Complex class to represent a complex number
class Complex {
    double real;
    double imaginary;

    // Constructor to initialize real and imaginary parts of the complex number
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to display the complex number
    public void display() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
        }
    }

    // Method to add two complex numbers (overloaded)
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Method to subtract two complex numbers (overloaded)
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Method to multiply two complex numbers (overloaded)
    public Complex multiply(Complex other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(realPart, imaginaryPart);
    }

    // Method to divide two complex numbers (overloaded)
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(realPart, imaginaryPart);
    }
}

// AdvancedComplex class that extends Complex class for additional features (Inheritance)
class AdvancedComplex extends Complex {

    // Constructor that calls the constructor of Complex class
    public AdvancedComplex(double real, double imaginary) {
        super(real, imaginary);
    }

    // Method to calculate the magnitude (modulus) of the complex number
    public double magnitude() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Method to calculate the conjugate of the complex number
    public Complex conjugate() {
        return new Complex(real, -imaginary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create two complex numbers
        Complex c1 = new Complex(4, 3);
        Complex c2 = new Complex(2, 5);

        System.out.println("Complex Number 1: ");
        c1.display();

        System.out.println("Complex Number 2: ");
        c2.display();

        // Add the complex numbers
        Complex sum = c1.add(c2);
        System.out.println("Addition of Complex Numbers: ");
        sum.display();

        // Subtract the complex numbers
        Complex difference = c1.subtract(c2);
        System.out.println("Subtraction of Complex Numbers: ");
        difference.display();

        // Multiply the complex numbers
        Complex product = c1.multiply(c2);
        System.out.println("Multiplication of Complex Numbers: ");
        product.display();

        // Divide the complex numbers
        Complex quotient = c1.divide(c2);
        System.out.println("Division of Complex Numbers: ");
        quotient.display();

        // Using AdvancedComplex class to calculate magnitude and conjugate
        AdvancedComplex ac1 = new AdvancedComplex(4, 3);
        System.out.println("Magnitude of Complex Number 1: " + ac1.magnitude());
        Complex conjugate = ac1.conjugate();
        System.out.println("Conjugate of Complex Number 1: ");
        conjugate.display();
    }
}
