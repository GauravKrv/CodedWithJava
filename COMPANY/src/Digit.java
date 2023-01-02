import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Digit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        s1 = "2019-06-01 09:45:56";
        s2 = "2019-06-02 15:45:56";
        findDifference(s1,s2);

    }

        static void findDifference(String start, String end)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            try {

                Date d1 = sdf.parse(start);
                Date d2 = sdf.parse(end);


                long tdiff = d2.getTime() - d1.getTime();

                long secdiff = (tdiff / 1000) % 60;

                long mindiff = (tdiff/ (1000 * 60)) % 60;

                long hrdiff = (tdiff  / (1000 * 60 * 60))% 24;

                String h="",m="",s="";
                if (hrdiff<10)
                 h = "0"+hrdiff;
                else h= String.valueOf(hrdiff);
                if (mindiff<10)
                 m = "0"+mindiff;
                else m = String.valueOf(mindiff);

                if (secdiff<10)
                 s = "0"+ secdiff;
                else s = String.valueOf(secdiff);

                System.out.println(h+":"+m+":"+s);
            }

            catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }

    class Student{
    private String name;
    private int roll;

        public Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRoll() {
            return roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }
    }

    class CreateStudent{

        public static void main(String[] args) {
            Student s1 = new Student();
            s1.setName("Gaurav");
            s1.setRoll(27);
            System.out.println(s1.getName()+" "+s1.getRoll());

            Student s2 = s1;
            s2.setName("Saurav");

            System.out.println(s1.getName()+" "+s1.getRoll());
            System.out.println(s2.getName()+" "+s2.getRoll());


        }
    }


