import java.util.Scanner;


class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class Main {
  
    public static void checkAge(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("You must be at least 18 years old!");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = scanner.nextInt();
            checkAge(age);
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }

        scanner.close();
    }
}
