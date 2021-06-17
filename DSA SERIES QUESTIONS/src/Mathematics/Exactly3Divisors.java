package Mathematics;

public class Exactly3Divisors {

    static  int exactly3Divisors(int N)
    {
        int[] arr = new int[N+1];
        for (int i =0;i<=N;i++)
            arr[i] = 0;
        if(N<4){return 0;}


        int count = 0;
        int div = 0;



        for(int i=2;i*i<=N;i++){

            if(arr[i]==0){
                int sq = i*i;


                arr[sq] = 1;
                System.out.print(sq+" ");
                count++;

                for (int j=sq;j+i<=N;j+=i){
                    arr[j+i] = arr[j] + 1;;
                }


            }

        }
        System.out.println();
        return count;


    }

    public static void main(String[] args) {
        System.out.println(exactly3Divisors(8111111));;
    }
}
