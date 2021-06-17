package STRINGS;

public class StringMatcher {
    static int count = 0;
    static void naiveStringMatcher(String T,String P){
        int n = T.length();
        int m = P.length();
        for (int s =0;s<n-m;s++){
            boolean flag = true;
           for (int i=0;i<m;i++){
                if (P.charAt(i)==T.charAt(s+i)) {
                    continue;
                }
                    else
                        flag = false;
            }
           if (flag) {
               System.out.println("Pattern Occurs with shift : " + s);
               count++;
           }
        }
    }

    public static void main(String[] args) {
       // String a = "awasawawbd";
        String a =
                "Ae ae ae ae yo..\n" +
                        "Every body say\n" +
                        "Ae ae ae ae yo..\n" +
                        "\n" +
                        "Kaali gaddi kaala sheeshe\n" +
                        "Kaala ainak paaya kaala\n" +
                        "Chandigarh tere karke aaya\n" +
                        "Nai te rehnda si Ambala\n" +
                        "Munda main Punjabi\n" +
                        "\n" +
                        "Kudiyan kehndi la la la la\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala Kaala kaala kaala\n" +
                        "\n" +
                        "Lakhan vich ek ae\n" +
                        "Mithi jehi ve cake ae\n" +
                        "Kudiyan di queen ae\n" +
                        "Baaki saari fake ae\n" +
                        "\n" +
                        "Main chori chori takda\n" +
                        "Sohna koka nakk da\n" +
                        "Karda ve tareefan\n" +
                        "Fan tere lakk da\n" +
                        "Tere layi ae chhadta burger ande wala\n" +
                        "\n" +
                        "Un dos tres\n" +
                        "\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "Kurta pajama kaala kaala kaala\n" +
                        "Kaala kaala kaala\n" +
                        "\n" +
                        "\n" +
                        "Read more at: http://www.lyricsbull.com/kurta-pajama-tony-kakkar/";
        String b = "urta pajama";
        naiveStringMatcher(a,b);
        System.out.println(count);


    }
}
