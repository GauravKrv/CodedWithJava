package AMAZON.STRINGS;


import java.math.BigInteger;

/*
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative.

Constraints:
1 ≤ length of s1 and s2 ≤ 10
* */
public class MultiplyStrings___ {
    /*
    BigInteger class is used for the mathematical operation which involves very big integer calculations that are outside the limit of all available primitive data types.
    In this way, BigInteger class is very handy to use because of its large method library and it is also used a lot in competitive programming.
    * */
    static void multiplyStringsm1(String s1,String s2){
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);

        BigInteger n3 = n1.multiply(n2);

        System.out.println(String.valueOf(n3));
    }

    public static void main(String[] args) {
        multiplyStringsm1("222222222222222222222222222","222222222222222222222222222222222222222");
        System.out.println(multiplyStrings("222222222222222222222222222","222222222222222222222222222222222222222"));
    }

    public static String multiplyStrings(String s1,String s2)
    {
        int i_n1 = 0;
        int j_n2;
        String ans = "";
        boolean flag = true;
        int len1 = s1.length();
        int len2 = s2.length();
        if(s1.length() == 1 || s2.length() == 1){
            if(s1.charAt(0) == '0' || s2.charAt(0) == '0'){
                return "0";
            }
        }
        if(s2.charAt(0) == '-' && s1.charAt(0) == '-'){
            s1 = s1.substring(1,s1.length());
            s2 = s2.substring(1,s2.length());
            len1 = len1-1;
            len2 = len2-1;
            flag = true;
        }
        else if(s2.charAt(0) == '-'){
            s2 = s2.substring(1,s2.length());
            flag = false;
            len2 = len2-1;
        }
        else if(s1.charAt(0) == '-'){
            s1 = s1.substring(1,s1.length());
            flag = false;
            len1 = len1-1;
        }
        int arr[] = new int[len1+len2];
        for(int i=s1.length()-1;i>=0;i--){
            int n1 = s1.charAt(i)-'0';
            int carry = 0;
            j_n2 = 0;
            for(int j=s2.length()-1;j>=0;j--){
                int n2 = s2.charAt(j)-'0';
                int sum = n1*n2+arr[i_n1+j_n2]+carry;
                carry = sum/10;
                arr[i_n1+j_n2] = sum%10;
                j_n2++;
            }
            arr[i_n1+j_n2] = carry;
            i_n1++;
        }
        int i=arr.length-1;
        while(arr[i] == 0 && i>=0){
            i--;
            continue;
        }
        while(i>=0){
            ans += (char)(arr[i]+'0');
            i--;
        }
        return flag == true?ans:('-'+ans);
    }
}

