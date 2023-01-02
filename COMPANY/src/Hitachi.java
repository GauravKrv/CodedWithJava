import java.util.HashSet;
import java.util.Set;

public class Hitachi {


    static int numDistinct(int arr[])
    {
        int mod = 1000000009;
        int n = arr.length;
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            hash.add(arr[i]);
        }
        int count =(int) ((long) Math.pow(hash.size(), 2))%mod;

        return count;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(numDistinct(a));
    }
}

class q2{

    static void solve(String str)
    {
        Set<String> hashSet = new HashSet<>();
        int n =str.length();
        for (int i = 1; i < n; i++) {
                StringBuilder s = new StringBuilder(str.substring(i)+str.substring(0,i));
                hashSet.add(String.valueOf(s));
                hashSet.add(String.valueOf(s.reverse()));
        }
        hashSet.add(str);
        hashSet.add(String.valueOf((new StringBuilder(str)).reverse()));
        System.out.println(hashSet.size()); ;

    }

    // Driver code
    public static void main(String args[])
    {
        String str = "aabbbbaaaabbbbaaa";
        String str2 = "abcd";

//        System.out.println(solve(str));


    }
}

class H extends Thread {
    public static void main(String[] args) {

        int a = 100;
        int b = 200;
        b= a++ + b++;
        if (b%2==0) System.out.println(a++ + " "+ --b);
        else System.out.println(--a + " "+ ++b);
    }
}
class Main{
    transient int numb;

    public static void main(String[] args) {

    }
}