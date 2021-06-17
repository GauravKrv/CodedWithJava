package MapsW8;

import java.util.*;

public class SetCollectionW9 {
    /*
    TAKEAWAY ==>
 • Access and retrieval times are quite fast, which makes TreeSet an excellent choice when
storing large amounts of sorted information that must be found quickly

<=================================================================================>
    1.SET COLLECTION IN JCF
• Set Interface in Java is present in java.util package. It extends the Collection interface. It
represents the unordered set of elements which doesn't allow us to store the duplicate
items. We can store a null element in Set.
• Set can be implemented by anyone of the three classes: HashSet, LinkedHashSet, and
TreeSet.
HashSet<data-type> s1 = new HashSet<data-type>();
LinkedHashSet<data-type> s2 = new LinkedHashSet<data-type>();
TreeSet<data-type> s3 = new TreeSet<data-type>();
• Alternatively, you can use the following declaration as all of the class essentially
implements Set interface.
Set<data-type> s1 = new HashSet<data-type>();
Set<data-type> s2 = new LinkedHashSet<data-type>();
Set<data-type> s3 = new TreeSet<data-type>();

Note:
• Set being being a generic interface, it can contains object of any class, such as String,
Integer, Person (a used defined class), etc.
• Like an array, a particular set contains only homogeneous type of objects.
• Unlike an array, it cannot include objects in duplicate.
<================================================================================>

        2.CREATING SET WITH HASHSET==>
• HashSet extends AbstractSet and implements the Set interface. It creates a collection that uses a
hash table for storage.
• HashSet is a generic class that has this declaration:
class HashSet<E>
Here, E specifies the type of objects that the set will hold.

        ==>CONSTRCTOR =>
Constructor Description
*HashSet( ) ==>
It is a default constructor to create a hash set.
*HashSet(Collection<? extends E> c) ==>
It initializes the hash set by using the elements of c.
*HashSet(int capacity) ==>
It initializes the capacity of the hash set to capacity.
*HashSet(int capacity, float fillRatio) ==>
It initializes both the capacity and the fill ratio (also called load capacity ) of the
hash set from its arguments. The fill ratio must be between 0.0 and 1.0, and it determines
 how full the hash set can be before it is resized upward.
==>Note:
• Specifically, when the number of elements is greater than the capacity of the hash set
multiplied by its fill ratio, the hash set is expanded. For constructors that do not take a
fill ratio, 0.75 is used.

        ==>HASHSET Does not have any method of its own

        ==>TRAVERSING A HashSet :
The following example shows different ways of iterating over a HashSet
• Iterate over a HashSet using simple for-each loop.
• Iterate over a HashSet using iterator().
• Iterate over a HashSet using Java forEach and Lambda expression.
• Iterate over a HashSet using iterator() and forEachRemaining() method
<================================================================================>

    3.LINKED HASHSET IMPLEMENTATION OF SET
• A LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked list
across all elements.
• When the iteration order is needed to be maintained this class is used. When iterating
through a HashSet the order is unpredictable, while a LinkedHashSet lets us iterate
through the elements in the order in which they were inserted. When cycling through
LinkedHashSet using an iterator, the elements will be returned in the order in which they
were inserted.
• The LinkedHashSet class extends HashSet and adds no members of its own. It is a generic
class that has this declaration:
class LinkedHashSet<E>  =>Here, E specifies the type of objects that the set will hold.

    ==>CONSTRUCTORS :
    Constructors of LinkedHashSet class

*LinkedHashSet( ) ==>
It is a default constructor to create a hash set.
*LinkedHashSet(Collection<?extends E> c)==>
It initializes the hash set by using the elements of c.
*LinkedHashSet(int capacity) ==>
It initializes the capacity of the hash set to capacity.
*LinkedHashSet(int capacity,float fillRatio)==>
It initializes both the capacity and the fill ratio (also called load capacity ) of the
linked hash set from its arguments. The fill ratio must be between 0.0 and 1.0, and
it determines how full the linked hash set can be before it is resized upward.
Note:
• The constructors in the LinkedHashSet class are in the similar form that of the constructor in
Hashset class.
• The LinkedHashSet class extends HashSet class and implements Set interface.
• The LinkedHashSet class does not define any exclusive methods of its own. All methods are same
as the methods as in HashSet class. This implies that whatever the operations we can perform with
HashSet collections are also possible with the LinkedHashSet class

    ==>DIFFERENCE BETWEEN HASHSET AND LINKED HASHSET
• It is important to note that HashSet does not guarantee the order of its elements,
because the process of hashing doesn’t usually lend itself to the creation of sorted
sets.
• In contrast, the LinkdeHashSet follows the same order of the items as they are added
into the set.
<================================================================================>
    4.SET COLLECTION USING TREESET:
    • TreeSet extends AbstractSet and implements the NavigableSet interface, which in turns
successively extends SortedSet and Set interfaces. This implies all the methods defined in
NavigableSet are implemented by the SortedSet class.
• The TreeSet class like LinkedHashSet class does not have its own method defined.
• The TreeSet It creates a collection that uses a tree for storage and hence its name. Further, in
this type of set, elements are stored in ascending order of sorting.
• Access and retrieval times are quite fast, which makes TreeSet an excellent choice when
storing large amounts of sorted information that must be found quickly

Constructor Description
*TreeSet( ) ==>
 It is a default constructor to create an empty setthat will be sorted in
ascending order according to the natural order of its elements.
*TreeSet(Collection<? extends E> c) ==>
It builds a tree set that contains the elements of c, where c is any collection.
*TreeSet(Comparator<? super E> comp) ==>
It creates an empty tree set that will be sorted according to the comparator
specified by comp.
*TreeSet(SortedSet<E>ss) ==>
 It builds a tree set that contains the elements of ss.
Note:
• In all cases, the capacity grows automatically as elements are added with set structure.
  * *  */
}
//1.CREATING A Set with HashSet class :
class HashSetCreateDemo {
    public static void main(String args[]) {
// Create a hash set.
        HashSet<String> hs = new HashSet<String>();
// Set<String>hs = new HashSet<String>();
// Add elements to the hash set.
        hs.add("India");
        hs.add("Japan");
        hs.add("Australia");
        hs.add("Bangladesh");
        hs.add("Pakistan");
        hs.add("Nepal");
        System.out.println(hs);//In which order are the elements printed or stored??
        //Ans = >Set will store the elements in its own internal mechanim ad not a we insert
    }
}

//2.Adding a duplicate object
/* The following program illustrates that if you add an object, which is already in the set, then that
inclusion will be ignored automatically. */

 class HashSetDuplicateDemo {
    public static void main(String[] args) {
// Creating a HashSet
        Set<String> daysOfWeek = new HashSet<>();
// Adding new elements to the HashSet
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");
// Adding duplicate elements will be ignored
        daysOfWeek.add("Monday");
        System.out.println(daysOfWeek);
    }
}
//2.Creating a set from a collection
class HashSetCollectionDemo {
    public static void main(String args[]) {
//Creating a hash set from a collection
        List<Integer> list = Arrays.asList(3, 9, 2, 4, 6, 2, 5, 3, 8, 9, 1, 7, 8, 6);
        System.out.println(list);
        HashSet<Integer> uniqueNumbers = new HashSet<>(list);
        System.out.println(uniqueNumbers);
        Set<Double>bigSet = new HashSet<>(1000);
        for(int i = 0; i< 1000;i++)
        bigSet.add( Math.random());//Math.random stores double values so bigSet should be of double type

        System.out.println(bigSet);
        System.out.println("If 555 is in the bigSet? " +bigSet.contains(555));
    }
    /*
    Note:
• It is important to note that HashSet does not guarantee the order of its elements,
because the process of hashing doesn’t usually lend itself to the creation of sorted sets.
• You see, the list listNumbers contains duplicate numbers, and the set uniqueNumbers
removes the duplicate ones.
• The default, initial capacity of a HashSet is 16, so if you are sure that your Set contains
more than 16 elements, it’s better to specify a capacity in the constructor


    * * *  */
}

//3.TRAVERSING A HASHSET :
 class SetTraversalDemo {
    public static void main(String[] args) {
        Set<String>pLangs = new HashSet<>();
        pLangs.add("C");
        pLangs.add("C++");
        pLangs.add("Java");
        pLangs.add("Python");
        pLangs.add("PHP");
        pLangs.add("R");
// Using simple for-each loop
        System.out.println("Using for-each loop");
        for(String pl: pLangs) { //Not advisable method for iteration as very less customisation is available
            System.out.print(pl+",");
        }
        System.out.println();
// Using iterator()
        Iterator<String> iter = pLangs.iterator();
        System.out.println("Using iterator() ");
        while (iter.hasNext()) {
            String pl = iter.next();
            System.out.print(pl+",");
        }
        System.out.println();
// Using forEach and lambda expression
        System.out.println("Using forEach and lambda");
        pLangs.forEach(i -> //pLans is redirecting to below
                System.out.print(i+","));

        System.out.println();
// Using iterator() and forEachRemaining() method
        System.out.println("Using iterator and for each rem");
        iter = pLangs.iterator();
        iter.forEachRemaining(p -> { System.out.print(p+","); });
    }
}

//4.BASIC SET THEORY OPERATIONS :
/* The following program demonstrates union,interection operation with a HashSet collection. */
class HashSetOperationDemo3 {
    public static void main(String args[]) {
    // Create a hash set.
        Set<Integer> s1 = new HashSet<>(Arrays.asList(20, 56, 89, 31, 8, 5));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(8, 89));
    // 1.Sub set operation
        if (s1.containsAll(s2)) {
            System.out.println("s2 is a subset of s1");
        }
    //2. Union operation
        Set<Integer> s3 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
        Set<Integer> s4 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("s3 before union: " + s3);
        s3.addAll(s4);
        System.out.println("s3 after union: " + s3);
        //3. Intersection operation
        Set<Integer> s5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
        Set<Integer> s6 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("s5 before intersection: " + s5);
        s5.retainAll(s6);//USED FOR INTESECTION OPERATION
        System.out.println("s5 after intersection: " + s5);

    // 4.Set difference operation
        Set<Integer> s7 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
        Set<Integer> s8 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("s7 before difference: " + s7);
        s7.removeAll(s8);//SED FOR DIFFERENCE OPERAITON i.e opp of intersection
        System.out.println("s7 after difference: " + s7);
    }
}

//5.DIFFENRENCE BETWEEN HASHSET AND LINKED HASHSET
/* The following program illustrates the ordering of elements in two sets
created by Hashset and LinkedHashset classes. */
class DifferentSetDemo {
    public static void main(String args[]) {
// Create a hash set.
        HashSet<String>hs = new HashSet<String>();
// Add elements to the hash set.
        hs.add("Aba");
        hs.add("Baa");
        hs.add("Cba");
        hs.add("Dlsdj");
        hs.add("E");
        hs.add("F");
        System.out.println(hs);
        // Create a linked hash set.
        LinkedHashSet<String>lhs = new LinkedHashSet<String>();
// Add elements to the hash set.
        lhs.add("Aba");
        lhs.add("Baa");
        lhs.add("Cba");
        lhs.add("Dlsdj");
        lhs.add("E");
        lhs.add("F");
        System.out.println(lhs);
    }
    /*
    output :
    HS=>[Dlsdj, Aba, Baa, Cba, E, F]
    LHS=>[Aba, Baa, Cba, Dlsdj, E, F]
    * * */
}
//6.SET USING TREESET
/* The following program illustrates the creating a tree sets created by TreeSet class. */
class TreeSetDemo {
    public static void main(String args[]) {
// Create a tree set.
        TreeSet<String>ts = new TreeSet<String>();
// Add elements to the tree set.
        ts.add("D");
        ts.add("E");
        ts.add("B");
        ts.add("A");
        ts.add("S");
        ts.add("I");
        ts.add("S");
        System.out.println(ts);
        /*Note:
• As explained, because TreeSet stores its elements in a tree, they are automatically
arranged in sorted order[Ascending],as the output confirms.
        * */
    }
}
//7.SUSET OF A TREESET COLLECTION
/* Because TreeSet implements the NavigableSet interface, you can use the methods defined by
NavigableSet to retrieve elements of a TreeSet. You can write many programs performing several
operations with the method declared in NavigableSet. In the following, the application of
subSet() is illustrated. The subSet() method returns a sub set of a tree set that contains the
elements between elements, say e1 (inclusive) and e2 (exclusive).
*/
class SubSetTreeSetDemo {
    public static void main(String args[]) {
// Create a tree set.
        TreeSet<String>ts = new TreeSet<String>();
// Add elements to the tree set.
        ts.add("D");
        ts.add("E");
        ts.add("B");
        ts.add("A");
        ts.add("S");
        ts.add("I");
        ts.add("S");
        System.out.println(ts);
        System.out.println(ts.subSet("D","S"));//Will print ubset between D and S including D
    }
}

//8.USER DEFINED SET COLLECTION****************************
class Customer {
    private long id;
    private String name;
    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Two customers are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
 class HashSetUserDefinedObjectExample {
    public static void main(String[] args) {
        Set<Customer> customers = new HashSet<>();
        customers.add(new Customer(101, "Rajeev"));
        customers.add(new Customer(102, "Sachin"));
        customers.add(new Customer(103, "Chris"));
/*
HashSet will use the `equals()` & `hashCode()` implementations
of the Customer class to check for duplicates and ignore them
*/
        customers.add(new Customer(101, "Rajeev"));
        System.out.println(customers);

    }
    //In JDBC THERE ARE MANY METHODS USING SET
}