public class Base {

      int x;
    void Display(){
        System.out.println("In BASE");
    }

    public static void main(String[] args) {
        Base b1;//

        int k=10;
        int y = 0;
        int z= k/y;

        System.out.println(z);    }
}

class Deriv extends Base{
    void Display(){
        System.out.println("In Derived");
    }

    public static void main(String[] args) {
        Base b = new Deriv();
        Deriv d = new Deriv();
        Base bs = new Base();
        b.Display();
        d.Display();
        bs.Display();


    }
}
