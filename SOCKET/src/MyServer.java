import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    /*
    TWO TYPES OF SOCKET CLASS ARE THERE
    1.For the server to communicate with client => Inside .net package => ServerSocket class
    2.For the client to communicate with server ii.e client os sender => Inside .net package => Socket class
    3.Always server shold be run first before client
    * */

    public static void main(String[] args) throws IOException {

       /*       U1 :functoin of any protocol
                line confg
                 topologies
                 find number of cables

                             U2 : Guided media and its types
                             Multiplexing == diff between fdm and tdm
                             Diff modulation techniques
                             Switching = ckt and packet switching difference , types of packet switching

                             U3:ARQ Protocols , CSMA/CD and CS..,  HDLC,, PPP..,, Bluetooth - Any one from them
                             --Short - Errors,
                             Long quetion as a numerical from CRC. --

                */
        ServerSocket ss = new ServerSocket(8282);//1]Creating obj reference as window for a Server communication with client
        //& using port numbers as arguments[mstly 4 digited] and in range of 2bytes

        //2]To check whether client is active or not and is ready to accept my message
        Socket s = ss.accept();//If the client will be ready to accept the data then ss.accept() will return the object of  ..........

        System.out.println("Connection Established...........");//3]when we get this message ==> The connection is established

        //4]To send some data to client => some data is going away from us, so we will create an output stream.
        OutputStream os = s.getOutputStream();//Os will push the data to the client through some socket, and there will be some other Os which will push data from
        //Server to the socket first, This data will be used as InputStream by the client[bufferedReader may be reqd]

        PrintStream ps = new PrintStream(os);//4.2]ps will push data to "os" [and "os" will push data to the client later on] so we will write data to the "ps"

        //5]Writing data to "ps"=>from keybord,file or println
        ps.println("Hello Students");
        ps.println("How are you");
        ps.println("Bye");


    }
}
