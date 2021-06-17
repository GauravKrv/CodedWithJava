public class Derived2ndObjSlicing extends Base {
    void show(){

        System.out.println("In derived2");
    }
    public static void main(String[] args) {
        Derived2ndObjSlicing d;//object reference of derived class
        Base b;//b is object reference of base class here and no obj is created yet
        //but if we want to store hashcode ofr the base or derived class then we have t create an obj for this obj reference


        //1.NOW , BASE CLASS REFERENCE CAN HOLD DERIVED CLASS OBJECT, BUT THEN OBJECT SLICING WILL TAKE PLACE
        //2.BUT DERIVED CLASS REFERENCE CANNOT HOLD BASE CLASS OBJECT
       //1.-- b = new Derived2nd();//NOW BASE CLASS CAN EFER TO THE DERIVED CLASS OBJECT
       //2.--d = new Base();-->BUT THI WILL BE INCORRRECT..
        //AS DERIVED CLASS REFERENCE CANNOT HOLD BASE CLASS OBJECT

        b = new Base();
        b.Display();
        Derived2ndObjSlicing d1 = new Derived2ndObjSlicing();
        Base b1 = new Base();
        b = d1;//IT WILL WORK
       // b.show(); //-->ERROR-->OBJECT SLICING takes place here
        //obj slicing[due to a base class REFERENCE] only allows whatever coming from base class and
        //does not  allows to execute derived class method
        b.Display();//-->NOT ERROR


        Base b2 = new Derived();
        Base b3 = new Base();
        b3.Display();



    }

}
