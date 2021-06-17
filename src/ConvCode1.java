import java.util.Scanner;

public class ConvCode1 {
    //CCEF SEP 1ST QUES
    public static void main(String[] args) {
        int i,j,k,c=0,m;
         int x;
        int t;
        int n;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        for(i = 0;i<t;i++){
        n = s.nextInt();
        int[] b = new int[n];
        for(m=0;m<n;m++){
            b[m] = s.nextInt();
        }
            for(j = 0;j<n;j++){  //Array sort
                for(k = j+1;k<n;k++){
                    if(b[j]<=b[k]){
                        x = b[j];
                        b[j] = b[k];
                        b[k] = x;
                    }
                }
            }
            for(j=0;j<n;j++){
                if(b[j] == 0){
                    continue;
                }
                if(j+1 == n){
                    c++;
                    continue;
                }
                if(b[j]-b[j+1] == 0){
                    continue;
                }
                if(b[j]-b[j+1] != 0){
                    c++;
                    continue;
                }


            }
            System.out.println(c);
            c=0;
            m=0;

        }

        }
    }

