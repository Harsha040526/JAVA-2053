import java.util.Scanner;

public class HttpHeaderAnalyzer {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            
            System.out.print("Enter a URL (e.g., https://www.google.com): ");
            String inputUrl = sc.nextLine();

           
            URL url = new URL(inputUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            
            connection.setRequestMethod("GET");
            connection.connect();

            
            System.out.println("\n=== HTTP RESPONSE INFO ===");
            System.out.println("Request Method: " + connection.getRequestMethod());
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());

            
            System.out.println("\n=== HTTP HEADERS ===");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = String.join(", ", entry.getValue());
                if (key == null)
                    System.out.println(value); 
                else
                    System.out.println(key + ": " + value);
            }

        
            System.out.println("\n=== FIRST FEW LINES OF CONTENT ===");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                int count = 0;
                while ((line = br.readLine()) != null && count < 10) {
                    System.out.println(line);
                    count++;
                }
            }

            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
