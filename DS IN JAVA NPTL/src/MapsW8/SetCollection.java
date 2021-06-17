package MapsW8;

import java.util.EnumSet;
import java.util.Iterator;

public class SetCollection {
    /*
    1.CONCEPT OF SET==>
     Set is a very useful concept in mathematics ==>
• Basically, Set is a type of collection of homogenos data that does not allow duplicate
elements.
• That means an element can only exist once in a Set.
• Like other collection objects set is also an important data structures and
widely used to implement many logics in programming.
• Unlike other collection type such as array, list, linked list, set collection
has the following distinctive characteristics.
=>Duplicate elements are not allowed.
=>Elements are not stored in order

    2.INTERFACE FOR SET =>
 1]Set
 2]SortedSet
 3]NaviagbleSet

 2.1]Set interface
• The Set interface defines a set. It extends Collection and specifies the behavior
of a collection that does not allow duplicate elements. Therefore, the add( )
method returns false if an attempt is made to add duplicate elements to a set. It
does not specify any additional methods of its own.
• Set is a generic interface that has this declaration:
interface Set<T>
Here, T specifies the type of objects that the set will hold.

 2.2]SortedSet Interface
The SortedSet interface extends Set and declares the behavior of a set sorted in
ascending order. SortedSet is a generic interface that has this declaration:
interface SortedSet<T>
Here, T specifies the type of objects that the set will hold.

==>METHODS IN SORTED SET INT

*Comparator<? super E> comparator( )==>
Returns the invoking sorted set’s comparator. If the natural ordering is used for
this set, null is returned.
*E first( ) ==>Returns the first element in the invoking sorted set.
*SortedSet<E>headSet(E end) ==>
Returns a SortedSet containing those elements less than end that are contained
in the invoking sorted set. Elements in the returned sorted set are also
referenced by the invoking sorted set.
*E last( ) ==>Returns the last element in the invoking sorted set.
*SortedSet<E>subSet(E start, E end)==>
Returns a SortedSet that includes those elements between start and end–1.
Elements in the returned collection are also referenced by the invoking object.
*SortedSet<E>tailSet(E start)==>
 Returns a SortedSet that contains those elements greater than or equal to start
that are contained in the sorted set. Elements in the returned set are also
referenced by the invoking object.

 2.3]
• The NavigableSet interface extends SortedSet and declares the behavior of a collection that
supports the retrieval of elements based on the closest match to a given value or values.
• NavigableSet is a generic interface that has this declaration:
interface NavigableSet<T>
Here, T specifies the type of objects that the set will hold

==>METHODS IN NAVIGABLE SET
*E ceiling(E obj) ==>
Searches the set for the smallest element e such that e >= obj. If such an
element is found, it is returned. Otherwise, null is returned.
*Iterator<E> descendingIterator( )==>
Returns an iterator that moves from the greatest to least. In other words, it
returns a reverse iterator.
*NavigableSet<E>descendingSet( )==>
Returns a NavigableSet that is the reverse of the invoking set. The
resulting set is backed by the invoking set.
*E floor(E obj) ==>
 Searches the set for the largest element e such that e <= obj. If such an
element is found, it is returned. Otherwise, null is returned.
*NavigableSet<E> headSet(E upperBound,boolean incl)==>
Returns a NavigableSet that includes all elements from the invoking set that
are less than upperBound. If incl is true, then an element equal to
upperBound is included. The resulting set is backed by the invoking set.
*E higher(E obj) ==>
Searches the set for the largest element e such that e > obj. If such an
element is found, it is returned. Otherwise, null is returned.
*E lower(E obj) ==>
Searches the set for the largest element e such that e < obj. If such an
element is found, it is returned. Otherwise, null is returned
* pollFirst( ) ==>Returns the first element, removing the element in the process.
Because the set is sorted, this is the element with the least value.
null is returned if the set is empty.
*E pollLast( ) ==>Returns the last element, removing the element in the process.
Because the set is sorted, this is the element with the greatest value.
null is returned if the set is empty.
*NavigableSet<E> subSet(E lowerBound, boolean lowIncl,E upperBound, boolean highIncl) ==>
Returns a NavigableSetthat includes all elementsfrom the
invoking set that are greater than lowerBound and less
than upperBound. If lowIncl is true, then an element equal to
lowerBound is included. If highIncl is true, then an element equal to
upperBound is included. The resulting set is backed by the invoking
set.
*NavigableSet<E> tailSet(E lowerBound, boolean incl)    ==>
Returns a NavigableSet that includes all elements from the invoking
set that are greater than lowerBound. If incl is true, then an element
equal to lowerBound is included. The resulting set is backed by the invoking set.

    3.CLAS ENUMSET ==>
• EnumSet extends AbstractSet and implements Set. It is specifically for use with
elements of an enum type.
• It is a generic class that has this declaration:
class EnumSet<E extends Enum<E>>
Here, E specifies the elements.
Notice that E must extend Enum<E>, which enforces the requirement that the elements
must be of the specified enum type.

   METHODS OF ENUMSET ==>
*static <E extends Enum<E>>EnumSet<E>allOf(Class<E>t) ==>
Creates an EnumSet that contains the elements in the enumeration
specified by t.
*static <E extends Enum<E>>EnumSet<E> complementOf(EnumSet<E> e)==>
Creates an EnumSet that is comprised of those elements not stored in e.
*static <E extends Enum<E>> EnumSet<E>copyOf(EnumSet<E> c) ==>
Creates an EnumSet from the elements stored in c.
*static <E extends Enum<E>> EnumSet<E>copyOf(Collection<E> c)==>
Creates an EnumSet from the elements stored in c.
*static <E extends Enum<E>> EnumSet<E>noneOf(Class<E> t)==>
Creates an EnumSet that contains the elements that are not in the
enumeration specified by t, which is an empty set by definition.
*static <E extends Enum<E>> EnumSet<E> of(E v, E …varargs)==>
Creates an EnumSet that contains v and zero or more additional
enumeration values.
*static <E extends Enum<E>>EnumSet<E> of(E v)==>
Creates an EnumSet that contains v.
*static <E extends Enum<E>> EnumSet<E> of(E v1, E v2) ==>
Creates an EnumSet that contains v1 and v2.
*static <E extends Enum<E>> EnumSet<E> of(E v1, E v2, E v3)==>
Creates an EnumSet that contains v1 through v3.
*static <E extends Enum<E>> EnumSet<E> of(E v1, E v2, E v3,E v4)==>
Creates an EnumSet that contains v1 through v4.
*static <E extends Enum<E>> EnumSet<E>of(E v1, E v2, E v3, E v4, E v5)==>
Creates an EnumSet that contains v1 through v5.
*static <E extends Enum<E>> EnumSet<E> range(E start, E end)==>
Creates an EnumSet that contains the elements in the range
specified by start and end.

===>Note:
• EnumSet defines no constructors. Instead, it uses the factory methods defined for
EnumSet class to create objects.
• All methods can throw NullPointerException.
• The copyOf( ) and range( ) methods can also throw IllegalArgumentException.
• The of( ) method is overloaded a number of times. This is in the interest of efficiency.
Passing a known number of arguments can be faster than using a vararg parameter
when the number of arguments is small.



    * * */
}
//P1.CREARTING A SET WITH A COLLECTION OF ENUMERATED OBJECTS
/* The following program illustrates the usage of a few basic methods of EnumSet.*/
//enum Color {RED, BLUE, GREEN, BLACK, WHITE, VIOLET, ORANGE, INDIGO};--> Can be dec here also
 class EnumSetDemo{
    enum Color {RED, BLUE, GREEN, BLACK, WHITE, VIOLET, ORANGE, INDIGO};
    public static void main(String[] args) {
// Creating a set
        EnumSet<Color> set1, set2, set3, set4, set5, set6;//We can only define objects
        //of enum type and cannot initialise it as there is no EnumSet constructor
// Adding elements
        set1 = EnumSet.of(Color.RED, Color.BLUE, Color.GREEN);
        set2 = EnumSet.complementOf(set1);//set2 will include all color exceot in set1
        set3 = EnumSet.allOf(Color.class);//set 3 i all color
        set4 = EnumSet.range(Color.BLACK, Color.VIOLET);//all elem from blac to violet
        set5 = EnumSet.copyOf(set2);
        //set6 = EnumSet.noneOf(set1);

        System.out.println("Set 1: "+ set1);
        System.out.println("Set 2: "+ set2);
        System.out.println("Set 3: "+ set3);
        System.out.println("Set 4: "+ set4);
        System.out.println("Set4 contains RED? " + set4.contains(Color.RED));
// Traversing elements
        set5.forEach(System.out::println);//**NEW FOR EACH
//System.out.println("Set 5: "+ set5);
        Iterator<Color> iter = set3.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}