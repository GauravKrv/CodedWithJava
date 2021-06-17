package W12StringAndUtilities;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import static java.util.Calendar.DAY_OF_WEEK;
import static jdk.nashorn.internal.objects.NativeDate.getDay;

public class MiscellaneousUtililties {
    /*
    1.STRING TOKENIZER CLASS
    • The processing of text often consists of parsing a formatted input string. Parsing is the
division of text into a set of discrete parts, or tokens, which in a certain sequence can
convey a semantic meaning.
• The StringTokenizer class provides the first step in this parsing process, often called
the lexer (lexical analyzer) or scanner.
• StringTokenizer implements the Enumeration interface.
• Therefore, given an input string, you can enumerate the individual tokens contained
in it using StringTokenizer

TOKEN - Subpart of a string

CONSTRUCTORS :
Constructor Description
StringTokenizer(String str) Constructs a string tokenizer for the specified string.
StringTokenizer(String str, String delim) Constructs a string tokenizer for the specified string.
StringTokenizer(String str, String delim,
boolean returnDelims)
Constructs a string tokenizer for the specified string

METHODS :
Method Description
countTokens() Calculates the number of times that this tokenizer's nextToken method can be called
before it generates an exception.
hasMoreElements() Returns the same value as the hasMoreTokens method.
hasMoreTokens() Tests if there are more tokens available from this tokenizer's string.
nextElement() Returns the same value as the nextToken method, except that its declared return
value is Object rather than String.
nextToken() Returns the next token from this string tokenizer.
nextToken(String delim) Returns the next token in this string tokenizer's strin


2.DATE CLASS-------------------------------------------------
The Date class encapsulates the current date and time.
• When Java 1.1 was released, many of the functions carried out by the original Date class
were moved into the Calendar and DateFormat classes, and as a result, many of the original
1.0 Date methods were deprecated.
• Since the deprecated 1.0 methods should not be used for new code, they are not described
here.

CONSTRUCTORS :
Constructor Description
Date() Allocates a Date object and initializes it so that it represents the time at which it was
allocated, measured to the nearest millisecond.
Date(long date) Allocates a Date object and initializes it to represent the specified number of
milliseconds since the standard base time known as "the epoch", namely January 1,
1970, 00:00:00 GMT.

METHODS :
Method Description
after(Date when) Tests if this date is after the specified date.
before(Date when) Tests if this date is before the specified date.
clone() Return a copy of this object.
compareTo(Date anotherDate) Compares two Dates for ordering.
equals(Object obj) Compares two dates for equality.
from(Instant instant) Obtains an instance of Date from an Instant object.
getTime() Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
represented by this Date object.
hashCode() Returns a hash code value for this object.
setTime(long time) Sets this Date object to represent a point in time that is time milliseconds
after January 1, 1970 00:00:00 GMT


3.CALENDER---------------------------------------
• The abstract Calendar class provides a set of methods that allows you to
convert a time in milliseconds to a number of useful components.
• The type of information that can be provided are
• Year
• Month
• Day
• Hour
• Minute
• Second
• It is intended that sub classes of Calendar will provide the specific functionality to
interpret time information according to their own rules.
• An example of such a sub class is GregorianCalendar.
Note:
JDK 8 defines a new date and time API in java.time, whicsh new apps may want to employ

METHODS :
Method Description
add(int field, int amount) Adds or subtracts the specified amount of time to the given calendar field, based on the
calendar's rules.
after(Object when) Returns whether this Calendar represents a time after the time represented by the
specified Object.
before(Object when) Returns whether this Calendar represents a time before the time represented by the
specified Object.
clear() Sets all the calendar field values and the time value (millisecond offset from the Epoch)
of this Calendar undefined.
clear(int field) Sets the given calendar field value and the time value (millisecond offset from the Epoch)
of this Calendar undefined.
clone() Creates and returns a copy of this object.
compareTo(Calendar anotherCalendar) Compares the time values (millisecond offsets from the Epoch) represented by
two Calendar objects.
complete() Fills in any unset fields in the calendar fields.
computeFields() Converts the current millisecond time value tim
AD MANY MORE--------

5.GEORFIEAN CALLENDER CLASS
:• GregorianCalendar is a concrete implementation of a Calendar that implements the
normal Gregorian calendar with which you are familiar.
• The getInstance( ) method of Calendar will typically return a GregorianCalendar
initialized with the current date and time in the default locale and time zone.
• GregorianCalendar defines two fields: AD and BC. These represent the two eras
defined by the Gregorian calendar.
• There are also several constructors for GregorianCalendar objects. The default,
GregorianCalendar(), initializes the object with the current date and time in the
default locale and time zone. Three more constructors offer increasing levels of specificity

CONSTRUCTORS ::
Constructor Description
GregorianCalendar() Constructs a default GregorianCalendar using the current time in the default time
zone with the default locale.
GregorianCalendar(int year, int month,
int dayOfMonth)
Constructs a GregorianCalendar with the given date set in the default time zone with
the default locale.
GregorianCalendar(int year, int month,
int dayOfMonth, int hourOfDay,
int minute)
Constructs a GregorianCalendar with the given date and time set for the default time
zone with the default locale.
GregorianCalendar(int year, int month,
int dayOfMonth, int hourOfDay,
int minute, int second)
Constructs a GregorianCalendar with the given date and time set for the default time
zone with the default locale.
GregorianCalendar(Locale aLocale) Constructs a GregorianCalendar based on the current time in the default time zone
with the given locale.
GregorianCalendar(TimeZone zone) Constructs a GregorianCalendar based on the current time in the given time zone
with the default locale.
GregorianCalendar(TimeZone zone, Locale aLocale)
Constructs a GregorianCalendar based on the current time in the given time zone
with the given locale.

5.TIMEZONE :----------------------------------------------------
• Another time-related class is TimeZone.
• The abstract TimeZone class allows you to work with time zone offsets from Greenwich mean time (GMT),
also referred to as Coordinated Universal Time (UTC).
• It also computes daylight saving time. TimeZone only supplies the default constructor.

   METHODS :
   Method Description
clone() Creates a copy of this TimeZone.
getAvailableIDs() Gets all the available IDs supported.
getAvailableIDs(int rawOffset) Gets the available IDs according to the given time zone offset in milliseconds.
getDefault() Gets the default TimeZone for this host.
getDisplayName() Returns a long standard time name of this TimeZone suitable for presentation to the
user in the default locale.
getDisplayName(boolean daylight,
int style)
Returns a name in the specified style of this TimeZone suitable for presentation to
the user in the default locale.
getDisplayName(boolean daylight,
int style, Locale locale)
Returns a name in the specified style of this TimeZone suitable for presentation to
the user in the specified locale.
getDisplayName(Locale locale) Returns a long standard time name of this TimeZone suitable for presentation to the
user in the specified locale.
getDSTSavings() Returns the amount of time to be added to local standard time to get local wall

6.SIMPLE TIMEZONE C;ASS :
• The SimpleTimeZone class is a convenient sub class of TimeZone.
• It implements TimeZone's abstract methods and allows you to work with time
zones for a Gregorian calendar.
• It also computes daylight saving time.

    * */
}
//1.
// Demonstrate simple parsing a text
class StringParsingDemo1 {
    public static void main(String args[]) {
        StringTokenizer st = new StringTokenizer("Joy with Java", " ");
        //here we are passing delimeter as a space.
        //Delemeter indicates that how we will split a string
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
//2.Example that creates a StringTokenizer to parse "key=value" pairs. Consecutive
// sets of "key=value" pairs are separated by a semicolon.
class STDemo {
static String in = "title=Java: Data Structures;" +
        "author=DS;" + "publisher=NPTEL;" + "copyright=2020;";


public static void main(String args[]) {
        StringTokenizer st = new StringTokenizer(in, "=;");


        while (st.hasMoreTokens()) {
        String key = st.nextToken();
        String val = st.nextToken();
        System.out.println(key + "\t" + val);
        }
        }
        }
//2.DATE AND TIEM
// Show date and time using only Date methods.
class DateDemo {
    public static void main(String args[]) {
// Instantiate a Date object
        Date date = new Date();
// display time and date using toString()
        System.out.println(date);
// Display number of milliseconds since midnight, January 1, 1970 GMT
        long msec = date.getTime();
        System.out.println("Milliseconds since Jan. 1, 1970 GMT = " + msec);
    }
}

//3.CALLENT=DER METHODS USING
// Demonstrate Calendar
class CalendarDemo {
    public static void main(String args[]) {
// Create a calendar initialized with the
// current date and time in the default
// locale and timezone.
        Calendar calendar = Calendar.getInstance();
// Display current time and date information.
        System.out.print("Date: ");
        System.out.print(calendar);
        System.out.print("Time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));
// Set the time and date information and display it.
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);
        System.out.print("Updated time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));
    }
}

//4.MORE CALENDER
// Program to demonstrate add() method of Calendar class
 class Calendar5 {
    public static void main(String[] args) {
// creating calendar object
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,12,30);

       // calendar.get(Calendar.DAY_OF_WEEK);
        //getDay(calendar);

        String weekd[] = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};

       /* System.out.println(weekd[calendar.get(Calendar.DAY_OF_WEEK) -1]);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
       */


       /* calendar.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + calendar.getTime());
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + calendar.getTime());
        calendar.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + calendar.getTime());*/
    }
}

//5.GEORGIEAN CALENFDER DEMO
// Demonstrate GregorianCalendar
class GregorianCalendarDemo {
    public static void main(String args[]) {
        String months[] = {"Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "DOc"};
        int year;
// Create a Gregorian calendar initialized
// with the current date and time in the
// default locale and timezone.
        GregorianCalendar gcalendar = new GregorianCalendar();
// Display current time and date information.
        gcalendar.set(2020,12,30);
        gcalendar.get(DAY_OF_WEEK);
        System.out.println(gcalendar);



       /* System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);//month[monthIndex]
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));
// Test if the current year is a leap year
        if (gcalendar.isLeapYear(year)) {
            System.out.println("The current year is a leap year");
        } else {
            System.out.println("The current year is not a leap year");
        }*/
    }
}


