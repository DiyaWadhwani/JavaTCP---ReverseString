import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Client <server IP> <port>");
            return;
        }

        String serverIP = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(serverIP, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverResponse = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Prompt the user to enter a string
            System.out.print("Enter text (up to 80 characters): ");
            String userText = input.readLine();

            // Input validation
            if (userText == null || userText.isEmpty()) {
                System.out.println("Error: You must enter a non-empty string.");
                return;
            }
            if (userText.length() > 80) {
                System.out.println("Error: The input string exceeds 80 characters.");
                return;
            }

            // Send the user input to the server
            output.println(userText);

            // Receive and display the response from the server
            String response = serverResponse.readLine();
            System.out.println("Response from server: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
