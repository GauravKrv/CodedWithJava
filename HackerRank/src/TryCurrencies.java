import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class TryCurrencies {
    public static void main(String[] args) {
    double num = 1234.345;


    Locale l = new Locale("en","IN");//Creating a locale


        System.out.println("US: "+NumberFormat.getCurrencyInstance(Locale.US).format(num));
        System.out.println("China: "+NumberFormat.getCurrencyInstance(Locale.CHINA).format(num));
        System.out.println("France: "+NumberFormat.getCurrencyInstance(Locale.FRANCE).format(num));
        System.out.println("India: "+NumberFormat.getCurrencyInstance(l).format(num));

    }
}
