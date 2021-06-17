package W12StringAndUtilities;

import java.util.Currency;
import java.util.Locale;

import static java.util.Currency.getAvailableCurrencies;
import static jdk.nashorn.internal.objects.Global.getSymbol;


public class TryW12 {

    public static void main(String[] args) { //7+ constructord
        char[] c = {'a','b','c','d','e'};
        String s = "Hello what u doun";
        System.out.println();
        String s2 = new String("what ya doun");
       // String s3 = new String("hellothrre",,4);
        s.toCharArray()[2] = 'h';
        System.out.println(s.toCharArray()[2]);
        System.out.println();
        StringBuffer sb = new StringBuffer("helaasto");
       // sb = "WOZAM";
        System.out.println(sb.append(s));
        Locale l = Locale.US;
        Currency c2 = Currency.getInstance(l);
        System.out.println(getAvailableCurrencies());
        System.out.println(c2.getSymbol());
    }
}
