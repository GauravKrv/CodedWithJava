package STRINGS;

import java.util.Scanner;

public class ConvertToNumeric {
/*
Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

Note: You are not allowed to use inbuilt function.
* */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String str = sc.nextLine();


            System.out.println(atoiM3(str));
            t--;
        }
    }
   static int atoiM3(String str) {
       if(str.charAt(0)=='+'){
           return -1;
       }
       try
       {
           int kk = Integer.parseInt(str);
           return kk;
       }
       catch(Exception e)
       {
           return -1;
       }
    }


    int atoiM1(String str) {
        int k = 0;
        if(str.charAt(0)=='-'){
            k++;
        }

        for( int i=k; i < str.length(); i++) {
            Boolean flag = ((str.charAt(i))<48 || (str.charAt(i))>57)?false:true;
            if(flag==false){
                return -1;
            }

        }
        return Integer.parseInt(str);
    }


    int atoiUsingInbuiltM2(String str) {


        for(int i=0; i < str.length(); i++) {
            Boolean flag = Character.isDigit(str.charAt(i));
            if(flag==false){
                return -1;
            }

        }
        return Integer.parseInt(str);
    }
}

