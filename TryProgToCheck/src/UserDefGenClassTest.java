
//defining the driver c
// lass
class UserDefGenClassTest<S>{
    S obj1;
    public S getObj(S obj2){
        System.out.println("In UsERTEST"+"S sobj1 = "+obj2);
        return obj2;
    }
    public static void main(String[] args) {
        //To declae an ovject of class UserDefGenClass of different types:
        //WE CAN DO THESE AS FOLOWS:
        UserDefGenClassTest<Integer>  a2obj = new UserDefGenClassTest<>();
        a2obj.getObj(55);

        UserDefGenClass<Integer> aobj = new UserDefGenClass<>(15);
        System.out.println(aobj.getObj());
        UserDefGenClass<String> strobj = new UserDefGenClass<>("hello");
        System.out.println(strobj.getObj());

        //To declare an object for Stydent type
        Student s1 = new Student("Gaurav",99.9f);
        UserDefGenClass<Student> sObj = new UserDefGenClass<Student>(s1);
        System.out.println(sObj.getObj().name + " " + sObj.getObj().marks);
    }
}

class Student{
    String name;

    float marks;
    Student(String name,  float marks){
        this.name = name;
        this.marks = marks;
    }
}
class UserDefGenClass<T> {  //defining generic class for the user defined dt
    T obj;
    UserDefGenClass(T obj){
        this.obj = obj;
    }
    public T getObj(){
        return this.obj;
    }
}


//DEFINING A USER DEFINED DATA


