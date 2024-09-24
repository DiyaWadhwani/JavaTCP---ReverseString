import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Server <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Server is in passive mode, waiting for a connection
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Reading the string sent by the client
                String clientMessage = input.readLine();

                // Input validation on the server (optional, redundant since client validates)
                if (clientMessage == null || clientMessage.isEmpty()) {
                    System.out.println("Error: Received an empty string from the client.");
                    return;
                }
                if (clientMessage.length() > 80) {
                    System.out.println("Error: Received a string exceeding 80 characters.");
                    return;
                }

                // Process the string: reverse characters and change capitalization
                String processedMessage = processString(clientMessage);

                // Send the processed message back to the client
                output.println(processedMessage);
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Helper method to reverse characters and reverse capitalization
    private static String processString(String input) {
        StringBuilder sb = new StringBuilder(input.length());

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.reverse().toString();
    }
}
