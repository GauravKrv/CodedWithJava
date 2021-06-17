package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListQuery {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> al = new ArrayList(100000); //Initialisatoin of arraylist with constrained capacity
        for (int i =0;i<n;i++){
            int d = sc.nextInt();
            int ar[] = new int[d+1];  // Creating an array of size d i.e number of elements the line will contain
            ar[0] = d;
            for (int j = 1;j<=d;j++){
                ar[j] = sc.nextInt();
            }
            al.add(ar);               //storing array of size d as an element in our arrayList

        }
        int q = sc.nextInt();        //Query input
       // int a[][] = new int[n][50000]; ==> WILL GIVE RUNTIME ERROR -- heap memory outof space
        int a[][] = new int[n][];    //==>Will not give runtime error
        a = al.toArray(a);           //Converting our arraylist to a 2D array so that its elements of x line at y position could be accessed easily
        for (int i =0;i<q;i++){
            int x = sc.nextInt()-1;  // x = input-1; becoz the query which we would ask for will be of index+1 format
            int y = sc.nextInt();
            if (x<n && y<=a[x][0]) {
                System.out.println(a[x][y]);
            }else {
                System.out.println("ERROR!");
            }

        }


        /*QUESTION : LINK : https://www.hackerrank.com/challenges/java-arraylist/problem
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you
this feature. Try to solve this problem using Arraylist.
You are given  lines. In each line there are zero or more integers. You need to answer
 a few queries where you need to tell the number located in  position of  line.


Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

Constraints

Each number will fit in signed integer.
Total number of integers in  lines will not cross .

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!

        * */
 }
}
