import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
//AALL ABOUT ArrayList Class----->

/*
 * IMPORTANT POINTS:
 *1.Allows to have dupliates but of homogenous datatype
 * 2.Maintains insertion order
 * 3.Classs is non-synco
 * 4.Allows random access
 * 5.Supports dynamic arays tha can grow as needed
 * 6.Manupulation is slow
 * */
/*
 * CONSTRUCTORS:
 * ArrayList(),
 *  ArrayList(Collection<? extends T> c) ->it is used to build an array that
 * is nitialised with the elements of the collection c,
 * ArrayList(int capacity)*/

/*
 * add() methods different types:
 * 1.void add(index, element)
 * 2.void add(element)
 * 3.boolean addAll(Collection<? extends T> c)
 * */
/* Get set and remove methods of diff types are also resent*/

    /*REMOVING::
1. How to remove the element at a given index in an ArrayList | remove(int index)
1. How to remove an element from an ArrayList | remove(Object o)
2. How to remove all the elements from an ArrayList that exist in a given collection |
removeAll()
3. How to remove all the elements matching a given predicate | removeIf()
4. How to clear an ArrayList | clear()
Example 13.6: Deletion from an ArrayList collection
NP*/

    /*SORTING AN ARAYLIST
    * Sorting an ArrayList is a very common task that you will encounter in your programs.
1.Sort an ArrayList using Collections.sort() method.
2.Sort an ArrayList using ArrayList.sort() method.
3.Sort an ArrayList of user defined objects with a custom comparator.
*/

    //PROGRAMS RELATED TO ALL ABOVE USES
public class ArrayListW3L3 {

        public static void main(String[] args) {
// 1--->Creating an ArrayList of String
            ArrayList<String> animals = new ArrayList<String>();
// Adding new elements to the ArrayList
            animals.add("Lion");
            animals.add("Tiger");
            animals.add("Cat");
            animals.add("Dog");
// animals.add(2019); Is it valid? No
// This shows how an entire collection can be displayed
            System.out.println(animals);
        }


}

//2--->CreateArrayListFromCollectionExample
 class CreateArrayListFromCollectionExample {
    public static void main(String[] args) {
// Creating a collection first. Let it be with the simple method
        ArrayList<Integer> aList = new ArrayList<Integer>(); //Declaring aList as a collection
        aList.add(2); // Adding elements into the aList collection
        aList.add(3);
        aList.add(5);
        aList.add(7);
        aList.add(11);
// Creating another collection initially with aList collection
        ArrayList<Integer> numbers = new ArrayList<Integer>(aList);
        numbers.add(13); // Add two more numbers into the numbers collection
        numbers.add(17);
        System.out.println(aList); // Now, yu have two collections: aList and numbers.
        System.out.println(numbers); // Printing the two collections
    }
}

//3--->AN ARRAY LIST CAN WORK WITH USER DEFINED DATATYPES
 class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void printData() {
        System.out.println(name + " " + age);
    }
}
 class ArrayListUserDefinedObjectDemo{
    public static void main(String[] args) {
// Declaring pList as a collection of type Person of capacity 5
        ArrayList<Person> pList = new ArrayList<Person>(5);
        pList.add(new Person("Ram", 25));
        Person p2 = new Person("Sita", 22); // Create a new object
        pList.add(p2); // add the object
        pList.add(new Person("John", 34));
        pList.add(p2); // Duplicate entry is allowed
        pList.add(new Person("Rahim", 29)); // Five objects are added
        pList.add(new Person("Lilly", 24));
// No issue to accommodate, list grows dynamically
        pList.forEach(p -> p.printData());
// An way to access each object in a class
    }
}

//4-->USING ADDALL() TO ADD A LIST INSIDE OTHER LIST
 class InsertionArrayListDemo {

    public static void main(String[] args) {
// Creating a collection first. Let it be with the simple method
        ArrayList<Integer> odd = new ArrayList<>(); // Declaring aList as a collection
// Adding elements into the odd collection
        odd.add(1);
        odd.add(3);
        odd.add(5);
        odd.add(7);
        odd.add(9);
        System.out.println(odd);

        ArrayList<Integer> numbers = new ArrayList<Integer>(odd);
        System.out.println(numbers); // same as odd
// Creating another collection, say even1
        ArrayList<Integer> even1 = new ArrayList<Integer>();
// Add numbers into the even1 collection
        even1.add(2);
        even1.add(4);
        even1.add(6);
// Insert all the elements of even1 collection at the end of number collection
        numbers.addAll(even1);
        System.out.println(numbers);

// Creating another collection, say any
        ArrayList<Integer> any = new ArrayList<Integer>();
// Add numbers into “any” collection
        any.add(8);
        any.add(11);
        any.add(13);
// Add the collection any at 5-th location of the collection numbers
        numbers.addAll(5, any);
//add an object at a specific location of the colletion numbers
        numbers.add(0,0);
        System.out.println(numbers);
// What will happen to the following?
//numbers.add(100,999); ??
    }
}

//5--->GET AND SET METHODS:

 class AccessingArrayListObjects{
    public static void main(String[] args) {
        ArrayList<String> topCompanies = new ArrayList<String>();
// Check if an ArrayList is empty
        System.out.println("Is the topCompanies list empty? : " + topCompanies.isEmpty());
        topCompanies.add("Google");
        topCompanies.add("Apple");
        topCompanies.add("Microsoft");
        topCompanies.add("Amazon");
        topCompanies.add("Facebook");

       // Find the size of an ArrayList
        System.out.println("Here are the top " + topCompanies.size() + "Companies in the world");
        System.out.println(topCompanies); // Print the companies names
// Retrieve the element at a given index using GET
        String bestCompany = topCompanies.get(0);
        System.out.println("Best Company: " + bestCompany);
        String secondBestCompany = topCompanies.get(1);
        System.out.println("Second Best Company: " + secondBestCompany);
        String lastCompany = topCompanies.get(topCompanies.size() - 1);
        System.out.println("Last Company in the list: " + lastCompany);
// Modify the element at a given index using SET

        topCompanies.set(4, "Walmart");//REPLACES THE 4TH INDEXED ELEMENT WITH THIS ELEMENT
        System.out.println("Modified top companies list: " + topCompanies);
    }
}


//6-->DELETION IN ARRAYLIST
class DeletionArrayListDemo {
    public static void main(String[] args) {
// Create a collection. Initially empty
        ArrayList<String> langs = new ArrayList<String>();
// Add elements into the collection
        langs.add("C");
        langs.add("C++");
        langs.add("Java");
        langs.add("Python");
        langs.add("R");
        langs.add("Spark");
        System.out.println("Initial List: " + langs);

        // Removing elements from the collection
        langs.remove(5); // Remove the element at index `5`
        System.out.println("After remove(5): " + langs);
// Remove the first occurrence of the given element from the ArrayList
        boolean status = langs.remove("Smalltalk");
        System.out.println("Smalltalk is removed : " + status);
// Remove all the elements that exist in a given collection
        ArrayList<String> script = new ArrayList<String>();
        script.add("SQL");
        script.add("Python");
        script.add("Javascript");
        langs.removeAll(script); // Remove intersection of langs and script
        System.out.println("After script removal: " + langs);

        langs.removeIf(new Predicate<String>() {@Override
        public boolean test(String s)
        { return s.startsWith("C"); }
                       });


/*removeIf is an iterface here which allows us to create an string which gives some condition
 The above removeIf() call can also be written using lambda expression like this :
langs.removeIf(s -> s.startsWith("C"));
*/
        System.out.println("After Removing all elements that start with \"C\": " + langs);
// Remove all elements from the ArrayList
        langs.clear();
        System.out.println("List is empty? " + langs.isEmpty());
    }
}
//7-->SEARCHING TRY OWN

//8-->SORTING AN AARRAYLIST COLLECTION***

//A)USING Collection.sort()
class ArrayListCollectionsSortExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(13);
        numbers.add(7);
        numbers.add(18);
        numbers.add(5);
        numbers.add(2);
        System.out.println("Before : " + numbers);
// Sorting an ArrayList using Collections.sort() method
        Collections.sort(numbers);
        System.out.println("After : " + numbers);
    }
}

//B)Sorting using ArrayList.sort()
 class ArrayListSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Lisa");
        names.add("Preeti");
        names.add("Jay");
        names.add("Soma");
        System.out.println("Names : " + names);
// Sort an ArrayList using its sort() method.
// You must pass a Comparator to the ArrayList.sort() method.
        names.sort(new Comparator<String>() {
            @Override//MUST BE  INTEFACE-MY using str,str signatured compare method
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });
        System.out.println("Sorted Names : " + names);
    }
}
//C)SORTING Using Custom Comparator
class Person2 {
    private String name;
    private Integer age;
    public Person2(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
class ArrayListObjectSortExample {
    public static void main(String[] args) {
        List<Person2> people = new ArrayList<>();
        people.add(new Person2("Sachin", 47));
        people.add(new Person2("Chris", 34));
        people.add(new Person2("Rajeev", 25));
        people.add(new Person2("David", 31));
        System.out.println("Person List : " + people);
// Sort People by their Age
        people.sort((person1, person2) -> {
            return person1.getAge() - person2.getAge();
        });
// A more concise way of writing the above sorting function
        people.sort(Comparator.comparingInt(Person2::getAge)); //-->WAY of def a comprtor method
        System.out.println("Sorted Person List by Age : " + people);
// Sort using Collections.sort() method by passing the custom Comparator
        Collections.sort(people, Comparator.comparing(Person2::getName));
        System.out.println("Sorted Person List by Name : " + people);
    }
}

//9-->TRAVERSING AN ARRAYLIST LATER DISCUSS

//10-->HAS SOME METHODS CALLLED BulkOperations



