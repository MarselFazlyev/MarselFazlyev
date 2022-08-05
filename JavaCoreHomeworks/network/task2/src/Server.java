import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 15131;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientsocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))) {
            System.out.println("New connection accepted");
            out.println("Write your name");
            String name = in.readLine();
            System.out.println(name);
            out.println(name + ",are you child?");
            String answer = in.readLine();
            System.out.println(answer);
            if (answer.equals("yes")) {
                out.println("Welcome to the kids area," + name + " Let's play!");
            } else {
                out.println("Welcome to the adult zone," + name + " a good rest, or a good working day!");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

