import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
        String host ="localhost";
        int port = 15132;
        String message = "Marsel";

        try(Socket socket = new Socket(host,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(message);
            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

