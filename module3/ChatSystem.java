import java.net.*;
import java.io.*;

public class ChatSystem {
    private static final int PORT = 5000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            runServer();
        } else {
            runClient();
        }
    }

    private static void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            
            String message;
            while (true) {
                if (in.ready()) {
                    message = in.readLine();
                    if (message == null || message.equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.println("Client: " + message);
                }
                
                if (consoleIn.ready()) {
                    message = consoleIn.readLine();
                    out.println(message);
                    if (message.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            }
            
            System.out.println("Chat ended.");
            clientSocket.close();
            
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void runClient() {
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Connected to server.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            
            String message;
            while (true) {
                if (in.ready()) {
                    message = in.readLine();
                    if (message == null || message.equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.println("Server: " + message);
                }
                
                if (consoleIn.ready()) {
                    message = consoleIn.readLine();
                    out.println(message);
                    if (message.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            }
            
            System.out.println("Chat ended.");
            
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
} 