import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        
        ServerSocket ss= new ServerSocket(5000);
        System.out.println("Server Running in 5000");

        Socket s= ss.accept();
        System.out.println("Client connected on port =" + s.getPort());

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos= new DataOutputStream(s.getOutputStream());

        String msg= dis.readUTF();

        dos.writeUTF(msg.toUpperCase());

        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}
