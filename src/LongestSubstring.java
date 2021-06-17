public class LongestSubstring {

    public static void main(String[] args) {
        int c=0;int res=0;
        String s = "wozaxjsdlsgefwn;eivnieee";
        int l =0;
        for(int i=0;i<s.length();i++){
            if (i!=s.length()-1) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    l++;
                }else {

                    if (res<l) {
                        res = l;

                    }
                    l=0;
                }
            }
        }
        System.out.println("the length of longest string is: "+res);
    }
}
