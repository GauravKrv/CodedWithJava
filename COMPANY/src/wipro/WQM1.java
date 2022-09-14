package wipro;

public class WQM1 {
    static String solve(String input1,String input2){
       int flag = 0;
        if (input1.charAt(1)>input1.charAt(0)){
            flag = isInc(input1);
        }else{
            flag = isDec(input1);
        }

        if (flag==0){
            return "invalid";
        }

        int count  = 0;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i)!=input2.charAt(i)){
                count++;

            }
        }
        if (flag==-1){
            return ("Decreasing:"+count);
        }
            return ("Increasing:"+count);
    }

    static int isInc(String s1){
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) < s1.charAt(i-1)){
                return 0;
            }
        }
        return 1;
    }
    static int isDec(String s1){
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) > s1.charAt(i-1)){
                return 0;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        solve("tbGB","tGBb");
    }
}

