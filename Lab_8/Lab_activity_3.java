import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FindIPAddress {  // <-- This is the MAIN CLASS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1. Display your computer's IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("=== YOUR COMPUTER INFORMATION ===");
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());

            // 2. Accept a domain name from the user
            System.out.print("\nEnter a domain name (e.g., www.google.com): ");
            String domain = sc.nextLine();

            // 3. Print all IP addresses of that domain
            System.out.println("\n=== IP ADDRESSES FOR " + domain + " ===");
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve the host. Please check the domain name.");
        } finally {
            sc.close();
        }
    }
}
