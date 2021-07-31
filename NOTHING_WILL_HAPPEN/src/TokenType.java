import java.util.ArrayList;
import java.util.HashMap;

public class TokenType {
    ArrayList<ArrayList<String>> keywords = new ArrayList<>();
   public HashMap<String,String> tokentype = new HashMap<>();
    String[] type = {
            //datatypes
            "int","float","double","char","string",

            //Symbols
            ".","#",


            //arith operators
            "+","-","*","/","%",

            //bitwise
            "|","&","^","~",">>","<<",

            //boolean
            "&&","!","||",

            //logical
            ">",">=","<","<=","==","!=","?",

            //assignment
            "=","+=","-=","*=","/=","%=","^=",

            //DELIMETERS
            "(",")","{","}","[","]",";",",",

            //keywords

            "class", "if", "else", "endOfInput", "public", "private",
            "protected", "return", "super", "this", "while", "do", "for", "true", "false",
            "cin","cout","endl","main","using","namespace","std",

            //digits
            "digit", "charactervalue", "stringvalue",
            //identifier
            "identifier",
            //unidentified
            "space", "unidentified",

            //MORE KEYWORDS
            "asm", "auto", "break", "case", "catch", "const", "continue",
            "default", "delete" , "enum", "extern" ,"friend", "goto","include", "long", "new",
            "operator", "register", "short", "signed", "sizeof", "static", "struct", "switch", "template",
            "this", "throw", "try", "typedef", "union", "unsigned", "virtual", "void", "volatile"
    };


    String[] value = {
            //datatypes
            "Int","Float","Double","Char","String",

            //symbols
            "Dot","Preprocessor",

            //arith operators
            "Plus","Minus","Times","Div","Modulo",

            //bitwise
            "BitwiseOR","BitwiseAND","Caret","Tilde","RightShift","LeftShift",

            //boolean
            "And","Not","Or",

            //logical
           "Greater", "GreaterOrEqual","Less","LessOrEqual","DoubleEqual","NotEqual","?",

            //assignment
            "Equal","PlusEqual","MinusEqual","TimesEqual","DivEqual","ModuloEqual","ExorEqual",

            //DELIMETERS
            "LeftParen","RightParen","LeftBrace","RightBrace","LeftBracket","RightBracket","Semicolon","Comma",

            //keywords
            "Class", "If", "Else", "EndOfInput", "Public",
            "Private", "Protected", "Return", "Super", "This",
            "While", "Do", "For", "TrueValue", "FalseValue",
            "CIN","COUT","ENDL","MAIN","Using","Namespace","STD",


            //DIGITS
            "Digit", "Charactervalue", "Stringvalue",
            //identifiers
            "IDENTIFIER",
            //unidentified
            "WhiteSpace", "UNIDENTIFIED",

            //MORE KEYWORDS
            "asm", "auto", "break", "case", "catch", "const", "continue",
            "default", "delete" , "enum", "extern" ,"friend", "goto","include", "long", "new",
            "operator", "register", "short", "signed", "sizeof", "static", "struct", "switch", "template",
            "this", "throw", "try", "typedef", "union", "unsigned", "virtual", "void", "volatile"

    };

    TokenType(){
        for (int i = 0; i< type.length; i++){
            tokentype.put(type[i],value[i].toUpperCase());
        }
    }
}
