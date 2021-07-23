import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lexer {

//if else if if (akjd) else (skj)
    public static Stack<String> tokenize(String input){
        input = input + "     ";
       int curr_indent = 0;

        Stack<String> indent_stack = new Stack<>();
        int i=0;
        //indent_stack.push("[");

        int n = input.length();
        while (i<n){
            System.out.println(input.charAt(i));
         if (input.charAt(i) == 'i' && input.charAt(i+1) == 'f'){ //substring function was not working correctly so i used it
                System.out.println("works");
                indent_stack.push(input.substring(i,i+2));
                curr_indent+=2;

                System.out.println("x");
            }
            else if(input.charAt(i) == 'e' && input.charAt(i+1) == 'l' && input.charAt(i) == 's' && input.charAt(i+1) == 'e'){

                indent_stack.push("else");
                curr_indent+= 4;
            }else if(input.substring(i)=="\0"){//white spaces are not taken into account here
                curr_indent+=1;
            }else{
                curr_indent++;
                indent_stack.push("INDENT NOT FOUND");
            }

            i = curr_indent;

            //indent_stack.push("]");

        }

        return indent_stack;



    }

    //NEVER USE "==" TO COMPARE A STRING
    //WORKS FOR IF ELSE WORDS

    public static Stack<String> tokenize2(String input){
        String[] input_stream = input.split("'\t'|'_'|'\n'|\\s|_+|o+" );// ifoifoelseoooif_else if else if

        Stack<String> indent_stack = new Stack<>();
        int i=0;

        System.out.println(Arrays.toString(input_stream));
        while (i< input_stream.length){
            if (input_stream[i].equals("if")){ //substring function was not working correctly so i used it
                System.out.println("works");
                indent_stack.push(input_stream[i]);
            }
            else if(input_stream[i].equals("else")){

                indent_stack.push("else");
            }else{
                indent_stack.push("INDENT NOT FOUND");
            }

            i++;
        }

        return indent_stack;



    }

   static void checkToken(){
        StringTokenizer str = new StringTokenizer("Hello world?? class{ " +
                "int i = 20;" +
                "int b = 22"
        +"if(i==b) print(true); " +
                "else print(false);" +
                "}");

        while (str.hasMoreTokens()){
            System.out.println(str.nextToken());
        }
    }

    public static void main(String[] args) {
        //tokenize("hello world>");
       /* Scanner sc = new Scanner(System.in);
        String input = "ifoifoelseoooif_else if else if";
        Stack<String> tokens = tokenize2(input);
        for (String x:tokens) {
            System.out.print("{"+x+"}"+", ");
        }*/

        checkToken();
    }
}

class TestFun{
    static void testFunc(){
        Stack<String> tokens = new Stack<>();
        String s = "if if if";
        System.out.println(s.substring(0,4));
        System.out.println("if".length());
        tokens.push(s.substring(0,2));
        System.out.println(tokens.pop());
    }



    public static void main(String[] args) {
        testFunc();
    }
}
