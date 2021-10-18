package Mathematics;
//NOT WORKING
public class CountDigits {
    public static int countDigits(int n){
        return (int) Math.floor(Math.log10((10*n)) + 1);
    }

    public static int countDigitsInBits(int n){
        return (int) (Math.log((n))/Math.log((2)));
    }

    public static void main(String[] args) {
        System.out.println(countDigits(555));
        System.out.println(countDigitsInBits(2));
    }
}
