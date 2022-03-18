package DIV2_752;

import CodeForces.CodeForces;

import java.util.ArrayList;

public class A extends CodeForces {

    public static void main(String[] args) {
        int t =I();
        while(t-->0){
            int n = I();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i=0;i<n;i++){
                al.add(I());
            }
            solution(al,n);
        }
    }

    private static void solution(ArrayList<Integer> al, int n) {
       int op = 0;
        for (int i = 0; i < al.size(); i++) {
           if (al.get(i)>i){
               al.add(i,i);
               op++;
           }
        }
        System.out.println(op-1);
    }
}
