import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackJCFW5L3 {
    /*
    1.Heirarchy map
    Object <- Abstract Collection[<-Collection]  <- Abstract List[<---List] <- Vector <- Stack

   2.LL IMPLEMENTATION OF STACK IS BEST PRACTISED
   3.STACK CLASS IS RECENTLY DEPRICATED AS STACK LEGACY USES ARRAY IMPLEMENTATION

   4.Stack JCF methods
   boolean empty( ) --> Returnstrue if the stack is empty, and returnsfalse if the stack contains
                        elements.
E peek( ) --> Returns the element on the top of the stack, but does not remove it.
E pop( ) --> Returns the element on the top of the stack, removing it in the process.
E push(E element) --> Pushes element onto the stack. elementis also returned.
int search(Objectelement) --> Searches for element in the stack. If found, its offset
                            from the top of the stack is returned. Otherwise, –1 isreturned
   5.ALL ABOVE METHODS ARE PRESENT IN VECTOR CLASS in addition it has more methods
    6.About STACK JCF:
    1] The class Stack has the single default constructor, which is to create an empty stack



    * * */
}

//1.-->
class StackCreateDemo {
public static void main(String a[]){
// Creating a stack of integers
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Stack contains : " + stack); // Printing the stack
    stack.push(22);
        System.out.println("Is stack empty? : " + stack.empty());
        }
        }

        //2.
        class StackOperationsDemo {
            public static void main(String a[]){
// Creating a stack of integers
                Stack<Integer> stack = new Stack<Integer>();
                System.out.println("Empty stack : " + stack);
                System.out.println("Empty stack : " + stack.empty());
/* Following statement will throw an exception if you pop an
item from an empty stack.So have to catch it here  */
try {
    System.out.println("Empty stack : Pop Operation : " + stack.pop());
}catch (Exception e){
    System.out.println("Empty stack found!!");
}
// Inserting some data into the stack created
                stack.push(1);
                stack.push(22);
                stack.push(333);
                stack.push(4444);
// Print the entire stack now
                System.out.println("Data in the stack : " + stack);
                System.out.println("Pop operation : " + stack.pop());
                System.out.println("After pop Operation : " + stack);
                System.out.println("The element at the top : " + stack.peek());
                System.out.println("After peep operation : " + stack);
                System.out.println("Search operation: " + stack.search(22));
                System.out.println("Is stack empty? " + stack.empty());
                stack.pop();
            }
        }

 //3.This program illustrates how a Stack object can be created with an array of characters.

 class ArrayToStackExample1 {
     public static void main(String a[]) {
// The input array of expression a+b*c-5
         String[] expArray = {"a", "+", "b", "*", "c", "-", "5" };
// Create a Stack object of type String
         Stack<String> stack = new Stack<String>();
// Loading the array into stack
         for (String s : expArray) {
             stack.push(s);
         }
         System.out.println("The stack : " + stack);
     }
 }
 //4.To create a Stack object with an array of integers
 class ArrayToStackExample2 {
     public static void main(String a[]) {
         Integer[] intArr = {1001, 1002, 1003, 1004};
         Stack<Integer> stack = new Stack<>();
         for (Integer i : intArr) {
             stack.push(i);
         }
         System.out.println("The stack: " + stack);
         stack.push(1001);
         stack.search(1001);//duplicacy is allowed in stack
         System.out.println("Verify the result: " + stack);
     }
 }
 //5.To initialize a stack with a given List of integers stored in
 // a collection object of type ArrayList.
class ArrayListToStackExample {

    public static void main(String a[]){
// Create a collection object of type ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Stack<Integer> stack = new Stack<Integer>(); // Declare a Stack object
        stack.addAll(list); // Loading the stack with the collection items
// Printing the first item in the stack
        System.out.println("Top item in the stack : " + stack.peek());
    }
}
//6.The following program illustrates the copy of a stack to a collection object of
//type ArrayList.AS WE WILL NEED TO COPY ONE STK TO ANOTHER COLLECTION IN MANY PROBLEMS
class StackToArrayListCopyDemo {
    public static void main(String a[]){
        Stack<Integer> stack = new Stack<Integer>();// The Input stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
// Create a collection object of type ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(stack);// Copy the elements in stack to the collection
        System.out.println("Non-Empty stack : " + stack);// Printing the Stack
        System.out.println("Non-Empty List : " + list);// Printing the ArrayList
    }
}
//7.To create a stack and Performing basic operations like push, pop and peek
 class StackExample {//Stack is reqd while making a game
    public static void main(String[] args) {
// Creating a Stack
        Stack<String>stackOfCards = new Stack<String>();
// Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");
        System.out.println("Stack => " + stackOfCards);
        System.out.println();
// Popping items from the Stack
        String cardAtTop = stackOfCards.pop();
// Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        System.out.println();
// Get the item at the top of the stack without removing it
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
    }
}
//8.To Check: If the stack is empty | Find the size of the stack. | Search for an
//element in the Stack.
 class StackSizeSearchExample {
    public static void main(String[] args) {
        Stack<String>stackOfCards = new Stack<>();
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");
        System.out.println("Stack : " + stackOfCards);
// Check if the stack is empty
        System.out.println("Is Stack empty? : " + stackOfCards.isEmpty());
// Find the size of Stack
        System.out.println("Size of Stack : " + stackOfCards.size());
// Search for an element
// The search() method returns the
// 1-based position of the element from the top of the stack
// It returns -1 if the element was not found in the stack
        int position = stackOfCards.search("Queen");
        if(position != -1) {
            System.out.println("Found element \"Queen\" at position : " + position);
        } else {
            System.out.println("Element not found");
        }
    }
}
//9.Iterate using: forEach() | iterator() | forEachRemaining() | listIterator() */
 class IterateOverStackExample {
    public static void main(String[] args) {
        Stack<String>stackOfPlates = new Stack<>();
        stackOfPlates.add("Plate 1");
        stackOfPlates.add("Plate 2");
        stackOfPlates.add("Plate 3");
        stackOfPlates.add("Plate 4");
        //1.Using FOREACH()
        System.out.println("=== Iterate over Stack using forEach() method ===");
        stackOfPlates.forEach(plate -> {  //LAMBDA EXPRESSION FOR FOR EACH
            System.out.println(plate);
        });

        //2.USING ITRERATOR()
        System.out.println("\n=== Iterate over a Stack using iterator() ===");
        Iterator<String> platesIterator = stackOfPlates.iterator();
        while (platesIterator.hasNext()) {
            String plate = platesIterator.next();
            System.out.println(plate);
        }

        //3.USING LIST ITERATOR()
    System.out.println("\n=== Iterate over a Stack from TOP to BOTTOM using listIterator() ===");
// ListIterator allows you to traverse in both forward and backward directions.
// We'll start from the top of the stack and traverse backwards.
                ListIterator<String> platesListIterator =
                        stackOfPlates.listIterator(stackOfPlates.size());
        while (platesListIterator.hasPrevious()) {
            String plate = platesListIterator.previous();
            System.out.println(plate);
        }
    }
}



