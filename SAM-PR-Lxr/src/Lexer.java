import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
   static ArrayList<String> input;
    public Lexer(ArrayList<String> input){
        this.input = input;
    }
    static int pointer = 0;

    static ArrayList<Token> tokenlist = new ArrayList<>();//stores the tokens

    static ArrayList<Token> tokenize(){
        var nexttoken = nextToken();//fetches next tokentype of the input file

        while (nexttoken.type != "endOfInput"){
            if (nexttoken.type!="space"){
                tokenlist.add(nexttoken);
            }

            nexttoken = nextToken();
        }

        return tokenlist;
    }

   static Token nextToken(){
        var tokenTypeTable = new TokenType();//creates an object for Tokentype class
        // which will allow using its tokentype table
        if (pointer==input.size()){
            return new Token("endOfInput","EndOfInput");

        }
        String temp = input.get(pointer);
        pointer++;

        //now we have a string and we have to check haracter by char that what valid tokens can be extracted from this string,

       //if teh string is a valid token
       if(tokenTypeTable.tokentype.containsKey(temp)){
           return new Token(temp,tokenTypeTable.tokentype.get(temp));//using table to return the corresponding token of the input
       }

       //if the string is not a valid token
       if(!tokenTypeTable.tokentype.containsKey(temp)){
           int start = 0, currEndIndex = 0, end = temp.length();
           while (currEndIndex<end){

               String currSubString = temp.substring(start,currEndIndex+1);
               boolean flag = false;
               if(tokenTypeTable.tokentype.containsKey(currSubString)){
                   flag = true;
                   tokenlist.add(new Token(currSubString,tokenTypeTable.tokentype.get(currSubString)));//using table to return the corresponding token of the input
               }
               else if(isDigit(currSubString)){
                   flag = true;
                   tokenlist.add( new Token("digit",tokenTypeTable.tokentype.get("digit")));
               }
               else if(isIdentifier(currSubString) && (currEndIndex==end-1 || tokenTypeTable.tokentype.containsKey(temp.substring(currEndIndex+1,currEndIndex+2)))){
                   flag = true;
                   tokenlist.add(  new Token("identifier",tokenTypeTable.tokentype.get("identifier")));
               }

               else if(isCharacter(currSubString)){
                   flag = true;
                   tokenlist.add(  new Token("charactervalue",tokenTypeTable.tokentype.get("charactervalue")));
               }
               else if(isString(currSubString)){
                   flag = true;
                   tokenlist.add(  new Token("stringvalue",tokenTypeTable.tokentype.get("stringvalue")));
               }
                 if (flag){
                   start = currEndIndex+1;
                 }
                 currEndIndex++;

           }

       }
        //space occured
       return new Token("space",tokenTypeTable.tokentype.get("space"));
    }

    static int currentIndent = 0;
    //adding all the tokens in the passed word
    static void checkTokens(String temp){
        int i = 0;
        var tokenTypeTable = new TokenType();
        for (i=0;i<temp.length();i++){
            if (tokenTypeTable.tokentype.containsKey(temp.substring(0,i+1))){

                tokenlist.add(new Token(temp.substring(0,i+1),tokenTypeTable.tokentype.get(temp.substring(0,i+1))));
                currentIndent = i;
            }
        }
        if (currentIndent!=temp.length()-1){
            tokenlist.add(new Token("unidentified",tokenTypeTable.tokentype.get("unidentified")));
            }
        currentIndent = 0;

    }
//check digits
    static boolean isDigit(String temp){
        String digitRegexPattern = "\\d+";
        Pattern p = Pattern.compile(digitRegexPattern);
        Matcher m = p.matcher(temp);

        return m.find();
    }

    //"\b [_a-zA-Z] [_a-zA-Z0-9]*\b"
//check identifiers :

    static boolean isIdentifier(String temp){
        var identifierRegexPattern =  "^([a-zA-Z_][a-zA-Z\\d_$]*)$";
        Pattern p = Pattern.compile(identifierRegexPattern);
        Matcher m = p.matcher(temp);

        return m.find();
    }
  //check characters :
    static boolean isCharacter(String temp){
        var characterRegexPattern =  "'[]\\[a-zA-Z0-9<>,.?/:;\"'{}|\\\\~`!@#$%^&*()_+=-]'";
        Pattern p = Pattern.compile(characterRegexPattern);
        Matcher m = p.matcher(temp);

        return m.find();
    }


    //check strings
    static boolean isString(String temp){
        var stringRegexPattern = "\"[]\\[\\sa-zA-Z0-9<>,.?/:;\"'{}|\\\\~`!@#$%^&*()_+=-]*\"";
        Pattern p = Pattern.compile(stringRegexPattern);
        Matcher m = p.matcher(temp);

        return m.find();
    }


    public static void main(String[] args)  throws FileNotFoundException
    {
        input = new ArrayList<>();
        File file = new File("D:\\JAVA\\CodeIt\\NOTHING_WILL_HAPPEN\\src\\inputcode2");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()){
            String s = sc.next();


            //if the input word is a string
            if (s.charAt(0)=='"' && (s.charAt(s.length()-1)!='"')){
                String temp = s;
                while (sc.hasNext() && s.charAt(s.length()-1) != '"'){
                    String s2 = sc.next();
                    temp = temp+s2;
                    s=s2;
                }
                input.add(temp);
            }
            //if the input word is a multi line comment
            else if (s.contains("/*") && (!s.endsWith("*/"))){
                String temp = "";
                if (!s.startsWith("/*")){ //if multiline comment starts within a word eg - print(jnks);/*kajdnad skdn*/
                    int i =0;
                    while (s.charAt(i)!='/' && s.charAt(i+1)!='*'){
                        temp = temp+s.charAt(i);
                        i++;
                    }
                    input.add(temp);
                }
            //modify for comment ending
                    while (sc.hasNext() && (!s.endsWith("*/"))) {
                        s = sc.next();
                    }

            }

            else if (s.contains("//")){
                String temp = "";
                if (!s.startsWith("//")){ //if single comment starts within a word eg - print(jnks);//kajdnad skdn
                    int i =0;
                    while (s.charAt(i)!='/' || s.charAt(i+1)!='/'){
                        temp = temp+s.charAt(i);
                        i++;
                    }
                    input.add(temp);
                }//after getting // move to next line
                s = sc.nextLine();
            }
            else {
                input.add(s);
            }
        }

        ArrayList<Token> tokens = tokenize();
        for (Token x : tokens){
            System.out.println( x.toString());

        }
    }
}
