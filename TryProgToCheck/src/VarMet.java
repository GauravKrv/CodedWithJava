public class VarMet {
    //VVIP CONCEPT OF using for each
    static void Varargs(int...v){
        System.out.println("No of args: "+ v.length+"\n Elem are : ");
        for (int i : v){
            System.out.println(i+ " ");
        }
    }

    public static void main(String[] args) {
        int x[] ={1,37,4,5};
        int y[]= {1,2};
        Varargs(6,7,8);
        Varargs(y);
    }
}
