package GenericsW1;

/*
1.Why generic class?
• Observations
• Data are different.
• Algorithms (i.e., logic) are same for all methods.
• Different programs.
• CODE DUPLICATIOINS CAN BE AVOIDED

2.The syntax for declaring a generic class is as follows:
[<<Access] class <ClassName><<Type1> [, <Type2>, …]> {
… body of the class
}

3.Here, is the full syntax for declaring a reference to a generic class and
instance creation:
<className><typeList> varName= new<className><typeList> (<InputArray>);





* * */
public class GenericClass <T>
{
    public T x;
    public GenericClass(T t){  //constructor
        x = t;
    }
    //print T type value for an object.
public void printData(){
    System.out.println(x);
}//this completes the definition of a simple generic class GenericClass <T>


    public static void main(String[] args) {
        //A data with the member as string -> here T = String and a is the
        //name of the object of type generic
        GenericClass<String> a =new GenericClass<String>("Java"); //A string object of the main class

        //A data with the member as  integer value
        GenericClass<Integer> b = new GenericClass<Integer>(123);


        a.printData();
        b.printData();

    }
}

//----Using the defined GenericClass <T>
//The driver class is programmed below, which creates different types of objects.
class GenericClassTest {
    public static void main( String args[] ) {
// A data with the member as String
        GenericClass<String> a = new GenericClass<String>("Java");
        a.printData();
// A data with the member as integer value
        GenericClass<Integer> b = new GenericClass<Integer>(123);
        b.printData();
// A data with the member as float value
        GenericClass<Double> c = new GenericClass<Double>(3.142);
        c.printData();
    }
}

