import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Try {
    void sort(int arr[])
    {
        boolean flag = true;
        int c = 1;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            if (flag == false )break;
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                if (c==5){
                    flag = false;
                    break;
                }
                arr[j + 1] = arr[j];
                j = j - 1;
                c++;

            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {28,35,12,15,27,11,9,14,8,32 };

        Try ob = new Try();
        ob.sort(arr);

        printArray(arr);
    }
}

class Try2  extends  Try{
    void test(){
        System.out.println("int try2");
    }

    public static int max(int[][] arr) {
        int dist = arr[0][1] - arr[0][0];
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[prev][1] > arr[i][0]) {
                dist += arr[i][1] - arr[prev][1];
            } else {
                dist += arr[i][1] - arr[i][0];
            }
            prev = i;
        }
        return dist;
    }

    static int distinct_year(String str) {
        String str2 = "";
        int size = 0;
        //Set<String> uniqueDates = new HashSet<>();
        int curr  = 0;
        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                curr++;
                str2 += (str.charAt(i));
            }

            else if (str.charAt(i) == '-') {
                curr++;
                str2 = "";
            }else{
                curr=0;
            }

            if (str2.length() == 4 && curr==10) {
                size++;
                str2 = "";
                curr=0;
            }
        }

        return size;
    }


    public static void main(String[] args) {
//        int l = 1;
//        int ls[][] = {{5,10}};
//        System.out.println(max(ls));
        System.out.println(distinct_year("UN was established on 24-10-1945.\n" +
                "                India got freedom on 10-08-1947"));
        }
    }

interface m1{
    void m1();
        }

        class h implements m1{

            @Override
            public void m1() {
                System.out.println("hy");
            }
        }

         class Init{
    static {
        System.out.println(1);
    }

    private Init() {
        System.out.println(2);
    }

             {
                 System.out.println(3);
             }

             public static void main(String[] args) {
                 new Init();
             }
        }


        class TestD{
    static int solve(String s){
        StringTokenizer st = new StringTokenizer(s,".");
        StringTokenizer st2 = new StringTokenizer(s);
        String regex = "^[0-3][0-9]-[0-3][0-9]-[0-9]{4}$";

        Pattern pattern = Pattern.compile(regex);
        int ans = 0;
        while (st.hasMoreTokens())
        {
            Matcher matcher = pattern.matcher(st.nextToken());
            if (matcher.matches()) {
                ans++;
            }
        }
        while (st2.hasMoreTokens())
        {
            Matcher matcher = pattern.matcher(st2.nextToken());
            if (matcher.matches()) {
                ans++;
            }
        }
        return ans;
    }
            public static void main(String[] args) {

                System.out.println(solve("UN was established on 24-10-1945.\n" +
                        "                India got freedom on 15-08-1947"));
            }
            }


            class Q{
                public static int max(int[][] arr) {
                    int dist = arr[0][1] - arr[0][0];
                    int prev = 0;
                    for (int i = 1; i < arr.length; i++) {
                        if (arr[prev][1] > arr[i][0]) {
                            dist += arr[i][1] - arr[prev][1];

                        } else {
                            dist += arr[i][1] - arr[i][0];
                        }
                        prev = i;
                    }
                    return dist;
                }

                public static void main(String[] args) {
                    int ls[][] = {{5,10},{5,9}};
                    System.out.println(max(ls));
                }
            }