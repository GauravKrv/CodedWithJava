package BINARY_TREES;

public class Node {
   Node left,right;
    int data;
    int key;
    Node(int data){
        this.data = data;
        this.key = data;
        left = right = null;
    }



    char value;

    Node(char item) {
        value = item;
        left = right = null;
    }
}
