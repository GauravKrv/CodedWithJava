package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  RegexDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true){
                System.out.println("Enter regex pattern : ");
                String regexPattern = sc.nextLine();
                Pattern p = Pattern.compile(regexPattern);

                Matcher m = p.matcher("123");

                boolean found = false;
                while (m.find()){
                    System.out.println("Found the text "+m.group() +
                            " starting at index " +
                            m.start() + " and ending at endex " +
                            m.end());
                    found = true;
                }

                if (!found){
                    System.out.println("Match not found");
                }else
                {
                    System.out.println("Match found");
                }
            }

        }
    }
}
