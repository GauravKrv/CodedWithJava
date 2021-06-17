import java.util.Scanner;

public class TryDataTypes {

        public static void main(String []argh)
        {



            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();

            for(int i=0;i<t;i++)
            {

                try
                {
                    long x=sc.nextInt();
                    System.out.println(x+" can be fitted in:");
                    if(x>=-128 && x<=127)System.out.println("* byte");
                    if(x>=-32768 && x<=32767)System.out.println("* short");
                    if(x>=-2147483648 && x<=2147483647)System.out.println("* int");
                    System.out.println("* long");
                   // if((x >= -9223372036854775808) && (x <= 9223372036854775807))System.out.println("* long");
                    //Complete the code
                }
                catch(Exception e)
                {
                    System.out.println(sc.next()+" can't be fitted anywhere.");
                }



            }
        }


/*2.
Input Format

Read some unknown  lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.

Output Format

For each line, print the line number, followed by a single space, and then the line content received as input.
* */
     static class Solution2 {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scan = new Scanner(System.in);
            for(int i = 1; scan.hasNext()== true; i++){
                System.out.println(i + " " + scan.nextLine());
            }
        }
    }





}

//3.EXCEPTION


 class Solution {

    static Scanner sc = new Scanner(System.in);
    static int B=sc.nextInt();
    static int H=sc.nextInt();
    static boolean flag = true;

    static void check(){
        if(B<=0 || H<=0 ){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }


    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class


