package CRYPTED_PROG;

import java.util.Scanner;

public class EncryptDecrypt {
    static StringBuffer encrypt(StringBuffer str,Character key){
        int getKeyVal = getKey(key);
        StringBuffer str2 = new StringBuffer("b");
        int i = str.length();

        int j=0;
        while (j<i){
            //char c = (char)((int)str.charAt(j) + key);
            str2.append((char)((int)str.charAt(j) + key));
        }
         return str2;
    }

    private static int getKey(Character key) {
        int keyVal = 26 - (90 - (int)key);
        return keyVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word to encrypt");
        StringBuffer inputString = new StringBuffer(sc.next());
        System.out.println("Enter the key ");
        char key = sc.next().charAt(0);
        System.out.println("OUTPUT STRING : ");
        System.out.println(encrypt(inputString,key));

        }

}
