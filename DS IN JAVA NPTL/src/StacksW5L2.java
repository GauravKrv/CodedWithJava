import java.util.Scanner;

public class StacksW5L2 {
    /*
    1.ARRAY IMPLEMENTATION OF STACK
    2.LL IMPLEMENTATION OF STACK
    3.APPLICATIONS OF STACK




    * */

}
//1.This program shows how a stack can be defined using an ARRAY
/* import arrayPacakge;
this program uses array related implementation; so, include the directory,
where all those programs are defined. */
class StackA<T> {
    T[] data;
    int length;//length or MAX
    int top;
    StackA(T[] a) {
        data = a;
        length = a.length;
        top = -1;
    }
/* The methods push(), pop(), isEmpty(), printStack() are to be defined here.
See the next slides. */

//M1:
// This part of the program includes the definition of the push() method
// Defining the push operation
void push(T a) {
    if(top < length-1) {
        top++;
        data[top] = a;
    }
    else {
        System.out.println("Stack Overflow");
    }
}

//M2;
// This part of the program includes the definition of the pop() method
// Defining the pop operation
T pop() {
    T a = null;
    if(top == -1) {
        System.out.println("Stack Underflow ");
    }
    else {
        a = data[top];
        top--;
    }
    return a;
}
//M3;
// This part of the program includes the definition of the isEmpty() method
// Defining an operation to print an entire stack content
boolean isEmpty() {
    if(top == -1) {
        return true;
    }
    else {
        return false;
    }

}

//M4:
// This part of the program includes the definition of the printStack() method
// Defining an operation to print an entire stack content
void printStack() {
    if(top == -1) {
        System.out.println("Stack Empty");
    }
    else {
        for(int i = top; i>=0 ; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
} // End of the definition OF THE CLSS STACK
//DRIVER PROGRAM :
/* This is the main program, illustration the usage of the class defined. You
should include the package, where this program is stored. */
class StackAImplementationDemo {
    public static void main(String[] args) {
        Integer a[] = new Integer[2];
        StackA<Integer> st = new StackA<Integer>(a);
        st.push(5);
        st.printStack();
        st.push(6);
        st.push(7);
        st.printStack();
        st.pop();
        st.printStack();
        st.pop();
        st.printStack();
        st.pop();
        System.out.println("Is empty?"+ st.isEmpty());
    }
} // End of the demo class

//======================================================================================================
//======================================================================================================

//2.This program shows how a stack can be defined using LINKED LIST
/* import jLLPacakge;
this program uses linked list related implementation; so, include the directory,
where all those programs are defined. */
class StackL<T> {
    JLinkedList<T> top; // Header to the list--THIS JLinkedList was defined by us
    //top will always pint first node of the LL
    int t; // Length of the list
    StackL() {
        top = new JLinkedList<T>();
        t=0;
    }
/* The methods push(), pop(), isEmpty(), printStack() are to be defined here.
See the next slides. */
//M1:
// This part of the program includes the definition of the push() method
// Defining the push operation
void push(T data) {
    t += 1;
    this.top.insertFront(data);
}
//M2:
// This part of the program includes the definition of the pop() method
// Defining the pop operation
T pop() {
    T data = null;
    if(!isEmpty()){
        t-=1;
       data =  this.top.deleteFront();
    }
    else {
        System.out.print("Stack Underflow");
    }
    return data;
}
    T peek() {
        T data = null;
        if(!isEmpty()){
            data =  this.top.head.data;
        }
        else {

            System.out.print("Stack Underflow");
        }
        return data;
    }

//M3:
// This part of the program includes the definition of the isEmpty() method
// Defining an operation to print an entire stack content
boolean isEmpty(){
    if(this.top == null) {
        return true;
    }
    else {
        return false;
    }
}
   /* JLinkedList.Node peek(){
    T data = null;
    JLinkedList.Node currNode = this.top.head;
        return currNode;

}*/
   //M4:
// This part of the program includes the definition of the printStack() method
// Defining an operation to print an entire stack content
void printStack() {
    if(this.top == null) {
        System.out.print("Stack is Empty");
    }
    else {
        this.top.printList();
    }
}
} // End of the definition of the class
//DRIVER PROGTRAM FOR STACK IMP
/* This is the main program, illustration the usage of the class defined.
You should include the package, where this program is stored. */
class StackLImplementationDemo {
    public static void main(String[] args) {
        StackL<Integer> st = new StackL<Integer>();
        st.push(5);
        st.printStack();
        st.push(6);
        st.push(7);
        st.printStack();
        st.pop();
        st.printStack();
        st.pop();
        st.printStack();
        st.pop();
    }
} // End of the demo class
//======================================================================================================
//======================================================================================================

//3.INFIX TO POSTFIX CONVERSION WHICH USES LL IMPLEMENTATION OF STACK
class InfixToPostfix {
    // The method to return precedence of a given operator
// Higher returned value means higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    // The method that converts given infix expression to postfix expression.
    static String infixToPostfix(String exp) {
// initializing empty String for result
        String result = new String("");
// initializing empty stack
        StackL<Character> stack = new StackL<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
// If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
// If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')', pop and output from the stack
// until an '(' is encountered.
            else if (c == ')') {
                try {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        result += stack.pop();

                    if (!stack.isEmpty() && stack.peek() != '(')
                        return "Invalid Expression"; // invalid expression
                    else
                        stack.pop();
                } catch (Exception e2) {
                    System.out.println("Empty stack found!!");
                }
            }

            else { // an operator is encountered
                try {
                    while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {//NPE
                        if (stack.peek() == '(')
                            return "Invalid Expression";
                        result += stack.pop();
                    }
                    stack.push(c);
                }catch (Exception e){
                    System.out.println("Empty stack found!!");
                }
            }
        }


// pop all the operators from the stack
        try {
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                result += stack.pop();
            }
        }catch (Exception e){
            System.out.println("Empty stack found!!");
        }

            return result;
        }

// Driver method
        public static void main(String[] args) {
            String exp = "a+b*(c^d-e)^(f+g*h)-i";
            System.out.println(infixToPostfix(exp));
        }
    }

    //EVALUATION
 class ExpressionEvaluation {
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp) {
//create a stack
        StackL<Integer> stack = new StackL<>();
// Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
// If the scanned character is an operand (number here),
// push it to the stack.
            if (Character.isDigit(c))
                stack.push(c - '0');
// If the scanned character is an operator, pop two
// elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        System.out.println("Enter a postfix expression ");
        Scanner sc  = new Scanner(System.in);
        String exp = sc.next();
        //String exp = "231*+9-";
        System.out.println("postfix evaluation: " + evaluatePostfix(exp));
    }
}