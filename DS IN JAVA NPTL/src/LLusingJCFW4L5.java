import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LLusingJCFW4L5 {
   /*
        LINKED LIST CLASS
    1. The LinkedList class is a member in the Java Collections Framework to support
    sequential access of a list of items unlike ArrayList, which provides indexed
    access.
    2. It inherits the AbstractSequentialList class and implements the List and Deque
    interfaces.


      Following are the few salient FEATURE of this collection:
• It provides a linked-list data structure
• The class can contain duplicate elements.
• The class uses a doubly linked list to store the elements.
• The class maintains insertion order. i.e element is inserted at end of LL
• The class is non-synchronized.-if we use this structure in multithrding programming
 then it would be slower.
• Manipulation is faster than array because no shifting is required.
• The LinkedList class can be used to maintain a collection as a linked list, stack or queue.


        CONSTRUCTORS OF LL IN JCF
  LinkedList() ---> It is used to create an empty list.
LinkedList(Collection<? extends E> c) ----> It is used to construct a list containing the
 elements of the specified collection. The ordering of the element in the list
and collection is same.

    OPERATIONS WITH LL N JCF
• Creating a linked-list
2.INSERTION IN LL
boolean add(E e)    --->It is used to append the specified element to the end of a list.
void add(int index, E element)  -->It is used to insert the specified element at the
specified position index in a list.
boolean addAll(Collection<?extends E> c) -->It is used to append all of the elements
in the specified collection to the end of this list, in the order that they are
returned by the specified collection's iterator.
boolean addAll(int index,Collection<? extends E> c) -->It is used to append all the elements in the specified collection, starting
at the specified position of the list.
void addFirst(E e) --> It is used to insert the given element at the beginning of a list.
void addLast(E e) --> It is used to append the given element to the end of a lisT


3.DELETION IN LL USING JCF
E poll() -->  It retrieves and removes the first element of a list.
E pollFirst() --> It retrieves and removes the first element of a list,
or returns null if a list is empty.
E pollLast()  -->  It retrieves and removes the last element of a list,
or returns null if a list is empty.
E pop() --> It pops an element from the stack represented by a list.
void push(E e) --> It pushes an element onto the stack represented by a list.
E remove() --> It is used to retrieve and removes the first element of a list.
E remove(int index) --> It is used to remove the element at the specified position in a list.
boolean remove(Object o) --> It is used to remove the first occurrence of the specified element in a list
E removeFirst() It removes and returns the first element from a list.
boolean removeFirstOccurrence(Object o) -->It is used to remove the first OCCURENCE
of the specified element in a list (when traversing the list from head to tail).
E removeLast() --> It removes and returns the last element from a list.
boolean removeLastOccurrence(Object o) --> It removes the last OCCURNCE of the
specified element in a list (when traversing the list from head to tail).
void clear() --> (Risky method) It is used to remove all the elements from a list

• Traversing a linke














   * * */
}
//1.CREATE A LINKED LIST FROM JCF
class CreateLLandAddItems {
    public static void main(String args[]) {
// Creating an empty ll of class LinkedList
        LinkedList<String> ll = new LinkedList<String>();
// Adding elements to the linked list using a number of add methods
        ll.add("Mumbai");
        ll.add("Chennai");
        ll.add("Kolkata");
        ll.add("Delhi");
        ll.add("Bangalore");
        ll.add("Guwahati");
        ll.add("Hyderabad");

// System.out.println("Linked list : "+ ll); // //1st method to print LL -->Simple printing

        Iterator<String> itr=ll.iterator();  //2nd method to print LL--used by progrmmrs
        while(itr.hasNext()){
            System.out.println(itr.next());// Printing the list using an iterator
        }
    }
}

//2.CREATING LL WITH USER DEFINED OBJECTS
class Student4 {
    String name;
    double marks;
    // Constructor
    Student4(String s, double m) {
        name = s;
        marks = m;
    }
    void printData () {// To parent a reacord
        System.out.print("Name : " + name);
        System.out.println(" Marks : " + marks);
    }
}

// The main class is defined below.
class CreateLLofCollection {
    public static void main(String args[]) {
// Create an aaray of objects
        Student4 sArray[] = new Student4[5]; // To store 5 objects of type Student4
// Create the array sArray
        sArray[0] = new Student4("Ram", 79.6);
        sArray[1] = new Student4("Rahim", 85.5);
        sArray[2] = new Student4("John", 90.1);
        sArray[3] = new Student4("Lisa", 69.4);
        sArray[4] = new Student4("Ana", 59.8);

// Creating a linked-list with sArray collection
        LinkedList<Student4> ll = new LinkedList<Student4>(Arrays.asList(sArray));
                                                //here our sArray collection is pssed
        Student4 temp;
// Printing the list using an iterator
        Iterator<Student4>itr=ll.iterator();
        while(itr.hasNext()){
            temp = itr.next();
            temp.printData(); // Print the current record.
        }
        //Or use sout(ll);
    }
    }
    //3.LL INSERTION DEMO
/*This program shows how items can be inserted at different locations in a linked list. For
this purpose, there are methods like add(), addFirst(), addLast() are defined in the LinkedList
class. */
 class LLinsertionDemo {
    public static void main(String args[]) {
// Creating an empty ll of class LinkedList
        LinkedList<String>ll = new LinkedList<String>();
// Adding elements to the linked list using a number of add methods
        ll.add("Mumbai"); // Add an initial item
        ll.add("Chennai"); // Add another item
        ll.addLast("Kolkata"); // Add at the end
        ll.addFirst("Delhi"); // Add at the front
        ll.add(2, "Bangalore"); // Add in the specific location
        ll.add("Guwahati"); // Sequential add goes at the end
        ll.add("Hyderabad"); // Another sequential insertion

// Printing the list using an iterator
        Iterator<String>itr=ll.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
// Alternatively:
        System.out.println("Linked list : "+ ll); // Simple printing
    }
}
//4.INSERTION OF A LIST INTO A LINKED LIST
/* A sub list can be inserted into a linked list in addition to a single item. This program
shows how a sub list can be inserted at different locations in a linked list. For this
purpose, the addAll() method is used.*/
class InsertSubListToLL{
    public static void main(String args[]) {
        LinkedList<String> ll1 = new LinkedList<String>();
        System.out.println("Initial list of elements: " + ll1);
        ll1.add("MP Allahabad");
        ll1.add("MP Lucknow");
        ll1.add("MP Varanasi");
        System.out.println("Initial list: " + ll1);
// Create another linked list, say ll2
        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("MLA Nadia");
        ll2.add("MLA Kharagpur");

        //Adding the second list (ll2) to the first list (ll1)
        ll1.addAll(ll2);
        System.out.println("After adding ll2 to ll1: " + ll1);
// Create another linked list, say ll3
                LinkedList<String> ll3 = new LinkedList<String>();
        ll3.add("MLA Durgapur");
        ll3.add("MLA Howrah");
//Inserrt ll3 at a specific position of ll1
        ll1.addAll(3, ll3); // Insert ll3 at location 3 of ll1
        System.out.println("After insetting ll3: " + ll1);
//Do some normal insertions
                ll1.addFirst("President");
        ll1.addLast("Prime Minister");
        ll1.add("MP Chennai");
        System.out.println("The final list " + ll1);
    }
    }
    //5.DELETETION IN A LL USING JCF
/* Like insertion, deletion operation on a linked list can be carried our many ways.
Following few examples illustrates the deletion operation with methods remove(),
removeFirst(), removeLast(), etc.*/
class DeletionFromLL {
        public static void main(String[] args) {
// Creating a linked list
            LinkedList<String> ll1 = new LinkedList<String>();
            ll1.add("A");
            ll1.add("E");
            ll1.add("I");
            ll1.add("O");
            ll1.add("U");
            ll1.add("H");
            System.out.println("List of vowels: " + ll1);

            //Removing specific element from the linked list
            ll1.remove("H"); // Rmovee the vowel H
            System.out.println("use of element() -- "+ll1.element());
            System.out.println("After deletion of H : " + ll1);
//Removing element on the basis of specific position
            ll1.remove(0); // This will remove A from the list
            System.out.println("After invoking remove(index) method: " + ll1);
// Let’s create another list of semi-vowels
            LinkedList<String> ll2 = new LinkedList<String>();
            ll2.add("M");
            ll2.add("N");
// Adding new elements to the list of vowels
            ll1.addAll(ll2); // Append ll2 after ll1
            System.out.println("Updated list : " + ll1);
//Removing first element from the list
            ll1.removeFirst();
            System.out.println("After invoking removeFirst() method: " + ll1);

            //Removing last element from the list
            ll1.removeLast();
            System.out.println("After invoking removeLast() method: " + ll1);
// Removing all elements of ll2 from ll1
            ll1.removeAll(ll2);
            System.out.println("After removing semi-vowels: " + ll1);
            ll1.add("A");
            ll1.add("B");
            ll1.add("A");
//Removing first occurrence of element from the list
            ll1.removeFirstOccurrence("A");
            System.out.println("After removing first occurrence of A: " + ll1);
//Removing the last occurrence of B
            ll1.removeLastOccurrence("B");
            System.out.println("After invoking removeLastOccurrence() method: " + ll1);
//Removing all the elements available in the list
            ll1.clear();
            System.out.println("After invoking clear() method: " + ll1);
        }
    }
//6.TRAVERSAL IN A LL USING JCF
/*We have learned how to print a linked-list in sequential order starting from the first item in the list. The
        LinkedList class allow you to traverse a linked in reverse order as well. For this purpose, you should use the
        method descendingIterator(). This can be applied to a list storing of any type of items.
*/
/* The following program illustrates how to traverse two different type of lists in
reverse order, that is, from the end to the front. */
class TravserseReverseLL {
    public static void main(String args[]) {
// Case 1: a linked list of countries
        LinkedList<String> lCountries = new LinkedList<String>();
        lCountries.add("Australia");
        lCountries.add("India");
        lCountries.add("South Africa");
        lCountries.add("Zimbabwe");

        //Traversing the list of countries in reverse order
        Iterator itr1 = lCountries.descendingIterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
// Case 2: a linked list of numbers
        LinkedList<Integer> lNumbers = new LinkedList<Integer>();
        lNumbers.add(123);
        lNumbers.add(345);
        lNumbers.add(567);
        lNumbers.add(789);
//Traversing the list of numbers in reverse order
        Iterator itr2 = lNumbers.descendingIterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }
}

//7.MISCELLANEOUS OPERATIONS
/* The LinkedList class is loaded with several other methods like get(), contain(),
size(), set(), etc. The following program illustrates those methods and their utilities
in Java programming. */
 class OtherMethodsOfLL{
    public static void main(String args[]){// Creating a linked list
        LinkedList<String>lLetters = new LinkedList<String>();
        lLetters.add("J");
        lLetters.add("O");
        lLetters.add("Y");
        lLetters.add("W");
        lLetters.add("I");
        lLetters.add("T");
        lLetters.add("H");
        lLetters.add("J");
        lLetters.add("A");
        lLetters.add("V");
        lLetters.add("A");

        lLetters.add("2020");
        System.out.println("List : "+lLetters);
// Finding an elements in the linked list
        boolean status = lLetters.contains("Z");
        if(status)
            System.out.println("List contains the element 'Z' ");
        else
            System.out.println("List doesn't contain 'Z'");
// Finding the number of elements in the linked list
        int size = lLetters.size();
        System.out.println("Number of letters = "+ size);
// Get and set elements from the linked list
        String element = lLetters.get(11);
        System.out.println("Element returned by get() : " + element);
                lLetters.set(11, "The fun");
        System.out.println("Linked list after change : " + lLetters);
    }
}

//8.CASE STUDY WITH USER DEFINED OBJECTS

/* The following, a program shows a list a number of books, insertion of another books
in the list, deletion of books and then traversing of the books, etc.*/
// Defining a calls Book
class Book {
    int accnNo;
    String title, author, publisher;
    double cost;
    // Constructor of the class
    Book(int id, String t, String auth, String pub, double val) {
        accnNo = id;
        title = t;
        author = auth;
        publisher = pub;
        cost = val;
    }
}

// The main class maintaining a library of books
 class LibraryLL {
    public static void main(String[] args) {
        LinkedList<Book> library =new LinkedList<Book>(); //Creating list of Books
//Creating a list of Books
        Book b1 = new Book(101,"Oracle Java","Leslie Lamport","Oxford",88.5);
        Book b2 = new Book(102,"Complete Java","McGraw Hill", "TMH" , 94);
        Book b3 = new Book(103,"Joy with Java","Samanta","Prentice Hall",69.6);
        library.add(b1); //Adding Books to list
        library.add(b2);
        library.add(b3);
//Traversing the list using advanced for loop
        for(Book b:library){System.out.println("Book ID: " +b.accnNo);
            System.out.print(b.title+" "+b.author+" "+b.publisher+" "+b.cost);
            System.out.println();
        }
    }
}