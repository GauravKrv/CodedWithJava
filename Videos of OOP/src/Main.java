public class Main {
    public static void main(String[] args) {
//        Vehicle veh1 = new Vehicle();
//        System.out.println(veh1.count);
//       // System.out.println(veh1.name+"got it?"); Direct access wont work as the properties are made private now.
//
//        Vehicle veh2 = new Vehicle("honda","black","civic","honda",800);//
//        System.out.println(veh1.count);
//
//        veh2.setName("TVS");
//        System.out.println(veh2.getSpeed()); // ->using class props through getters
//
//   //     System.out.println(veh2.name); ->using class props directly
//        System.out.println(veh2.getName()); // ->using class props through getters
//
//        veh1.setName("city");
//       // System.out.println(veh1.name);
//        veh1.setName("hunk");
//       // System.out.println(veh1.name);
//
//        System.out.println(Vehicle.getVeh());//THIS IS HOW we call and print a static function directly from classname.

        Car car1 = new Car("honda","black","civic","honda",800,true,false);
        System.out.println(car1.getLedScreen());
        System.out.println(car1.getName()); //calling property values from parent class
        car1.setName("bugatti");
        System.out.println(car1.getName());

        //POLYMORPHISM
        Vehicle veh1 = new Vehicle("honda","black","civic","honda",800);
        System.out.println(veh1.getInfo()); //it will print"this is a vehicle" bocoz the object is created using Vehicle class

        Vehicle veh2 = new Car("honda","black","civic","honda",800,true,false);
        //NOW ABOVE THE PARENT CLASS IS BEING USED TO CREATE THE CHILD CLASS OBJECT,i.e prnts can contain the reference to the child objects.
        System.out.println(veh2.getInfo()); //it will print"this is a car" bocoz veh2 (parent variable) is refering to the object of child class


    }
}
