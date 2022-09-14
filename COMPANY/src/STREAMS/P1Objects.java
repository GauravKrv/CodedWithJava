package STREAMS;

import java.util.List;
import java.util.stream.Stream;

public class P1Objects {

    public static List<Student> createObjOfStudent(int n){
        Student s1 = new Student(11,11,"n11");
        Student s2 = new Student(11,11,"n111");
        Student s3 = new Student(111,11111,"n1111");
        Student s4 = new Student(111,1111,"n11111");
        Student s5 = new Student(1,1,"n1");

        List<Student> studentStream = List.of(s1,s2,s3,s4,s5);

        return studentStream;
    }

    public static void main(String[] args) {
        List<Student> list = createObjOfStudent(5);
        list.forEach(e -> System.out.print(e.getAge()+" " + e.getMarks() + " "+e.getName()+"\n"));
    }
}

class Student{
    private int age;
    private int marks;

    public Student(int age, int marks, String name) {
        this.age = age;
        this.marks = marks;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
