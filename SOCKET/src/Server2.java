import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws  IOException {
        ServerSocket ss2 = new ServerSocket(8081);
        Socket s2  = ss2.accept();
        System.out.println("Connection established...");

        OutputStream os2 = s2.getOutputStream();//creatin os to get data to send to the client
       // InputStream is1 = s2.getInputStream();

        PrintStream ps1 = new PrintStream(os2); //ps2 will be used to send data to the client

        //Now we can push anything to the client

        BufferedReader br1 = new BufferedReader(new InputStreamReader(s2.getInputStream()));//br1 will read data from the client

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));//I will read from the keyboard

        while (true){
            String msg1,msg2;//msg1 from client and msg2 from keyboard
            //Lets read the data coming from client
            while ((msg1 = br1.readLine()) !=null)
            {
                System.out.println(msg1);
                msg2 = br2.readLine();//now i will send reply to the client
                ps1.println(msg2);
            }//loop1 over then it will go to client and will wait for client to send a messg
            //thus this loop will continue
            System.exit(0);//to forcefully close te program
        }
    }
}
