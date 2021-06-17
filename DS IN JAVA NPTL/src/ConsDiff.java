import java.util.Stack;

public class ConsDiff extends Stack {

    int age;
    int birthdate;
    int height;
    int weight;
    String title;
    String name;

   //we canot create constructers holdeing same data type of params with same sequence.

    ConsDiff(int age, String title, int weight){
        this.age = age;
        this.weight = weight;
        this.title = title;    }

    ConsDiff(int height,int birthdate,String name){
        this.height = height;
        this.birthdate = birthdate;
        this.name = name;
    }

    public static void main(String[] args) {
        Stack<Integer> roll = new Stack<>();
        roll.push(126);
        roll.push(127);
        roll.search(126);
        roll.add(1,131);
        System.out.println(roll.contains(125));
        System.out.println(roll.pop());
        System.out.println( roll.peek());


        roll.iterator().next();

    }
}
