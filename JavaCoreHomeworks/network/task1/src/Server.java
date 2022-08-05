import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

    public static void main(String[] args){
        int port = 15132;
        try (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientsocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()))){

            System.out.println("New connection accepted");
            final String name = in.readLine();
            out.printf("Hi %s, your port is %d%n", name, clientsocket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

