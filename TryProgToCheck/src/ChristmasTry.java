import java.util.Scanner;

public class ChristmasTry {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME : ");
        String name = "MERRY CHRISTMAS "+sc.nextLine();
        System.out.println();
        int init = 11;
        int c = 11 + init, d = 11 + init;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 21 + init; j++) {
                if (j >= c && j <= d) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            c--;
            d++;
            System.out.println();
        }


        int c2 = 4 + init, d2 = 18 + init;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 26 + init; j++) {
                if (j >= c2 && j <= d2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            c2--;
            d2++;
            System.out.println();
        }
        for (int i = 0; i <= d2; i++) {
            if (i >= c2)
                System.out.print("*");
            else System.out.print(" ");
        }
        System.out.println();


        int c3 = 2 + init, d3 = 21 + init;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 27 + init; j++) {
                if (j >= c3 && j <= d3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            c3--;
            d3++;
            System.out.println();
        }
        for (int j = c3; j > 0; j--) {
            for (int i = 0; i <= d3; i++) {
                if (i >= c3)
                    System.out.print("*");
                else System.out.print(" ");
            }
            c3--;
            d3++;
            System.out.println();
        }
        for (int j=1;j<init;j++) {
            for (int i = 0; i < d3; i++) {
                if (i >=init+5 && i <= 18+init) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("*******  "+name+"  *******");
    }
}
