import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {

        ServerSocket ss= new ServerSocket(5000);
        System.out.println("server running");

        Socket s= ss.accept();
        System.out.println("Client connected in= "+s.getPort());

        Scanner scan= new Scanner(System.in);

        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
        while(true){
            String client= dis.readUTF();

            System.out.println("Client: "+client);

            if(client.equalsIgnoreCase("bye")){
                break;
            }else{
                System.out.print("Server: ");

            String server= scan.nextLine();

            dos.writeUTF(server);
            }

            
        }

        dos.close();
        dis.close();
        ss.close();
        s.close();
        scan.close();
    }
}
