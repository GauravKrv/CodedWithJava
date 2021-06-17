package Q13;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[20];
        Scanner s =new Scanner(System.in);
        System.out.println("ENTER ELEMENTS OF FIRST ARRAY: ");
        for(int i=0;i<10;i++){
            arr1[i] = s.nextInt();
        }
        System.out.println("ENTER ELEMENTS OF SECOND ARRAY: ");

        for(int i=0;i<10;i++){
            arr2[i] = s.nextInt();
        }
        for(int i=0,j=-10;i<20;i++,j++){
            if(i<10) {
                arr3[i] = arr1[i];
            }
            if(i<20 && i>=10) {
                arr3[i] = arr2[j];
            }
        }
        System.out.println("ELEMENTS OF THIRD ARRAY ARE: ");

        for(int i=0;i<20;i++){
            System.out.println(arr3[i]);
        }

    }
}
/*OUTPUT:
ENTER ELEMENTS OF FIRST ARRAY:
1
2
3
4
5
6
7
8
9
10
ENTER ELEMENTS OF SECOND ARRAY:
11
22
33
44
55
66
77
88
99
009
ELEMENTS OF THIRD ARRAY ARE:
1
2
3
4
5
6
7
8
9
10
11
22
33
44
55
66
77
88
99
9
*/
