class A {
  
    void add(int a, int b) {
        int sum = a + b;
        System.out.println("Sum of integers = " + sum);
    }

    // Add function for doubles
    void add(double a, double b) {
        double sum = a + b;
        System.out.println("Sum of doubles = " + sum);
    }
}


class B {
    void add(String str1, String str2) {
        String result = str1 + str2; 
        System.out.println("Concatenated String = " + result);
    }
}


public class Main {
    public static void main(String[] args) {
     
        B objB = new B();
        objB.add("Hello, ", "World!");

       
        A objA = new A();
        objA.add(10, 20);
        objA.add(5.5, 4.5);
    }
}
