package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String name=sc.nextLine();
            int phone=sc.nextInt();
            map.put(name,phone);

           sc.nextLine();//This is must
        }
        while(sc.hasNext())//Nice trick for while loop continuous inputs
        {
            String s=sc.nextLine();
            if (map.containsKey(s)){
                System.out.println(s +"="+map.get(s));
            }else {
                System.out.println("Not found");
            }
        }
    }

}
