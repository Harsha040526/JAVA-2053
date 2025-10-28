package lab1.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {   
    public static void main(String[] args) {
        final int PORT = 12345; 

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client on port " + PORT + "...");

            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);

                
                out.println("Server received: " + message);

              
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
            }

           
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Server stopped.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
