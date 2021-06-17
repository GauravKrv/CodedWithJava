public class Derived extends Base {

    void Display(){
        super.Display();//super keyword will be used to call the method which will refer
        //to the base class, if we wont use super and will tr to call the method
        //will result in na infinite loop.
        System.out.println("In derived");
    }

    public static void main(String[] args) {
        Derived d = new Derived();//object of derived class
       //Base b = new Base();//object of base class can aldso be creaed
      //b.Display();----->a parent can access its own members only
      //b.show();-----> a parent cannot access its child members
       // d.show();
        d.Display();
        d.Display();//if there are same methods with same signature[no of arguments] present in
        //base and DERIVED class rhen always the preference will be given to the
        //DERIVED Class and thiE whole scenerio is called METHOD OVERRIDING
    }

}

/*
base----->Display()
derived-------->show(),diesplay()



 */