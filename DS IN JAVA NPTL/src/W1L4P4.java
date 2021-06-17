public class W1L4P4 {
    String name;
    int marks1;
    int marks2;
    int marks3;
    int i=0;
   public W1L4P4(String s, int m1,int m2,int m3){
        name = s;

        marks1 = m1;
        marks2=m2;
        marks3=m3;
    }
    void printStudent(){
        System.out.println("Name "  + name);
        System.out.println("Scores = "+marks1+" " + marks2+" "+ marks3);
    }

}//End of class Mainlcy called STUDENT.
