public class AbsChild extends Abstrct{
    void display(int a){
        System.out.println("Display of CHild : "+a+" ");
    }
    void show(){//how to use this
        System.out.println("Inside Child Concrete Method show()");
    }
    @Override
    void display() {

        System.out.println("Hello child");
    }//if we want to use the parent class and if the parent class is abstract then
    //we have to override the abstract methods of that class.
    //and if we wont override the abstract mthod of its parent class then ultimately
    //WE HAVE TO DECLARE this class as abstract

    public static void main(String[] args) {
        AbsChild abChild = new AbsChild();
        abChild.display();
        Abstrct ab1 ;
        ab1 = new AbsChild();
        ab1.show();
        abChild.show();
    }
}
