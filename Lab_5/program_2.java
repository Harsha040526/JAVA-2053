import java.util.Scanner;


class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class Main {


    public static void checkPassword(String password) throws WeakPasswordException {
        if (password.length() < 6) {
            throw new WeakPasswordException("Password too short! Must be at least 6 characters.");
        } else {
            System.out.println("Password accepted.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            checkPassword(password);
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
