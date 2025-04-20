import java.io.*;
import java.net.*;

public class Server1 {
    public static void main(String[] args) throws Exception{
        ServerSocket ss= new ServerSocket(5000);

        System.out.println("Server Connected in 5000");

        Socket s= ss.accept();
        System.out.println("Client Connected in "+ s.getPort());

        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dos= new DataOutputStream(s.getOutputStream());

        int num = dis.readInt();

        dos.writeInt(num*num);
        
        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}
