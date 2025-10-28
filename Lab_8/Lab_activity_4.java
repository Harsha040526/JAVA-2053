package lab1.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WhoisLookup {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
           
            System.out.print("Enter a domain name (e.g., example.com): ");
            String domain = sc.nextLine();

         
            Socket socket = new Socket("whois.internic.net", 43);
            System.out.println("\nConnected to whois.internic.net on port 43...");

            
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

      
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            System.out.println("\n=== WHOIS INFORMATION ===");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

           
            in.close();
            out.close();
            socket.close();
            System.out.println("\nConnection closed.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
