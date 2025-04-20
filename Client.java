import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {

        Scanner scan= new Scanner(System.in);

        System.out.println("Enter a string: ");
        String msg= scan.nextLine();

        Socket s= new Socket("localhost",5000);

        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dos= new DataOutputStream(s.getOutputStream());

        dos.writeUTF(msg);

        String s_msg= dis.readUTF();
        System.out.println("Server Replied: "+ s_msg);

        dos.close();
        dis.close();
        s.close();
        scan.close();
    }
}
