import java.util.Scanner;
import java.util.Vector;

public class JumpGame {

    static boolean canJump(Vector<Integer> num){
        int n = num.size();
        int goodPos = n-1;
        for(int i = n-1;i>=0;i--){
            if(i+num.elementAt(i) == goodPos){
                goodPos = i;
            }

        }
        if(goodPos == 0){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) {

        /*System.out.println("Enter size of the array: ");
        int n = sc.nextInt();*/
        int i=0;
        Vector<Integer> vec = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the list, enter -1 to stop taking input: ");
        vec.add(sc.nextInt());i++;
        while (vec.elementAt(i-1)!=-1) {
          vec.add(sc.nextInt());
          i++;
      }
        vec.removeElementAt(i-1);
        System.out.println(canJump(vec));

    }
}
