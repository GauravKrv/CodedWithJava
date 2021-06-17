public class MathsFun {
     int add(int a , int b){
        return a+b;
    }

    int negative(int a){
        return -1*a;
    }

    int subtract(int a , int b){
        return a-b;
    }
    int product(int a, int b){
        int sum = 0,i=1;
        while (i++<=b)  sum = add(sum,a);
        return sum;
    }
    int divide(int a,int b){
        int i=0;
        int temp = a;
        while (temp>=b && b!=0)  temp = subtract(temp,b);
        return i;
    }

    int mod(int a,int b){
        while (a>=b && b!=0)  a = subtract(a,b);
        return a;
    }

    int power(int a,int b){
         int temp = a;
        while (b-- >1) temp = product(temp,a);
        return temp;
     }

    int root(int a,int b){
        int temp = a;
        int i =0;
        while (temp>=b && b!=0){ temp =  divide(temp,b); i++;}
        return i;
    }

    boolean isPrime(int a){
        boolean flag = true;
        for (int i=2;i<divide(a,2);i++){
            if (mod(a,i) == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    int factorial(int a){
        int fact = a;
        while (a-->1) fact = product(fact,a);

        return fact;
    }

    String toStrings(int num){
         return String.valueOf(num);
    }

    public static void main(String[] args) {
         MathsFun mf = new MathsFun();
        System.out.println(mf.root(27,3));
        System.out.println(mf.isPrime(12));
    }



}
