public class IBM {

    static int solve(int n){
        //6 4 3
        String num = String.valueOf(n);
        int s = 0,e=num.length()-1;
        int sum = 0;
        while (s<e){
            int curr = Integer.parseInt(num.substring(s,s+1).concat(num.substring(e,e+1)));
            sum = sum + curr;
            s++;
            e--;
        }
        if (num.length()%2!=0){
            sum+=Integer.parseInt(num.substring(s,s+1));
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(solve(n));
    }

}
