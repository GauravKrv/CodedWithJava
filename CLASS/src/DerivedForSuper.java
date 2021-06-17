public class DerivedForSuper extends BaseWithCons {
    int y;
    DerivedForSuper(int y){
        super(y);//to use the instance vvar of the base class we use super and pass some food to
        //our parent as we are creating an object fro base and it should be done in first place
        this.y = y;
    }

    void show(){
        y = y+1;
        System.out.println("Y = "+ y);
    }
    public static void main(String[] args) {
        DerivedForSuper ds = new DerivedForSuper(10);
       /* BaseWithCons bc = new BaseWithCons(20);
        bc.display();
        bc.show();
        o/p:
X= 20
X =22
Y = 11
X= 10*/
        ds.show();
        ds.display();//will show error,  so IF  BASE CLASS HAS "PARAMETERISED CONS" THEN THE DERIVED CLASS CONS MUST ]
        //PASS some value to the base class cons using "super".

    }
}
//whenever we are creating obj for derived and we are extending the derived to base class
//then first base class constructor will be executed and then only it will
//execute the derived class constructor as parent>child.