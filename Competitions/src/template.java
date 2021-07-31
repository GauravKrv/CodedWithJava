import java.io.*;
import java.util.*;

class Main {
    static Reader in = new Reader(System.in);
    
    public static void main(String[] args) throws IOException {
        // Your Code goes here.
        
        
        
        
        
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
}