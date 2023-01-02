import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gupshup {

}
 enum Type{
    NORMAL,
     ZERO
        }
class ATM{
     Map<String,Type > acInfo = new HashMap<>();
     Map<String,Integer > acBal = new HashMap<>();

    public ATM(Map<String, Type> acInfo, Map<String, Integer> acBal) {
        this.acInfo = acInfo;
        this.acBal = acBal;
    }

    public int fetchBal(String acId) throws Exception {
         if (!acBal.containsKey(acId)){
             System.out.print("Path 1");
             throw new Exception("Account doesnt exists");
         }
        System.out.print("Path 2");
        return acBal.get(acId);
     }

}

class MainG{
    public static void main(String[] args) {
        Map<String,Type > acInfo = new HashMap<>();
        Map<String,Integer > acBal = new HashMap<>();
        acInfo.put("ac1",Type.NORMAL);
        acInfo.put("ac2",Type.ZERO);

        acBal.put("ac1",1);
        acBal.put("ac2",2);
        ATM ac1 = new ATM(acInfo,acBal);
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        if (type==1){
            String type1 = "dummy acc";
            try {
                ac1.fetchBal(type1);
            } catch (Exception e) {
                if (e.getMessage().equals("Account doesnt exists"))
                System.out.print(": "+true);
            }
        }

        if (type==2){
            String type1 = "ac1";
            try {
                if(ac1.fetchBal(type1)==1){
                    System.out.print(": "+true);
                }
            } catch (Exception e) {
                if (e.getMessage().equals("Account doesnt exists"))
                System.out.print(": "+true);
            }
        }
    }
}
