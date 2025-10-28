import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class WebsiteInfoViewer {   // <-- This is the MAIN CLASS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1. Ask user for website URL
            System.out.print("Enter a URL (e.g., https://www.google.com): ");
            String inputUrl = sc.nextLine();

            // 2. Create URL and open connection
            URL url = new URL(inputUrl);
            URLConnection connection = url.openConnection();

            // 3. Display basic info
            System.out.println("\n=== WEBSITE INFORMATION ===");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Content Type: " + connection.getContentType());

            // 4. Display date information (if available)
            long date = connection.getDate();
            if (date != 0)
                System.out.println("Date: " + new Date(date));
            else
                System.out.println("Date: Not available");

            // 5. Display content length (if available)
            int length = connection.getContentLength();
            if (length != -1)
                System.out.println("Content Length: " + length + " bytes");
            else
                System.out.println("Content Length: Not available");

            // 6. Display first few lines of webpage content
            System.out.println("\n=== FIRST FEW LINES OF CONTENT ===");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < 10) { // show only first 10 lines
                System.out.println(line);
                count++;
            }

            br.close();
            System.out.println("\n=== END OF PREVIEW ===");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
