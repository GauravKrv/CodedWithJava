public class DatesFinding {
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



        return weekd[(w+4)%6];
    }

    public static void main(String[] args) {
        System.out.println(findDay(12,3,2020));
    }
}

class GFG
{
    static int dayofweek(int d, int m, int y)
    {
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        y -= (m < 3) ? 1 : 0;
        return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }

    // Driver Program to test above function
    public static void main(String arg[])
    {
        int day = dayofweek(30, 12, 2020);
        System.out.print(day);
    }
}
