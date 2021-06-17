package W12StringAndUtilities;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SplitIterator {
    /*1.INTRODUCTION :

    Spliterator, like other Java cursors, is for traversing the elements of a collection.
• Unlike other cursors, it can traverse both in parallel as well as sequential manner. The
name is so because it is actually splitting + iterator to accomplish a parallel traversing.
• It was included in JDK 8 and is defined by the Spliterator interface.
• Compare to other cursors, it offers substantially more functionality.
• The most important aspect of Spliterator is its ability to provide support for parallel
iteration of portions of the sequence and hence providing parallel programming.
• The Spliterator defines 8 methods which are listed next. All methods are duly
implemented in Collection classes


    * */
}

class SpliteratorDemo {
    public static void main(String args[]) {
// Create an array list for doubles.
        ArrayList<Double> vals = new ArrayList<>();
// Add values to the array list.
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // Use tryAdvance() to display contents of vals.
        System.out.println("Contents of vals: ");
        Spliterator<Double> spltitr = vals.spliterator();
        while (spltitr.tryAdvance((n) -> System.out.println(n))) ;
        System.out.println();
// Create new list that contains square roots.
        spltitr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while (spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n)))) ;
// Use forEachRemaining() to display contents of sqrs.
        System.out.print("Contents of sqrs:\n");
        spltitr = sqrs.spliterator();
        spltitr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();
    }
    /*NOTE:

    • The program demonstrates both tryAdvance( ) and forEachRemaining( ).
• These methods combine the actions of Iterator’s next( ) and hasNext( ) methods into a
single call.
    * */
}

//2.UTILITY METHODS OF SPLIT ITERATOR
class SpliteratorDemo2 {
    public static void main(String[] args) {
// Create an array list for doubles.
        ArrayList<Integer> al = new ArrayList<>();
// Add values to the array list.
        al.add(1);
        al.add(2);
        al.add(-3);
        al.add(-4);
        al.add(5);
// Obtain a Stream to the array list.
        Stream<Integer> str = al.stream();
// getting Spliterator object on al
        Spliterator<Integer> splitr1 = str.spliterator();
// estimateSize method
        System.out.println("estimate size : " + splitr1.estimateSize());
// getExactSizeIfKnown method
        System.out.println("exact size : " + splitr1.getExactSizeIfKnown());
// hasCharacteristics and characteristics method
        System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));
        System.out.println("Content of arraylist :");
// forEachRemaining method
        splitr1.forEachRemaining((n) -> System.out.println(n));
// Obtaining another Stream to the array list.
        Stream<Integer> str1 = al.stream();
        splitr1 = str1.spliterator();
// trySplit() method
        Spliterator<Integer> splitr2 = splitr1.trySplit();
// If splitr1 could be split, use splitr2 first.
        if (splitr2 != null) {
            System.out.println("Output from splitr2: ");
            splitr2.forEachRemaining((n) -> System.out.println(n));
        }
// Now, use the splitr
        System.out.println("\nOutput from splitr1: ");
        splitr1.forEachRemaining((n) -> System.out.println());
    }
}
/*
Utility of other methods of Spliterator
    Have a look at tryAdvance() method. It performs an action on the next element and then advances the iterator. It
        is shown here:
        boolean tryAdvance(Consumer<? super T> action)
        Here, action specifies the action that is executed on the next element in the iteration and Consumer is a
        functional interface that applies an action to an object. It is a generic functional interface declared in
        java.util.function. It has only one abstract method, accept( ), which is
        shown here:
        void accept(T objRef) // Here T is type of object reference.
        For implementing our action, we must implement accept method. To implement accept method, here we use
        lambda expression .This will be more clear from below example.
        How to use Spliterator with Collections: Using Spliterator for basic iteration tasks is quite easy, simply call
        tryAdvance( ) until it returns false
        */
class SpliteratorDemo3 {
    public static void main(String[] args) {
// Create an array list for doubles.
        ArrayList<Integer> al1 = new ArrayList<>();
// Add values to the array list.
        al1.add(1);
        al1.add(2);
        al1.add(-3);
        al1.add(-4);
        al1.add(5);
// Use tryAdvance() to display(action) contents of arraylist.
        System.out.print("Contents of arraylist:\n");
// getting Spliterator object on al1
        Spliterator<Integer> splitr = al1.spliterator();
// Use tryAdvance() to display(action) contents of arraylist.
// Notice how lambda expression is used to implement accept method
// of Consumer interface
        while (splitr.tryAdvance((n) -> System.out.println(n))) ;
// Use tryAdvance() for getting absolute values(action) of contents
       // of arraylist.
// Create new list that contains absolute values.
        ArrayList<Integer> al2 = new ArrayList<>();
        splitr = al1.spliterator();
// Here our action is to get absolute values
// Notice how lambda expression is used to implement accept method
// of Consumer interface
        while (splitr.tryAdvance((n) -> al2.add(Math.abs(n)))) ;
        System.out.print("Absolute values of contents of arraylist:\n");
// getting Spliterator object on al2
        splitr = al2.spliterator();
        while (splitr.tryAdvance((n) -> System.out.println(n))) ;
    }
}
/*NOTE:
How tryAdvance( ) consolidates the purposes of hasNext( ) and next( ) provided by
Iterator into a single method in above example. This improves the efficiency of the
iteration process.
• To perform some action on each element collectively, rather than one at a time
Spliterator provides the forEachRemaining( ) method, it is generally used in cases
involving streams. This method applies action to each unprocessed element and
then returns.
* */

