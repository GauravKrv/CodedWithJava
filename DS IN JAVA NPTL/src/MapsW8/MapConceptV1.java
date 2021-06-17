package MapsW8;

public class MapConceptV1 {
    /*TODO{
    MAP FRAMEWORK IN JAVA : IT is used to surfe one DS called table, In most of the IT
    application a table is there, in database.

    1.CONCEPT OF MAPPING:
    • A Map is a data structure that's designed for fast lookups.
    • In map, data is stored in KEY-OBJECT pairs with every key being UNIQUE.
    • That is, no two objects should have the same key.
    • Each key MAPS to an object[this mspping is possbl with help of hashing function]
     and hence the name.
    • Thse pairs are called map entries

    =>Suppose, you want to maintain a large set of objects and you need to access
    them as fast as possible.
    Mapping mechanism in Java allows you do this associating a key to each object.
    With this, the user’s view of storing objects looks like a table below.
Key Object
k1 o1
k2 o2
k3 o2
k4 o5
k5 o9
k6 o6

    2.MAP AS A MTHEMATICAL ABSTRACTION OF FUNCTION
    • For an object (o), there is a key (k); mathematically o=h(k), where h denotes a function.
    • Intuitively, this function h is called a hash function.
    • Thus, map data structure models the function abstraction in mathematics.
    Figure below illustrates a map

    3.EXAMPLES OF MAPS:
    Maps are perfect to use for key-value association mapping such as dictionaries.
    The maps are used to perform lookups by keys or when someone wants to retrieve and
    update elements by keys.
Examples:
1. Filenames and their contents stored in a secondary storage place.
2. All error codes and their descriptions for a system.
3. Zip codes and delivery destinations in a courier service.
4. A map of managers and employees. Each manager (key) is associated with a
list of employees (value) he manages.
5. A map of classes and students. Each class (key) is associated with a list of
students (value).

    4.CHARACTERISTICS OF MAP:
    Following are some important characteristics about Map.
1. A map is a mechanism for the fast retrieval of an object.
2. In a map, an entry is characterized with a pair of elements: key and object.
3. Given a key you can find an object. In other words, retrieving an object requires a key
to be supplied.
4. The keys must be unique, but the objects may be duplicated.
5. A map cannot contain duplicate keys.
6. Mathematically, map implements an one-to-many and onto association

    5.HASHING FUNCTION==>
    • For the key-object association, a hash function is required.
    • This hash function, in fact, generates a code called hash code.
    • That is, with o=h(k), h being the hash function, given an object o, h returns a unique value k.
    • In general, his system dependent and for the internal use of the system.

=>A simple hash function is defined as follows.
h(k) = k mod 19
=>Here, mod is modulo remainder operation. Some examples are:
h(123) = 5
h(99) = 4
h(2014) = 0

=>Note that in this example, the hash function generates has codes within the rang [0, 1, …,
18] for any integer numbers. Thus, a key k is used to generate a hash code, which
determines where in memory the <k, o> pair is stored. This is why a map is also sometime
referred as a dictionary because of the way it works

E.x2:
==>h(24) = 5
==>h(12) = 5
=>not desirable, hashing function shoud be chosen in such a way thst
the memory locatoion it will return will be unique.


    6.NOTE HASH FUNCTION:
1. A key can be obtained for any kind of object that you want to use as reference to
objects, like integer, string, any used defined data type, such as Student, Book,
etc.
2. Since the keys have to uniquely identify the objects, all keys in a map must be
different.
3. In Java, there is a method called hashCode() defined in the class Object, which
produces a hash code of type int for any object. The method as it is
implemented in Java, usually it is the memory address where an object is stored.
Thus the method always produces distinct hash code for distinct objects.
4. Further, you can overwrite the method hashCode() for your own defined class of
objects. Here is an example, how you can do that

    7.EXAMPLES==>
Example:
int x; int h;
x = 555;
h = x.hashCode(); // Return a hash code for the key x
double y = 123.45;
h = y.hashCode(); // Return a hash code for the key y
h = “Debasis”.hashCode(); // Return the hash code for the object “Debasis”
Student s = new Student(); // S is an object of type Student
h = s.hashCode(); // Compile-time error!,becoz it will try to give the default hashcode which
will not be correct.SO WE CAN DDEFINE OWN Hashcode FOR A Class object


    8.MAPS IN JCF==>
    • Java introduces the concept of Map, which is another member in the
    Java Collection Framework.
    • In Java, a Map is an object that maps keys to values, or is a collection of
    key-value pairs.
    • It models the function abstraction in mathematics

   ---9,10,11->Another class

    12.SUMMARY - INTERFACES IN MP:
• Maps revolve around two basic operations: get( ) and put( ).
• To put a value into a map, use put( ), specifying the key and the value.
• To obtain a value, call get( ), passing the key as an argument. The value is returned.
• To obtain a collection-view of a map the entrySet( ) method can be used.
• To obtain a collection-view of the keys, use keySet().
• To get a collection-view of the values, use the method values( ).
Note: The Map interface is not a sub type of the Collection interfac

    9.THE MAP CLASES
===>There are several classes to implement the map interfaces. All classes extends the
AbstractMap class, which in turns implements the Map interface. This implies that all the
methods in the Map interface are mostly defined in them in addition to some of their own
methods. In the following, a brief description of each class followed by the constructors and
methods are briefly discussed.
• Creating a map container
• Storing objects into a map container
• Retrieving objects from a map container
• Removing objects from a map container
• Collection view of a map container
• Bulk operations on a Map

===>Following are the basic operations of a Map with the methods defined in Map framework:
• Association (put)
• Lookup (get)
• Checking (contains Key and contains Value)
• Modification (remove and replace)
• Cardinality (size and isEmpty)

    * * */
}
//1.Example: Overriding hashCode() method for a user-defined class
/* This program illustrates how the hashCode() can be rewritten to return a has code for a user
defined object. */

class Person {
    String firstName;
    String lastName;
    Integer age;
    Person (String f, String l, Integer a) {
        firstName = f;
        lastName = l;
        age = a;
    }
    public int hashCode() {
        return (5*firstName.hashCode() + 7 * lastName.hashCode() +11*age.hashCode()  );
    }
    public static void main(String args[]) {
        Person p = new Person("Rajat", "Ray", 21);
        int k = p.hashCode();
        System.out.println(p + "hashcode "+k);
    }
}
