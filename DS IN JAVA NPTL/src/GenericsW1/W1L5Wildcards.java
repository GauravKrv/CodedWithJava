package GenericsW1;

public class W1L5Wildcards<T extends Number> {
    //the following class is to ake a program so that a student mak can be stored in an number format htat is, integer , hort, Double, float
    //long , etc
    String name;
    T[] marks;
    W1L5Wildcards(T[] m){
        marks = m;
    }
    //this method to calculate the total of marks obtained by the student
    double total(){

        double sum = 0.0;
        for(int i = 0;i<marks.length;i++){
           // sum += marks[i];-->will give error
            sum += marks[i].doubleValue();

        }
        return sum;
    }
    boolean compareMarks(W1L5Wildcards<?> others){
        //here wildcard is introduced to tell that the comparison
        // function can work for any type of input
        if(total() == others.total()){
            return true;
        }else {
            return false;
        }
    }
}//end of generic class definition

class W1L5GenericListDemo{
    public static void main(String[] args) {
        Integer intMarks1[] = {1,2,3,4,5};
        W1L5Wildcards<Integer> s1IntMarks = new W1L5Wildcards<>(intMarks1);
        System.out.println("Total marks = "+s1IntMarks.total());

        Integer intMarks2[] = {1,22,3,24,35};
        W1L5Wildcards<Integer> s2IntMarks = new W1L5Wildcards<>(intMarks2);
        System.out.println("Total marks = "+s2IntMarks.total());

        Double dblMarks2[] = {1.0,22.0,3.0,24.0,35.0};
        W1L5Wildcards<Double> s2DoubleMarks = new W1L5Wildcards<>(dblMarks2);
        System.out.println("Total marks = "+s2DoubleMarks.total());

        if (s1IntMarks.compareMarks(s2IntMarks))
            //
            System.out.println("Same marks");
        else
            System.out.println("Different Marks");

       if (s1IntMarks.compareMarks(s2DoubleMarks))//->gives error as
       //we cannont ocmpare a integer type with double value
            //
            System.out.println("Same marks");
        else
            System.out.println("Different Marks");


    }

}