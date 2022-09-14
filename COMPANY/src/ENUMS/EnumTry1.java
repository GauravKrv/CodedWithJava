package ENUMS;

public class EnumTry1 {
     enum Cards{
        SPADES,DIAMONDS,HEARTS,CLUBS;

         static void print(){
             System.out.println(SPADES);
         }
    }

    public static void main(String[] args) {
        System.out.println(Cards.CLUBS);
        Cards c;

        Cards.print();
    }
}

// A Java program to demonstrate working on enum
// in switch case (Filename Test. Java)

// An Enum class
enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

// Driver class that contains an object of "day" and
// main().
 class Test {
    Day day;

    // Constructor
    public Test(Day day) { this.day = day; }

    // Prints a line about Day using switch
    public void dayIsLike()
    {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        String str = "MONDAY";
        Test t1 = new Test(Day.valueOf(str));
        t1.dayIsLike();
    }
}
/*Every enum constant is always implicitly public static final. Since it is static, we can access it by using the enum Name. Since it is final, we can’t create child enums.
We can declare the main() method inside the enum. Hence we can invoke enum directly from the Command Prompt.*/
enum Color {
    RED,
    GREEN,
    BLUE;

    // Driver method
    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}