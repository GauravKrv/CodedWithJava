package STACKS;


import java.util.Scanner;
import java.util.Stack;

class MainDelMid {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();

            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);

            }
            DeleteMidElement obj=new DeleteMidElement();
            obj.deleteMid(myStack,sizeOfStack);

            while(!myStack.isEmpty())
            {
                System.out.print(myStack.peek()+" ");
                myStack.pop();
            }
            System.out.println();
        }


    }
}// } Driver Code Ends

public class DeleteMidElement {
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int mid = (int)Math.ceil(sizeOfStack/2.0);
        s.remove(mid-1);
        // code here
    }
}
