package AMAZON.STRINGS;
public class ValidateIpv4 {
    public static int countLeadingZeroes(String str)
    {
        // Count leading zeros
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;

        return i;
    }


    public static boolean isValid(String s) {
//first check for start and end dots and legth
        if (s.length()>15||(s.charAt(0)=='.'||s.charAt(s.length()-1)=='.')){
            return false;
        }
        String[] sub = s.split("[.]",0);
        //hen check for nunber of dot seperated terms
        if (sub.length<4||sub.length>4){
            return false;
        }

        boolean flag = true;
        for(String x:sub) {
            //check if current string is num er or not
            try {
                Integer.parseInt(x);
            } catch(NumberFormatException e) {
                return false;
            }
            if (x.length()==0){
                flag = false;
                break;
            }
            int leadingz = countLeadingZeroes(x);
            if (Integer.parseInt(x)<0||Integer.parseInt(x)>255 || (Integer.parseInt(x)==0&&x.length()!=1) || (Integer.parseInt(x)!=0&&leadingz>0)){
                flag = false;
                break;
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isValid("00.111.111.111"));
        System.out.println(isValid("0.0111.111.111"));
        System.out.println(isValid("00.01.111.111"));
        System.out.println(isValid("0.0.0.0."));
        System.out.println(isValid("1...1"));
        System.out.println(isValid("a.b.c.d"));

    }
}

// Java program to remove leading/preceding zeros
// from a given string


/* Name of the class to remove leading/preceding zeros */
class RemoveZero
{
    public static String removeZero(String str)
    {
        // Count leading zeros
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;

        // Convert str into StringBuffer as Strings
        // are immutable.
        StringBuffer sb = new StringBuffer(str);

        // The StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");

        return sb.toString(); // return in String
    }

    // Driver code
    public static void main (String[] args)
    {
        String str = "00000123569";
        str = removeZero(str);
        System.out.println(str);
    }
}
