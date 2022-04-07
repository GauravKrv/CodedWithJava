package STRINGS;

import java.math.BigInteger;

/*
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative.

Constraints:
1 ≤ length of s1 and s2 ≤ 10
* */
public class MultiplyStrings {
/*
BigInteger class is used for the mathematical operation which involves very big integer calculations that are outside the limit of all available primitive data types.
In this way, BigInteger class is very handy to use because of its large method library and it is also used a lot in competitive programming.
* */
    static void multiplyStrings(String s1,String s2){
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);

        BigInteger n3 = n1.multiply(n2);

        System.out.println(String.valueOf(n3));
    }

    public static void main(String[] args) {
        multiplyStrings("222222222222222222222222222","222222222222222222222222222222222222222");
    }
}
