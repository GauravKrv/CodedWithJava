package DIV_111_EDUROUND;

public class Q1 extends CodeForces {
    public static void main(String[] args) throws java.lang.Exception {


        int test = I();
        /*for (int t = 0; t < test; t++) {

            solve();
        }*/
        for (int t = 0; t < test; t++) {
            int n = I();
            int k = I();
            String s = S();
            out.println(mySolution(n,k,s));
        }
        out.close();
    }

   /* private static void solve() {
        int problems = sc.nextInt();
        int[] topics = new int[problems];
        int[] difficulties = new int[problems];
        for (int i = 0; i < problems; i++) {
            topics[i] = sc.nextInt() - 1;
            difficulties[i] = sc.nextInt() - 1;
        }
        int[] freqOfTasks = new int[problems];
        int[] freqOfDifficulties = new int[problems];
        for (int i = 0; i < problems; i++) {
            freqOfTasks[topics[i]]++;
            freqOfDifficulties[difficulties[i]]++;
        }
        long waysToSelect = (long) problems * (long) (problems - 1) * (long) (problems - 2);
        waysToSelect /= 6;
        for (int i = 0; i < problems; i++) {
            waysToSelect -= (long) (freqOfTasks[topics[i]] - 1) * (long) (freqOfDifficulties[difficulties[i]] - 1);
        }
        out.println(waysToSelect);
    }

    public static FastReader sc;
    public static PrintWriter out;*/

   /* static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }*/

    static int mySolution(int n,int k,String s){
        int[] arr = new int[k];

        int count = 0, slot=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='?'){
                arr[s.charAt(i)-97]++;
                count++;
                if (arr[s.charAt(i)-97]==1){
                    slot++;
                }
            }

        }

        count = n-count;
        slot = k - slot;

        if (slot>count) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (arr[j]==i && count>0) {
                    arr[j]++;
                    count--;
                }
                if (count==0) break;
            }
            if (count==0) break;
        }

        int min = arr[0];
        for (int i = 1; i < k; i++) {
            min = Math.min(min,arr[i]);
        }

        return min;

    }
}

/*
INPUT
5
10 3
abc????ab?
5 2
ab???
4 5
abcd
10 4
abbbcca???
2 2
a?
* */