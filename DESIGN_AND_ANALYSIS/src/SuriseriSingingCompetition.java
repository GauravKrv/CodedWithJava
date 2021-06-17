import java.util.*;

public class SuriseriSingingCompetition {
    //Driver program
    public static void main(String[] args) {
        // System.out.println("Enter contestent's size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // System.out.println("Enter contestent's L's and U's for each");

        int arr[][] = new int[n][2];
        for(int i =0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
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
            if (hmap.containsKey(arr[i][0])){
                score  = ((n-i-1))*2;
                hmap.put(arr[i][0],score);
            }
        }
        Set<Integer> setScores = hmap.keySet();//Iterating on hashmap
        Iterator<Integer> iterator = setScores.iterator();
        while(iterator.hasNext()) {
            Integer code = iterator.next();
            Integer scores = hmap.get(code);
            System.out.print(scores+" ");
        }

    }


    //Sorting function

    static void qSort(int l,int h,int arr[][]){ //h = A.size,l = 0
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

    }

}

  /*

   System.out.println("Before sorting");
        for(int i =0;i<n;i++){
            System.out.println( arr[i][0] +" "+ arr[i][1]);
        }

         System.out.println("After sorting");

        for(int i =0;i<n;i++){
            System.out.println( arr[i][0] +" "+ arr[i][1]);
        }


    System.out.print("arr[l][0] = "+ arr[l][0]+",  arr[j][0] =  "+arr[j][0]);
       System.out.println(i+" ivalue ");
        System.out.println(j+" jvalue ");
// System.out.print(arr[l][0]+" "+arr[j][0]);
        //System.out.print("  -- ");

   // System.out.print(arr[l][0]+" "+arr[j][0]+" ,,, ");
       // System.out.println("count = "+count++ +",, ");


   int arr2[] = {22, 77, 101};

        int i=0,j=2;
        System.out.println(arr2[i]+" "+arr2[j]);
        swap2(arr2,i,j);
        System.out.println(arr2[i]+" "+arr2[j]);
*/
/*
    static void swap2(int arr[],int i,int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
*/


/*
   int temp = arr[i][0]; //swap first rows or L's elem
                arr[i][0] = arr[j][0];
                arr[j][0] = temp;

                temp = arr[i][1];   //swap second rows or U's elem
                arr[i][1] = arr[j][1];
                arr[j][1] = temp;

     int temp = arr[l][0]; //swap pivot to its place
        arr[l][0] = arr[j][0];
        arr[j][0] = temp;

        temp = arr[l][1];   //swap pivot to its place
        arr[l][1] = arr[j][1];
        arr[j][1] = temp;
7 8
6 9
5 10
4 11
3 12
2 13
1 14

* */
