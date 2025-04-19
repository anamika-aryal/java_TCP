import java.io.*;
import java.net.*;
import java.util.*;

public class ClientChat {
    public static void main(String[] args) throws Exception {

        Socket s= new Socket("localhost",5000);

        Scanner scan= new Scanner(System.in);

        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dos= new DataOutputStream(s.getOutputStream());

        while(true){
            System.out.print("Client: ");

            String msg= scan.nextLine();

            dos.writeUTF(msg);

            if(msg.equalsIgnoreCase("bye")){
                System.out.println("Bye");
                break;
            }else{
                System.out.println("Server: "+ dis.readUTF());
            }
        }
        dos.close();
        dis.close();
        s.close();
        scan.close();
        
    }
}
