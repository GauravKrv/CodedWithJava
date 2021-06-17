import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        int num,req,j=0;
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];

        Scanner s =new Scanner(System.in);
        System.out.println("ENTER NO OF ELEMENTS OF ARRAY: ");
        num =s.nextInt();
        System.out.println("ENTER ELEMENTS OF ARRAY: ");
        for(int i=0;i<num;i++){
            arr1[i] = s.nextInt();
        }
        System.out.println("ENTER ELEMENT TO SEARCH IN ARRAY: ");

        req =s.nextInt();
        for(int i=0;i<num;i++){
            if(arr1[i]==req){
            arr2[j] = i;
            j++;
        }}
        System.out.println("INDEXES OF THE GIVEN ELEMENT IN ARRAY: ");

        for(int i=0;i<j;i++){
            System.out.print(arr2[i] + ", ");
        }

    }
}
/*OUTPUT->
 ENTER NO OF ELEMENTS OF ARRAY:
20
ENTER ELEMENTS OF ARRAY:
1
2
3
1
2
3
1
2
3
1
2
3
1
2
3
1
2
3
1
2
ENTER ELEMENT TO SEARCH IN ARRAY:
3
INDEXES OF THE GIVEN ELEMENT IN ARRAY:
2, 5, 8, 11, 14, 17,
*/