import java.io.*;

public class BufferReader {
    String name;
    char gender;
    int age;
    float marks;
    boolean married;
    public static void main(String[] args) throws IOException {
       /* BufferReader sir = new BufferReader();
       //InputStreamReader isr  = new InputStreamReader(System.in);//first way of using is by creating object of InputStreamReader class and then using it in bufferedreader calss
        //BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //second way of using is by cfreating anonymous object of InputStreamReader class

        sir.name = br.readLine();
        System.out.println(sir.name);*/


       /*OUTPUT OF BELOW CODE : Surendra
Male
15
188
true
Our teacher name is SurendraKumar and he is a M and his age is +30and he is married = true so he got marks = 94.0
*/
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferReader sir  = new BufferReader();
       sir.name = br.readLine()+ "Kumar";
       sir.gender = br.readLine().charAt(0);
       sir.age = Integer.parseInt(br.readLine()) * 2;
       sir.marks = Float.parseFloat(br.readLine()) / 2;
       sir.married = Boolean.parseBoolean(br.readLine());

        System.out.println("Our teacher name is "+sir.name + " and he is a "+sir.gender+" and his age is +"+sir.age+"and he is married = "+sir.married +" so he got marks = "+sir.marks);
    }
}
