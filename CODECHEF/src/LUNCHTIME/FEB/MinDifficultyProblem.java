package LUNCHTIME.FEB;

import java.util.ArrayList;
import java.util.Scanner;

public class MinDifficultyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int iter=9;
        long max = 0,difficulty=0;
        while (t-->0){
            ArrayList<Long> A = new ArrayList();
            for (int i= 1;i<=10;i++){
                A.add(sc.nextLong());
            }
            long k = sc.nextLong();

            //get max difficulty problems value
            while (iter-->0){
                if (max<k)
                   // max =  A.get(iter);
                  //  difficulty = iter+1;

                    max = max+A.get(iter);

                    if (max>=k){
                        max   = iter+1;
                    }
                 }

            if (k == 0){
                System.out.println(difficulty);
            }



        }
    }
}
