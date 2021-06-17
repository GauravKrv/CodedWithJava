import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        System.out.println("Enter number of columns: ");
        Scanner s = new Scanner(System.in);
        int inputRow = s.nextInt();
        int n = (inputRow + 1) / 2;
        int i, j, k;
        for (i = 0; i < n; i++) {
            for(j=1;j<2*n;j++){  //FOR UPPER HALF
                if(j== n+i || j== n-i){
                    System.out.print(" * ");
                }else {
                    if(i==n-1&&j==n){
                        System.out.print(" # ");
                    }else {
                        System.out.print("   ");
                    }
                }

            }
            System.out.println(); //NEXT LINE
        }
        for(k = n-2;k>=0;k--){  //FOR LOWER HALF
            for(j=1;j<2*n;j++){
                if(j==(n+k) || j==(n-k) ){
                    System.out.print(" * ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println(); //NEXT LINE
        }
    }

}
