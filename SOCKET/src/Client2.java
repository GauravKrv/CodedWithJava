import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.43.232",8081);



        InputStream is = s.getInputStream();//2]Creating input stream for client which it will recive from the socket
        BufferedReader br1  = new BufferedReader(new InputStreamReader(is));//We will not use System.in as we will reciveve data from is or InputStream
        BufferedReader br2  = new BufferedReader(new InputStreamReader(System.in));//We will not use System.in as we will reciveve data from is or InputStream

        OutputStream os2 = s.getOutputStream();//creatin os to get data to send to the sever
        // InputStream is1 = s2.getInputStream();

        PrintStream ps1 = new PrintStream(os2); //ps2 will be used to send data to the server


        String msg1,msg2;
        //Loop will be reqd to
        while (!(msg1 = br2.readLine()).equals("exit")) {//till our data send is not equal to exit,kep on communicating

        ps1.println(msg1);
        msg2 = br1.readLine();
            System.out.println(msg2);

        }

//to make it multiple client, we can change in loop by having an array of messages instead of strings
    }
}
