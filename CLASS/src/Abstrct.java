public abstract class Abstrct {

    //abstract keyword lets JVM know which method is abstract
    //abstract ethod always ends with a semicolon and is without curly braces as in concrete methhods;
    //A normal class cannot have an abstract method
    //Concrete class: all methods has concrete methods
    //Abstract class: if any one or all of the method is abstract inside this class, then the class becomes abstract
    //so we have to add an abstract keyword to the class
    void show(){
        System.out.println("Inside Concrete Method show()");
    }
    void display(){};
    void shows(){

    }

    public static void main(String[] args) {
        Abstrct abRef;//we can create an object reference of an abstract class
        //it is used to do object slicing

//We cannot directly instantiate the abstract class object,,it always requires curly braces
        abRef = new Abstrct() {
            @Override
            void display() {
                System.out.println("helloReference");

            }
        };
        Abstrct ab = new Abstrct() {
            @Override
            void display() {
                System.out.println("hello");
            }
        };
        abRef.display();
        ab.display();
    }

}
//OBJECTIVE OF ABSTRACT CLASS: To make its child classes override all its abstract methods

