package BITMAGIC;

public class DivisibleBy4 {
    static boolean isDivisibleBy4(int n){
        //when no is div by 4 -> last two bits is always in off state
        if((n&1)==0 && ((n>>1)&1)==0){
            return true;
        }
        return false;
    }


    static boolean isDivisibleBy8(int n){
        //when no is div by 4 -> last two bits is always in off state
        if((n&7)==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 23;
        System.out.println(isDivisibleBy4(n));
        System.out.println(isDivisibleBy8(n));
    }


}
