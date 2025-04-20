import java.io.*;
import java.net.*;
import java.util.*;

public class Client1 {
    public static void main(String[] args) throws Exception {

        Socket s= new Socket("localhost",5000);

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number");
        int a= scan.nextInt();

        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        dos.writeInt(a);

        int respnse= dis.readInt();

        System.out.println("Server Response= "+ respnse);
        scan.close();
        dos.close();
        dis.close();
        s.close();
        
    }
    
}
