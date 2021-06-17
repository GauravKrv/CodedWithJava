import java.util.Scanner;

public class SolutionQ1Apex {


    public static int solve1(int A) {
        int c = A/2;
        int sum=0;
        int i=0;
        while((c*i)<A)
        {
            i++;
        }

        sum = c+i;
        return sum;
    }

    public static int solve2(int A) {
        int x = 1;
        int y =1;
        int min = A+1;
        for(int i = 1;i<=A/2;i++){
            x = i;
            for(int j =1;j<=A/2;j++) {
                y = j;
                if (x * y > A) {

                    if (min > x + y) {
                        min = x + y;
                    }
                }
            }
        }

        return min;
    }
    public static int solve3(int A) {
        int c = 0;

        if((A%2)==0)
            c=A/2;
        else
            c=A%2;

        int sum=0;
        int i=0;
        while((c*i)<A)
        {
            i++;
        }

        sum = c+i;
        return sum;


    }



    public static void main(String[] args) {
        int op = 8,a,b;
        while (op>0) {
           a = solve2(op);
           b = solve3(op);
            System.out.println(a);
            System.out.println(b);

            if (a!=b){
                System.out.println("Not matched at index = "+op);
                break;
            }
            op++;
        }

    }
    }
