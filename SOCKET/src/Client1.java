import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws IOException {
        //1]We will require a client communication window object or Socket class object
        Socket s  =new Socket("192.168.43.232",8281);//Specifying our ipaddress,,or the ip address of the server will be provided here
        //If i have to communicate with a friend then we hve to provide his ip address as the server ip address.

        InputStream is = s.getInputStream();//2]Creating input stream for client which it will recive from the socket
        BufferedReader br  = new BufferedReader(new InputStreamReader(is));//We will not use System.in as we will reciveve data from is or InputStream

        //3]To retrive all data from server line by line and print them
        String msg;
        while ((msg = br.readLine())!= null){
            System.out.println(msg);
        }//Thus both of our client and server are ready to run.
        //We can do some modification to make complete chatting application
//When I compile and run the client then
    }
}
