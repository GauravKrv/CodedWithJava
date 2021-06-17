package W12StringAndUtilities;

import java.util.*;

public class Cursors_Enum_Iterator_List_Splititerator {
    /*
    1.JAVA CURSORS ==>
    A Java cursor is a pointer (more precisely loop indicator), which is used to iterate (loop or
cycle or visit) or traverse or retrieve collection elements one by one.
When you are dealing with a collection, you have to perform CRUD operations.

--->The CRUD operations in JCF implies the following:
1]Create: Adding new elements to Collection object.
2]Read: Retrieving elements from Collection object.
3]Update: Updating or setting existing elements in Collection object.
4]Delete: Removing elements from Collection object.

You will see there are many classes in the JCF loaded with many methods in each to
accomplish the CRUD operations. In addition to the CRUD operations, it is also an important
aspect to traverse or visit each element in the cursor. For this very reason, Java developer
introduces a concept called Java cursor
[[[CRUD OPERATIONS:Within computer programming, the acronym CRUD stands for create, read, update
 and delete. These are the four basic functions of persistent storage. Also, each letter in the acronym can refer to all functions executed in relational database applications and mapped to a standard HTTP method, SQL statement or DDS operation.]]

--->List of Java Cursors :
• Enumeration
• Iterator
• ListIterator
• Spliterator
Let us learn each of the above-mentioned Java cursors, in details with appropriate illustrations
  ---------------------------------------------------------------------------------

  1.ENUMERATION :
 • It is an interface used to get elements of legacy collections (Vector, Hashtable).
• Enumeration is the first iterator introduced in JDK 1.0.
• The interface Enumeration has the following methods declared in it:
    Method                           Description
public boolean hasMoreElements(); Tests if this enumeration contains more elements.
public Object nextElement(); Returns the next element of this enumeration
--->Limitation of Enumeraiton
• It is applicable to only Collection of legacy classes, like Vector and HashTable.
• Compare to other cursors, it has very lengthy method names: hasMoreElements() and nextElement().
• In CRUD operations, it supports only read operation. It does not support create, update and delete
operations.
• It supports only forward direction iteration. That’s why it is also known as uni-directional cursor.
-------------------------------------------------------------------------------------
2.ITERATOR INTERFACE :
The limitations in Enumeration interface had been addressed in JDK 1.2, and introduced a
better Java cursor called Iterator.
• It is a universal iterator as you can apply it to any Collection object like Set, List, Queue,
Deque and also in all implemented classes of Map interface.
• By using Iterator, you can perform both read and remove operations.
•***The Iterator interface is fully implemented by Collection classes.
• The Iterator interface defines three methods as listed below.

Method              Description
public boolean hasNext(); Returns true if the iterator has more elements.
public Object next(); Returns the next element in the iterator.
public void remove(); Remove the next element in the iterator. This method can be called only once per
call to next().

--->Limitatiopns:
• It supports only forward direction iteration. That is, like Enumerator, it is also a uni-directional
cursor.
• Only read and remove is possible. Replacement and addition of new element is not supported by
Iterator
----------------------------------------------------------------------------
3.LISTITERATOR INTERFACEC
It is only applicable for List collection implemented classes like ArrayList, LinkedList, etc.
• It provides bi-directional iteration.
• This cursor has more functionality than iterator.
• ListIterator interface extends Iterator interface. So all three methods of Iterator interface
are available for ListIterator.
• In addition, there are six more methods, which are listed next.
Method Description
public boolean hasNext(); Returns true if the iterator has more elements.
public Object next(); Returns the next element in the iterator.
public void remove(); Remove the next element in the iterator. This method can be called only
                        once per call to next()
                        AND MANY MORE-----
Method Description
void add(E obj) Inserts obj into the list in front of the element that will be returned
by the next call to next( ).
default void
forEachRemaining(Consumer<?
super E> action)
The action specified by action is executed on each unprocessed
element in the collection. (Added by JDK 8.)
boolean hasNext( ) Returns true if there is a next element. Otherwise, returns
false.
boolean hasPrevious( ) Returns true if there is a previous element. Otherwise, returns
false.
E next( ) Returns the next element. A NoSuchElementException is thrown if
there is not a next element.
int nextIndex( ) Returns the index of the next element. If there is not a next
element, returns the size of the list.
E previous( ) Returnsthe previous element.ANoSuchElementException
is thrown if there is not a previous element.
int previousIndex( ) Returns the index of the previous element. If there is not a previous
element, returns –1.
void remove( ) Removes the current element from the list. An
                IllegalStateException is thrown if remove( ) is called before next( ) or
                previous( ) is invoked.
void set(E obj) Assigns obj to the current element. This is the element last returned
by a call to either next( ) or previous( ).

















    * */
}

//1.DEMONSTRATION OF ENUMERATION
// Java program to demonstrate Enumeration
/*
The Collection class defined in java.util package has its own implementation of the interface Enumeration.
        Enumerations are also used to specify the input streams to a SequenceInputStream. You can create Enumeration
        object by calling elements() method of Vector class on any Vector object. For example, if v denotes an object of the
        class Vector class, then e is an object of type Enumeration referring to v is:
        Enumeration e = v.elements();
 */

class EnumerationTest {
    public static void main(String[] args) {
// Create a vector and print its contents
        Vector v = new Vector();
        for (int i = 0; i < 10; i++)
            v.addElement(i);
        System.out.println(v);
/*Declare an enumerator to the collection v At the beginning e points to
index just before the first element in v */
        Enumeration e = v.elements();
        while (e.hasMoreElements()) { // Enumerate each element one-by-one
            int i = (Integer) e.nextElement(); //Moving cursor to next element
            System.out.print(i + " "); // Print the current element
        }
    }
}

//2.ITERATOR WITH ARAYLIST CLASS:
class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            al.add(i);
        System.out.println(al);
        Iterator itr = al.iterator();
// The cursor at the beginning of the first element
        while (itr.hasNext()) { // Iterate over each element in al
            int i = (int) itr.next(); // Read the current element
            System.out.print(i + " ");
            if (i % 2 != 0)
                itr.remove(); // Removing odd elements
        }
        System.out.println();
        System.out.println(al);
    }
}

//2.2]ADDING OR REMOVING WHILE USING ITERATOER -
class ErrorWithIterator {
    public static void main(String args[]) {
        ArrayList<String> books = new ArrayList<String>();
        books.add("C");
        books.add("C++");
        books.add("Java");
        for (String obj : books) {//For each String object belongs to this collection books
            System.out.println(obj);
//We are adding element while iterating list
            books.add("C++");
        }
        Iterator itr = books.iterator();
        while (itr.hasNext()) {
            String b = (String) itr.next();
            System.out.print(b + " ");
            books.add("Python"); // You cannot do it!
            books.remove("C"); // You cannot do it!!
        }
    }
}

/*
You cannot add or remove elements to the
collection while using iterator over it.
Hence, it will give a run-time exceptio
* */
//3.LIST ITERATOR INTERFACE
class ListIteratorDemo {
    public static void main(String args[]) {
// Create an array list.
        ArrayList<String> al = new ArrayList<String>();
// Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
// Use iterator to display contents of al.
        System.out.print("Original contents of al: ");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
// Modify objects being iterated.
        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
// Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

/*ListIterator cursor
Note:
• You will not be able to modify the contents of a collection or obtaining elements in
reverse order, then the for-each version of the for loop is often a more convenient
alternative to cycling through a collection than is using an iterator.
• Recall that the for can cycle through any collection of objects that implement the
Iterable interface. Because all of the collection classes implement this interface, they
can all be operated upon by the for
* */
//3.2--CYCLING THROUGH A COLLECTION THROUGH FRO EACH LOOP
class ForEachLoopDemo {
    public static void main(String args[]) {
// Create an array list for integers.
        ArrayList<Integer> vals = new ArrayList<Integer>();
// Add values to the array list.
        vals.add(1);
        vals.add(2);
        vals.add(3);
        vals.add(4);
        vals.add(5);
// Use for loop to display the values.
        System.out.print("Contents of vals: ");
        for (int v : vals)
            System.out.print(v + " ");
        System.out.println();
// Now, sum the values by using a for loop.
        int sum = 0;
        for (int v : vals)
            sum += v;
        System.out.println("Sum of values: " + sum);
    }
}
/*Example 3.3: Cycle through a collection using for-each
Note:
• Clearly the three methods that ListIterator inherits from Iterator (hasNext(), next(), and
remove()) do exactly the same thing in both interfaces. The hasPrevious() and the previous
operations are exact analogues of hasNext() and next(). The former operations refer to the
element before the (implicit) cursor, whereas the latter refer to the element after the cursor.
The previous operation moves the cursor backward, whereas next moves it forward.
• ListIterator has no current element; its cursor position always lies between the element that
would be returned by a call to previous() and the element that would be returned by a call
to next()
• Please note that initially any iterator reference will point to the index just before the index of
first element in a collection.
• We don’t create objects of Enumeration, Iterator, ListIterator because they are interfaces.
We use methods like elements(), iterator(), listIterator() to create objects. These methods
have anonymous inner classes that extends respective interfaces and return this class object.
IT IS DONE BELLOW
* */
//.3.3-ITERATOR REFRENCES OF DIFFERENT TYPES TO THE SAME COLLECTION

class JavaCurorsTest {
    public static void main(String[] args) {
        Vector v = new Vector();
// Create three iterators
        Enumeration e = v.elements();
        Iterator itr = v.iterator();
        ListIterator ltr = v.listIterator();
// Code to use the iterators
    }
}

//3.4ITERATOR REFERENCES OF DIFFERENT TYPES OF THE SAME COLLETION
//It is the most powerful iterator but it is only applicable fto List implemented classes, so it is not a universal iterato
class Employee {
    private int empid;
    private String ename;
    private String designation;
    private double salary;

    public Employee(int empid, String ename, String designation, double salary) {
        this.empid = empid;
        this.ename = ename;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEname() {
        return ename;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    //This shows how to print an element of custom type using toString()
    @Override
    public String toString() {
        return empid + "\t" + ename + "\t" + designation + "\t" + salary;
    }
}

class Employees implements Iterable {
    private List<Employee> emps = null;

    public Employees() {
        emps = new ArrayList<Employee>();
        emps.add(new Employee(101, "Ram", "Professor", 250000L));
        emps.add(new Employee(102, "Rahim", "Engineer", 300000L));
        emps.add(new Employee(103, "Jonny", "Doctor", 350000L));
    }

    @Override
    public Iterator<Employee> iterator() {
        return emps.iterator();
    }
}

class EmployeesTester {
    public static void main(String[] args) {
        Employees emps = new Employees();
        for (Object emp : emps) {
            System.out.println(emp);
        }
    }
}





