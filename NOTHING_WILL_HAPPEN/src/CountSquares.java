import java.util.Scanner;

public class CountSquares {
    //WORKS
    public static long getDiagonals(int r,int c){
        int biggerdimension = Integer.max(r,c);
        int smallerdimension = Integer.min(r,c);
        int maxdimensionsquare = smallerdimension/2;
        if (smallerdimension%2!=0) maxdimensionsquare = maxdimensionsquare + 1;
        long numofsquares = 0;
        for (int i=2;i<=maxdimensionsquare;i++){
            numofsquares += (long) (smallerdimension - (i + i - 2)) * (smallerdimension-(i+i-2));
        }

        int left = biggerdimension-smallerdimension;
        numofsquares = numofsquares + (numofsquares * left); //add rest combination like sliding window

        return numofsquares;
    }

  //works
    public static long getSecondDiagonals(int r,int c){

        int biggerdimension = Integer.max(r,c);
        int smallerdimension = Integer.min(r,c);
        if (smallerdimension<4) return 0;

        int numofsquares = (smallerdimension-3) * (smallerdimension-3);


        int left = biggerdimension-smallerdimension;
        numofsquares = numofsquares + (numofsquares * left); //add rest combination like sliding window

        return numofsquares* 2L;
    }




//WORKS
    public static long getHorizontals(int r,int c){
        int biggerdimension = Integer.max(r,c);
        int smallerdimension = Integer.min(r,c);
        long numofsquares = 0;
        for (int i=3;i<=smallerdimension;i++){ //calcu;ate from 2unit square
            numofsquares += (long) (smallerdimension - (i - 1)) * (smallerdimension-(i-1));
        }

        int left = biggerdimension-smallerdimension;
        numofsquares = numofsquares + (numofsquares * left) + ((long) (smallerdimension - 1) *(biggerdimension-1)); //add 1unit squares and the rest combinatoinds

        return numofsquares;
    }

//psvm for kickstart format
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 1;
        while (i<=t) {
            int r = sc.nextInt();
            int c = sc.nextInt();


            System.out.println("Case #"+i+": " + (getHorizontals(r, c) + getDiagonals(r, c) + getSecondDiagonals(r, c)) % 1000000007);//returning answer with modulo
        i++;
        }
        sc.close();
    }
}

//my trying psvm
/*

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (t-->0) {
            int r = 1000;
            int c = 500;
            System.out.println("Diagonal = " + getDiagonals(r, c));
            System.out.println("Horizontal = " + getHorizontals(r, c));

            System.out.println("Total = " + (getHorizontals(r, c) + getDiagonals(r, c) + getSecondDiagonals(r, c)) % 1000000007);//returning answer with modulo

        }
    }
* */
