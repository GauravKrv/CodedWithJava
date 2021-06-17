public class BaseWithCons {
    int x;
    BaseWithCons(int x){
       this.x = x;
    }
    void show(){
        x = x + 2;
        System.out.println("X ="+x);
    }
    void display(){
        System.out.println("X= "+ x);
    }
}
