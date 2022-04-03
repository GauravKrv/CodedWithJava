package DIV_779;

import CodeForces.CodeForces;

import java.util.Scanner;

public class A extends CodeForces {
    public static void main(String[] args) {
       /* int t = I();
        while (t-->0){
            int n = I();
            String s = S();
            solution2(n,s);
        }*/
        // Your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String s = sc.next();
        int n =0;
        int t = 0;
        for(int i=0;i<x;i++){
            if(s.charAt(i)=='N'){
                System.out.println(s.charAt(i)+"  -> ");
                n++;
            }else{
                t++;
            }
        }
        if(n>t)
        { System.out.println("Nutan");}
        else{
            System.out.println("Tulsa");
        }

    }
    public static void solution2(int n,String s){
        int c =0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i)=='0'){
                if (i-2>=0 && s.charAt(i-2)=='0'&&s.charAt(i-1)=='1'){
                    c++;
                }else if(s.charAt(i-1)=='0'){
                    c+=2;
                }
            }
        }
        System.out.println(c);
    }

    private static void solution(int n, String s) {
        if (n==1&&s.charAt(0)=='0'){
            System.out.println(1);
            return;
        }
        if (n==1&&s.charAt(0)=='1'){
            System.out.println(0);
            return;
        }
        int count = 0;

        boolean f = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i-1)=='0'&&s.charAt(i)=='0'){
                count+=2;
            }else if(s.charAt(i-1)=='0'&&s.charAt(i)=='1'){
                f = true;
            }else if(s.charAt(i-1)=='1'&&s.charAt(i)=='0'){
                if (f){
                    count+=1;

                }


            }else{
                f = false;
            }
        }
//        System.out.println();
        System.out.println(count);
    }
}


class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] nm = new int[n][m];
            for (int i = 0; i <n; i++) {
                for (int j = 0; j < m; j++) {
                    nm[i][j] = sc.nextInt();
                }
            }
            if (n==1){

                    for (int j = 0; j < m-1; j++) {
                       if(nm[0][j] != nm[0][j+1]){
                           System.out.println("NO");
                           break;
                       }

                }
            }

            if (m==1){

                for (int j = 0; j < n-1; j++) {
                    if(nm[j][0] != nm[j][0]){
                        System.out.println("NO");
                        break;
                    }

                }
            }
                boolean flag = true;
            if (n==1&&m==1){
                System.out.println("YES");
                continue;
            }
            if (nm[0][0]!=nm[n-1][m-1]){
                System.out.println("NO");
                continue;
            }
            for (int i = n-1; i >0; i--) {
                for (int j = m-1; j >0; j--) {
                    if (nm[i][j]==0){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                    if (nm[i][j]>(nm[i-1][j]+nm[i][j-1])){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
                if (!flag){
                    break;
                }
            }

            if (!flag){
                continue;
            }
            for (int i = 0;i<m-1;i++){
                if (nm[0][i]==nm[0][i+1]){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if (!flag){
                continue;
            }
            System.out.println("YES");
        }

    }
}
