package W12StringAndUtilities;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;


public class TryCalender {
    public static void main(String[] args) {
        Calendar d = Calendar.getInstance();
        System.out.println("Todays date is :"+ d.get(Calendar.DATE));// display time and date using toString()
        System.out.println("Hour : "+d.get(Calendar.HOUR));
        System.out.println("Minutes: "+d.get(Calendar.MINUTE));
        System.out.println("Seconds : "+d.get(Calendar.SECOND));
        System.out.println("Day : "+d.get(Calendar.DAY_OF_WEEK));
        System.out.println("Month : "+d.get(Calendar.MONTH));
        System.out.println("Year: "+d.get(Calendar.YEAR));
        System.out.println("MORE : "+ (Calendar.AUGUST));
        System.out.println("MORE : "+ (Calendar.AUGUST+1));



    }
}
class TryGeorgianCalender {
    public static void main(String[] args) {
        GregorianCalendar g = new GregorianCalendar();
        System.out.println("Todays date is :"+ GregorianCalendar.DATE);// display time and date using toString()
        System.out.println("Hour : "+g.get(Calendar.HOUR));
        System.out.println("Minutes: "+g.get(Calendar.MINUTE));
        System.out.println("Seconds : "+g.get(Calendar.SECOND));
        System.out.println("Day : "+g.get(Calendar.DAY_OF_WEEK));
        System.out.println("Month : "+g.get(Calendar.MONTH));
        System.out.println("Year: "+g.get(Calendar.YEAR));
        System.out.println("MORE : "+ (Calendar.AUGUST));
        System.out.println("MORE : "+ (Calendar.AUGUST+1));



    }
}

 class TryDate {
    public static void main(String[] args) {
        Date d  = new Date();
        System.out.println("Todays date is :"+ d);// display time and date using toString()
        System.out.println("Hour : "+d.getHours());
        System.out.println("Minutes: "+d.getMinutes());
        System.out.println("Seconds : "+d.getSeconds());
        System.out.println("Day : "+d.getDay());
        System.out.println("Month : "+d.getMonth());
        System.out.println("Year: "+d.getYear());
        System.out.println(d.getTimezoneOffset());



    }
}


class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        if(month == 1){
            month = 11;
        }else  if(month == 2){
            month = 12;
        } else{
            month = month-2;
        }
        int w;
        w = (day+ ((((26*month)-2)/10)) -2*(year/100) + (year%100) + (year/100)/4)%7;
        String weekd[] = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
      return weekd[w-1];
    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



