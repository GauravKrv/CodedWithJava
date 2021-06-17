public class Derived3DMD extends Base {
    void Display(){//HERE METHOD OVERIDING IS TAKING PLACE
        System.out.println("In derived3");
    }
    public static void main(String[] args) {

        Base b;//b is object reference of base class here
        Derived3DMD d2 = new Derived3DMD();
        Base b1 = new Base();
        b = d2;//IT WILL WORK

        b.Display();//-->NOT ERROR  //dynamic method dispatch
        b1.Display();
        d2.Display();
        //DMD happens only when there is a method overriding as display method is present in
        //both base and derived class.
        //HERE which method to execute depeds upon object and not on reference
        //So since b is reffrered to Base but is pointinfg to object of derived
        //so it printd "IN DERIVED2 CLASS"



    }

}
