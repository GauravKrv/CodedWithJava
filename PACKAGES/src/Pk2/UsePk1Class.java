package Pk2;
import Pk1.*;

public class UsePk1Class {
    public static void main(String[] args) {
       PackClass obj = new PackClass();
       //obj.sq(10);//-->not accessible as the access specifier of
        //sq() method was not public it was default modefied ,
        // , so we cannot acces it outside its parent package.
        System.out.println(obj.sq(10));

    }
}
