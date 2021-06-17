import java.util.*;

public class SuriseriSingingCompetition2 {
    //Driver program
    public static void main(String[] args) {
        // System.out.println("Enter contestent's size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // System.out.println("Enter contestent's L's and U's for each");
int count = 0;
        int arr[][] = new int[n][3];
        for(int i =0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = count++;
        }
        suriSeriScores(arr,n);
    }

    //Function to get scores
    static void suriSeriScores(int arr[][],int n){
        int score = 0;
        Hashtable<Integer,Integer> hmap = new Hashtable<>();
        for (int i =0;i<n;i++){
            hmap.put(arr[i][0],score);
        }
        qSort(0,n,arr);

        System.out.println("After sorting");

        for(int i =0;i<n;i++){
            System.out.println( arr[i][0] +" "+ arr[i][1]);
        }

        for (int i = 0;i<n;i++){
            for (int j=0;j<n;j++){
                if (arr[j][2] == i){
                    System.out.print(((n-j-1))*2 + " ");
                    break;
                }
            }
        }
        System.out.println();

       /*for (int i = 0;i<n;i++){
            if (hmap.containsKey(arr[i][0])){
                score  = ((n-i-1))*2;
                hmap.put(arr[i][0],score);
            }
        }
       */


       /*
        Set<Integer> setScores = hmap.keySet();//Iterating on hashmap
        Iterator<Integer> iterator = setScores.iterator();
        while(iterator.hasNext()) {
            Integer code = iterator.next();
            Integer scores = hmap.get(code);
            System.out.print(scores+" ");
        }*/

    }


    //Sorting function

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

}
