package BINARY_TREES;

public class Node {
   Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }

    char value;

    Node(char item) {
        value = item;
        left = right = null;
    }
}
