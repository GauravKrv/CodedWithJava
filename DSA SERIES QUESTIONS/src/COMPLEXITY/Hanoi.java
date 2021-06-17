package COMPLEXITY;

public class Hanoi {
    static int count = 0;

    static void tower_of_hanoi(int n,char A, char B, char C){
        if (n==1){
            System.out.println("Finally Move "+n+" from disk "+A+" To "+C);
            count++;
          return;
        }
        tower_of_hanoi(n-1,A,C,B);


        System.out.println("Move "+n+" from disk "+A+" To "+C);

        tower_of_hanoi(n-1,C,B,A);

        count++;
 }

    public static void main(String[] args) {
        tower_of_hanoi(3,'A','B','C');
        System.out.println("Steps used :"+count);
    }

}
