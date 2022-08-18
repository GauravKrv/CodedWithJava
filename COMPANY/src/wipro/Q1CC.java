package wipro;

public class Q1CC {

    public int findKey(int input1,int input2,int input3){
        int c1 = 0,m1=Integer.MAX_VALUE,c2=0,m2=Integer.MAX_VALUE,c3=0,m3=Integer.MAX_VALUE;
        while (input1>0) {
            c1 = Math.max(c1, input1 % 10);
            m1 = Math.min(m1, input1 % 10);
            input1 = input1 / 10;

            c2 = Math.max(c2, input2 % 10);
            m2 = Math.min(m2, input2 % 10);
            input2 = input2 / 10;

            c3 = Math.max(c3,input3%10);
            m3 = Math.min(m3,input3%10);
            input3=input3/10;
        }
        return c1+c2+c3+m1+m2+m3;
    }

    public static void main(String[] args) {
        Q1CC q = new Q1CC();
        System.out.println(q.findKey(3521,2452,1352));
    }

    private int sumSmallest(int input1, int input2, int input3) {
        int c1 = 0,m1=0,c2=0,m2=0,c3=0,m3=0;
        while (input1>0) {
            c1 = Math.max(c1, input1 % 10);
            m1 = Math.min(m1, input1 % 10);
            input1 = input1 / 10;
        }
            while (input2>0) {
                c2 = Math.max(c2, input2 % 10);
                m2 = Math.min(m2, input2 % 10);
                input2 = input2 / 10;
            }

        while (input3>0) {
            c3 = Math.max(c3,input3%10);
            m3 = Math.min(m3,input3%10);
            input3=input3/10;
        }

       return 0;
    }

    private int sumLargest(int input1, int input2, int input3) {

return 1;
    }
}
