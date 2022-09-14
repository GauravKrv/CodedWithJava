package wipro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TargetTvs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String goal = sc.nextLine();
        String target = sc.nextLine();
        System.out.println(solve(goal,target));

    }
    private static int solve(String goal, String target) {
        StringTokenizer st = new StringTokenizer(target);
        ArrayList<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        while (st.hasMoreTokens()){
            String curr = st.nextToken();
            al.add(curr);
            sb.append(curr);
        }
        int s = 0;
        for (int i = 1; i <= goal.length(); i++) {
            if (al.contains(goal.substring(s,i))){
                s = i;
            }
        }
        if (s!=goal.length()){
            return 0;
        }else{
            return 1;
        }
    }


    //        if (String.valueOf(sb).equals(goal)){
//            return 1;
//        }
//        else {
//            return 0;
//        }


}
