import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 15131;
        String name = "Marsel";

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(in.readLine());
            out.println(name);
            System.out.println(in.readLine());
            out.println("no");
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

