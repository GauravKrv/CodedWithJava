public class CountActiveObj {
    public static int numOfObj;
    public int input1;
    public String input2;
    CountActiveObj(int input1,String input2){
        numOfObj++;
    }

    public static void main(String[] args) {
        CountActiveObj cAO = new CountActiveObj(1,"input1");
        CountActiveObj cAO2 = new CountActiveObj(2,"input2");
        CountActiveObj cAO3 = new CountActiveObj(3,"input3");
        System.out.println("Number of active objects = "+ numOfObj);
    }
}
