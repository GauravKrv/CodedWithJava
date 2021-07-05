package SEARCHING;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TwoRepeatedElements_ {

    //MY REPEATING APPROACH USING MODULO _ O(N)
    static class Pair
    {
        public int first;
        public int second;
    }

    //Function to find two repeated elements.
    public static Pair twoRepeated(int arr[], int N)
    {
        Pair p = new Pair();
        p.first = -1;
        p.second = -1;
        for(int i = 0;i<N+2;i++){
            arr[arr[i]%(N+2)] =  arr[arr[i]%(N+2)] + N+2;

            if(arr[arr[i]%(N+2)]/(N+2) > 1){
                if(p.first==-1){
                    p.first = arr[i]%(N+2);
                }
                else if(p.second==-1){
                    p.second = arr[i]%(N+2);

                }
            }
        }


        return p;
    }
        public static void main (String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                int n = Integer.parseInt(br.readLine());
                String l = br.readLine();
                String[] sarr = l.split(" ");
                int[] arr = new int[sarr.length];
                for(int i1=0;i1<arr.length;i1++){
                    arr[i1] = Integer.parseInt(sarr[i1]);
                }


                Pair res = twoRepeated(arr, n);
                System.out.println(res.first + " " + res.second);


            }
        }
    }// } Driver Code Ends


