package ArrayzW3;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorClassforArraysW3L5 {

    /*
    VECTORS--->As in Maths
    There are some popular Java utility classes, which are either obsolete or
    deprecated. There are many such classes, which JDK 5 has retrofitted to build very
    popular collections. Such classes are called legacy Classes[not recmnded to use]
    Like-->Dictionary,Hashtabble,Propertioe,Stack,Vector
    ==>.About Vectors as Collection:
    1. All vectors are started with an initial capacity.
    2. After this initial capacity is reached, the next time that you attempt to store an
    object in the vector, the vector automatically allocates space for that object in
    addition to few extra additional space for other objects.
    3. By allocating more than just the required memory, the vector reduces the number of
    allocations that must take places as the vector grows. This reduction is important,
    because allocations are costly in terms of time.
    4. The amount of extra space allocated during each reallocation is determined by the
    increment that you specify when you create the vector.
    5. If you don’t specify an increment, the vector’s size is doubled by each allocation
    cycle.

    OPERATIONS WITH VECTOR:
   1. Creating a vector--
   Constructors:- Vector(),Vector(int size),Vetor(int size, int incr),Vector(Collection c)
    --Collection can be arrys, dictionary , etc.
    -- default size 10

    2. Insertion of an item into a vector
    3. Removing an item from a vector
    4. Accessing a vector and its content.
    5. Some frequently used bulk operations










    * */
}

//1. Creating vector
class VectorCreateDemo1 {
    public static void main(String[] arg) {
        Vector v = new Vector(); // Create a vector of default size 10
        v.add(1);
        v.add(2);
        v.add("Debasis");
        v.add(3.4);
        v.add("Samanta");
        System.out.println("Vector is " + v);
        //Vector will convert all the elements in a single string and then will print it
    }
}

//2.Creating a vector to store various types of elements
class VectorCreateDemo2 {
    public static void main(String args[]) {
// initial size is 3, increment is 2
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement("hello");
        v.addElement(2);
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " + v.capacity());
        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());
// Continued to next ...
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());
        if(v.contains(3))
            System.out.println("Vector contains 3.");
// Enumerate the elements in the vector ->to scan & print the entire elements of the vector
        Enumeration vEnum = v.elements();//Enumerating the elements in the vector
        System.out.println("\nElements in vector:");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }
}
//3: Insertion of elements into a vector

class VectorInsertionDemo1 {
    public static void main(String[] arg) {
        Vector vec = new Vector(7);
// use add() method to add elements in the vector
        vec.add(1);
        vec.add(2);
        vec.add(3);
        vec.add(4);
        vec.add(5);
        vec.add(6);
        vec.add(5,7);
// insert 10 at the index 7
        vec.insertElementAt(10, 7);
// checking vector
        System.out.println(" Vector: " + vec);
    }
}

//4: Inserting an element into a vector at specific position
class VectorInsertionDemo2 {
    public static void main(String[] arg) {
        Vector v = new Vector(5); // Create a default vector of size 5

        v.add(0, 1);
        v.add(1, 2);
        v.add(2, "Debasis");
        v.add(3, "Samanta");
        v.add(4, 3);
        v.add(5, 6.9); // Vector will grow automatically
// insert 10 at the index 6
        v.insertElementAt(10, 4);
        System.out.println("Vector is " + v);
    }
}//CHANged program --> now works,, orer of insertion matters

//5. To append all of the elements in the specified Collection[ArrayLst] to the end of this Vector.

class VectorInsertionDemo3 {
    public static void main(String[] arg) {
        ArrayList arr = new ArrayList();//creating an arraylist
        arr.add(3);
        arr.add("Oracle");
        arr.add("Java");
        arr.add(4);
        Vector v = new Vector(); // Creating a default vector
        v.addAll(arr); // copying all element of ArrayList into vector
        System.out.println("vector v:" + v); // checking vector v
    }
}

//6. Deletion of elements using clear methhod
class VectorDeletionDemo1 {
    public static void main(String[] arg) {
        Vector v = new Vector(); // The initial size of the vector is 10
        v.add(0, 1);
        v.add(1, 2);
        v.add(2, "IIT");
        v.add(3, "Kharagpur");
        v.add(4, 3);
        System.out.println("Vector is: " +v);
        v.clear(); // Clearing the vector
        //OR v.removeAll(v); //-->will also work
        System.out.println("After clearing: " + v); // checking vector
    }
}

//7.Deletion of common element from a vector-->Retaining the elements
class VectorDeletionDemo3 {
    public static void main(String[] arg)
    {
        Vector vec = new Vector(7);
        Vector vecRetain = new Vector(4);
// use add() method to add elements in the vector
        vec.add(1);
        vec.add(2);
        vec.add(3);
        vec.add(4);
        vec.add(5);
        vec.add(6);
        vec.add(7);
// This elements will be retained
        vecRetain.add(5);
        vecRetain.add(3);
        vecRetain.add(2);
        vecRetain.add(22);

        System.out.println("Calling retainAll()");
        vec.retainAll(vecRetain);//ON Calling this, except for the elements of
        //vec which maybe inside this vecRetain collecn all other elements will be remved
    // Let us print all the elements available in vector
        System.out.println("Numbers after removal :- ");
        Iterator itr = vec.iterator(); //THIS Is the way of using an iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

//8. Searching an element
class VectorSearchDemo1 {
    public static void main(String[] arg) {
// create default vector
        Vector v
                = new Vector();
        v.add(1);
        v.add(2);
        v.add("C++");
        v.add("Python");
        v.add(3);
// check whether vector contains "Java"
        if (v.contains("Java"))
            System.out.println("The element exists");
        else
            System.out.println("The element does not exist");
    }
}

//9.Searching a specific item at a specific position
class VectorSearchDemo2 {
    public static void main(String[] arg) {
// create default vector of capacity 10
        Vector v
                = new Vector();
        v.add(1);
        v.add(2);
        v.add("Oracle");
        v.add(2);
        v.add("Java");
        v.add(4);
// Checking last occurrence of an ELEMENT by lastIndexOf method
        System.out.println("last occurrence of 2 is: "
                + v.lastIndexOf(2));
    }
}
//10.Replacement after Searching
/* The following program shows how to set the component at the specified index of
this vector to be the specified object. */

class VectorUpdateDemo {
    public static void main(String[] arg)
    {
// Create default vector of capacity 10
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add("Mother");
        v.add("Merry");
        v.add(4);
// Set 4 at the place of 2
        v.setElementAt(4, 1);
        System.out.println("vector: " + v);
    }
}
