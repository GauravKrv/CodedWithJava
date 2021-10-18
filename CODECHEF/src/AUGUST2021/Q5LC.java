package AUGUST2021;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class Q5LC {

}

class Main {

    static void scheduleChargeTime(int[] A,int[] T,int n){
        int[][] schedul = new int[n][4];

        for (int i=0;i<n;i++){
            if(A[i]>T[i]){
                schedul[i][0] = A[i];
                schedul[i][1] = Integer.MIN_VALUE;
                schedul[i][2] = i+1;
            }else {
                schedul[i][0] = A[i];
                schedul[i][1] = T[i];
                schedul[i][2] = i + 1;
            }
        }

        printSlots(schedul,n);

        qSort(0,n,schedul);
        printSlots(schedul,n);
        int res[][] = new int[n][3];
        int curr = 0;
        for (int i=0;i<n;i++){
            if(schedul[i][0]<(schedul[i][1]-curr)){
                res[i][0] = schedul[i][2];
                res[i][1] = curr;
                curr+=curr+schedul[i][0];
                res[i][2] = curr;
            }
        }

        printSlots(res,n);
    }
/*
5
36 40 49 19 37
18 11 48 15 33

5
16 3 24 21 21
24 31 36 49 50

5
15 37 6 7 16
60 50 34 31 65

5
31 32 6 13 7
14 50 34 4 31
* */
    static void printSlots(int[][] B,int n){
       //  System.out.println("ID\tSTART TIME\t ENDTIME");
        for (int i=0;i<n;i++){
            System.out.println(B[i][2] + "\t"+B[i][1]+"\t"+B[i][0]);
        }
    }


    static void qSort(int l,int h,int arr[][]){
        int j;
        if (l<h){
            j = partition(l,h,arr);
            qSort(l,j,arr);
            qSort(j+1,h,arr);
        }
    }


    static int partition(int l,int h,int arr[][]){
        int pivot = arr[l][0];
        int i=l;
        int j = h;
        while (i < j) {
            do {
                i++;
            }while(i<j && arr[i][0]<=pivot);//if i will give larger elem than the pivot then loop will stop

            do {
                j--;
            } while(arr[j][0]>pivot);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }



    static void swap(int arr[][],int i,int j){

        int temp = arr[i][0]; //swap first rows or L's elem
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;

        int temp2 = arr[i][1];   //swap second rows or U's elem
        arr[i][1] = arr[j][1];
        arr[j][1] = temp2;

        int temp3 = arr[i][2];   //swap second rows or U's elem
        arr[i][2] = arr[j][2];
        arr[j][2] = temp3;

    }

    static Reader in = new Reader(System.in);

    public static void main(String[] args) throws IOException {

        //above this is fixed
        //Your Code goes here.

        int a = in.nextInt();
        int A[]  = in.nextIntArray(a);
        int T[] = in.nextIntArray(a);

        scheduleChargeTime(A,T,a);

        in.close();
    }

    static class Reader implements Closeable {

        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        private StringTokenizer getTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer;
        }

        public boolean hasNext() throws IOException {
            return getTokenizer() != null;
        }

        public String next() throws IOException {
            return hasNext() ? tokenizer.nextToken() : null;
        }

        public String nextLine() throws IOException {
            tokenizer = null;
            return reader.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String[] nextStringArray(int size) throws IOException {
            String[] array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = next();
            }
            return array;
        }

        public int[] nextIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int size) throws IOException {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextDouble();
            }
            return array;
        }

        @Override
        public void close() throws IOException {
            tokenizer = null;
            reader.close();
        }
    }



    //print array
    public static void print(int[] arr)
    {
        //for debugging only
        for(int x: arr)
            out.print(x+" ");
        out.println();
    }
    //check prime
    public static boolean isPrime(long n)
    {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    //gcd

    public static long gcd(long a, long b)
    {
        if(a > b)
            a = (a+b)-(b=a);
        if(a == 0L)
            return b;
        return gcd(b%a, a);
    }

    //get all divisors of n

    public static ArrayList<Integer> findDiv(int N)
    {
        //gens all divisors of N
        ArrayList<Integer> ls1 = new ArrayList<Integer>();
        ArrayList<Integer> ls2 = new ArrayList<Integer>();
        for(int i=1; i <= (int)(Math.sqrt(N)+0.00000001); i++)
            if(N%i == 0)
            {
                ls1.add(i);
                ls2.add(N/i);
            }
        Collections.reverse(ls2);
        for(int b: ls2)
            if(b != ls1.get(ls1.size()-1))
                ls1.add(b);
        return ls1;
    }

    //sorting array in faster way
    public static void sort(int[] arr)
    {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    //getting power
    public static long power(long x, long y, long p)
    {
        //0^0 = 1
        long res = 1L;
        x = x%p;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x)%p;
            y >>= 1;
            x = (x*x)%p;
        }
        return res;
    }

    //multiplyng a matrix
    public static long[][] multiply(long[][] left, long[][] right)
    {
        long MOD = 1000000007L;
        int N = left.length;
        int M = right[0].length;
        long[][] res = new long[N][M];
        for(int a=0; a < N; a++)
            for(int b=0; b < M; b++)
                for(int c=0; c < left[0].length; c++)
                {
                    res[a][b] += (left[a][c]*right[c][b])%MOD;
                    if(res[a][b] >= MOD)
                        res[a][b] -= MOD;
                }
        return res;
    }


    static class FastScanner
    {
        //I don't understand how this works lmao
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }




}


