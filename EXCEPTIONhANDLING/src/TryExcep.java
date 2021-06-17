public class TryExcep {
    public static int div(int a , int b) throws Exception
    {
        System.out.println("Result = "+a/b);
        return a/b;
    }
    public static void main(String[] args) throws Exception {

        try {
            try {
                System.out.println(TryExcep.div(1, 0));
            } catch (Exception e) {

                System.out.println("Divede by 0");
            }
        }catch (Exception e){

            System.out.println("Again divide exception" + 1/0);
        }




    }
}
