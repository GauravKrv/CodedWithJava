package BITMAGIC;

public class CountIsPower2NoLoop {
    static void checkIsPower2(int n){
        if((n&(n-1))==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {

    }
}
