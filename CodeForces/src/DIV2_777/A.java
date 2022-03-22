package DIV2_777;

import CodeForces.CodeForces;

public class A extends CodeForces {


    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            solution(n);
        }
    }

    public static String solutionUtil(int n,String st,String ed){
        boolean flag = true;
        StringBuilder s = new StringBuilder("");
        int sum = 0;
        while(sum<n){
            if (flag){
                s.append(st);
                sum+=Integer.parseInt(st);
                if (sum<n && sum+Integer.parseInt(ed)>n){
                    break;
                }
                flag = false;
            }else {
                s.append(ed);
                sum+=Integer.parseInt(ed);
                if (sum<n && sum+Integer.parseInt(st)>n){
                    break;
                }
                flag = true;
            }
        }
//        System.out.println(s);
        return s.toString();
    }

    private static void solution(int n) {
        if (n==1){
            System.out.println(1);
            return;
        }

        String s1 = solutionUtil(n,"1","2");
        String s2 = solutionUtil(n,"2","1");
        if(s1.length()>s2.length()){
            System.out.println(s1);
        }else{
            System.out.println(s2);
        }
    }

    static void otherSolution(int n){

    }
}
//11 -> 12121212
//17 ->