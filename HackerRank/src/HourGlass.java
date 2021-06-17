import java.util.Scanner;


public class HourGlass
{

    static int hourGlassElemSum(int arr[][]){
        int sum,i=0,j=0,maxSum=-360;

        for (i=0;i<4;i++){
            for (j=0;j<4;j++){
                sum = arr[i][j]+arr[i][j+1] + arr[i][j+2] +
                        arr[i+2][j]+arr[i+2][j+1] + arr[i+2][j+2]
                        + arr[i+1][j+1];
                if (sum>maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int arr[][] = new int[6][6];
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Max sum = "+hourGlassElemSum(arr));

    }

}


/*DONT KNOW WHATS IT===
int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
* */
