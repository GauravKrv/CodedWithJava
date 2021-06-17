import java.util.Scanner;

public class Student {
    int stdRoll;
    int stdMarks;
    int stdAttendance;
    String stdName;
    Student(String stdName, int stdRoll, int stdMarks, int stdAttendance){
        this.stdAttendance=stdAttendance;
        this.stdMarks= stdMarks;
        this.stdRoll = stdRoll;
        this.stdName = stdName;

    }

    public int getStdRoll() {
        return stdRoll;
    }

    public void setStdRoll(int stdRoll) {
        this.stdRoll = stdRoll;
    }

    public int getStdMarks() {
        return stdMarks;
    }

    public void setStdMarks(int stdMarks) {
        this.stdMarks = stdMarks;
    }

    public int getStdAttendance() {
        return stdAttendance;
    }

    public void setStdAttendance(int stdAttendance) {
        this.stdAttendance = stdAttendance;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
    public boolean checkAttendance(int stdAttendance){
        if (stdAttendance>=75){
            return true;
        }else {
            return false;
        }
    }
    public boolean checkResult(int stdMarks,int stdAttendance){
        if (!checkAttendance(stdAttendance)){
           if (stdMarks >=50){
              // System.out.println();
               return true;
           }else {
               return false;
           }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the roll, attendance,marks and name of student respectively: ");
        Scanner s = new Scanner(System.in);
        int roll,attendance,marks;
        String name;
        roll = s.nextInt();
        attendance = s.nextInt();
        marks = s.nextInt();

        name = s.next();

        Student s1 = new Student(name,roll, marks,attendance);
        //s1.setStdName("sk");
        if (!s1.checkResult(marks,attendance)){
            System.out.println("Congratulations "+s1.getStdName()+" you are passed with " +s1.getStdMarks()+" marks." );
        }else {
            if (!s1.checkAttendance(s1.stdAttendance)){
                System.out.println("What the hell "+s1.getStdName()+" you are failed due to your irregular attendance." );

            }else {
                System.out.println("What the hell " + s1.getStdName() + " you are failed with " + s1.getStdMarks() + " marks.");
            }
        }
    }
}
