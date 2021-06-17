import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {

        System.out.println("Enter number of columns : ");
        Scanner s = new Scanner(System.in);
        int inputRow = s.nextInt();
        int n = (inputRow + 1) / 2;
        int i, j, p1=1,p2=0,x=1;
        char c = 'B';
        for (i = 1; i <=n; i++) {
            for (j = 1; j < 2 * n; j++) { //NEXT COLUMN
                if (i%2==0){ //IF row number = even
                    if (j>n-i && j< n+i){
                            if (p1>p2){
                                System.out.print(" "+x+" ");
                                x+=2; p2++;
                            }else {
                                System.out.print(" "+c+" ");
                                c+=2;p1++;
                            }
                    }else {
                            System.out.print("   ");
                        } }
                if (i%2!=0){ //IF row number = odd
                    if (j>n-i && j< n+i){
                            if (p1>p2){
                                System.out.print(" "+x+" ");
                                x+=2; p2++;
                            }else {
                                System.out.print(" "+c+" ");
                                c+=2;
                                p1++; }
                    }else {
                            System.out.print("   ");
                        } } }
            System.out.println(); //NEXT LINE
            p1=1;p2=0;x=1;c='B';
            } //NEXT ROW
    }}