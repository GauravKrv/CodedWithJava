package LINKED_LIST;

import java.util.LinkedList;

public class SortLL {
    static LinkedList<Integer> ll = new LinkedList<>();

    static void sortLL(){

    }
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            ll.push(i+1*10);
        }

        System.out.println("Before Sort");
        for (int x : ll) {
            System.out.print(x+" -> ");
        }
        sortLL();
        System.out.println("After Sort");
        for (int x : ll) {
            System.out.print(x+" -> ");
        }

    }
}
