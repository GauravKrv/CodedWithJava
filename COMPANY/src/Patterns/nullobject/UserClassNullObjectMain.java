package Patterns.nullobject;

public class UserClassNullObjectMain {

    public static void main(String[] args) {
        int ans = 3;
        if (ans%2==1){
            System.out.println(new DemoClassNull());
        }else{
            System.out.println("Do something with Non Null object");
        }
    }
}
