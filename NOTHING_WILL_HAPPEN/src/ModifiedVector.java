import java.util.ArrayList;

public class ModifiedVector {


    public static void insertele(ArrayList<Character> vec,char c,int start,int times){
        for (int i=start;i<start+times;i++){
            vec.add(i,c);
        }
    }

    public static void insertarr(ArrayList<Character> vec,char[] c,int start,int end){
        for (int i=start;i<end;i++){
            vec.add(i,c[i-start]);
        }
    }

    public static void removeele(ArrayList<Character> vec,char c){
        int count = vec.size();
        for (int i=0;i<count;i++){

            if (vec.get(i) == (Character)c) {
                vec.remove(i);
                count--;
                i--;
            }

        }
    }

    public static void printVec(ArrayList<Character> vec){

        for (int i=0;i<vec.size();i++) {
            System.out.print(vec.toArray()[i] + " ");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        char arr[] = {'a','b','c','d','e','f','g','h','i','j'};
        ArrayList<Character> vec = new ArrayList<>();

        int n = arr.length;
        for (int i=0;i<n;i++){
            vec.add(arr[i]);
        }
        System.out.println("Original contents of vector : ");
        printVec(vec);

        insertele(vec,'X',2,10);
        System.out.println("Size after inserting : "+(vec.size()));
        System.out.println("Contents after insert : ");
        printVec(vec);

        removeele(vec,'X');
        System.out.println("Size after eraze = "+vec.size());
        System.out.println("Contents after erase : ");
        printVec(vec);

        char ar2[] = {'<','V','e','c','t','o','r','>'};
        insertarr(vec,ar2,2,ar2.length+2);
        System.out.println("");
        System.out.println("Size after inserting : "+(vec.size()));
        System.out.println("Contents after insert : ");
        printVec(vec);



    }
}
/*
Original contents of vector :
a b c d e f g h i j

Size after inserting : 20
Contents after insert :
a b X X X X X X X X X X c d e f g h i j

Size after eraze = 10
Contents after erase :
a b c d e f g h i j


Size after inserting : 18
Contents after insert :
a b < V e c t o r > c d e f g h i j

* */