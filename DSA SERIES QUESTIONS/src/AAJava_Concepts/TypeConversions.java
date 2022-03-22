package AAJava_Concepts;

public class TypeConversions {
    static void explicit(int a,int b){
        long res = 1;
        while (b-->0){
            res = res*a;
        }
        System.out.println(res%10);

    }

    public static void main(String[] args) {
        explicit(2,5);
    }
}
