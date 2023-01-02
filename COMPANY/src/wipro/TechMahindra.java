package wipro;

import java.util.Arrays;

public class TechMahindra {

    public static void main(String[] args) {
        int itemid = 32387684;
        System.out.println(bucketID(itemid));
    }
    static int bucketID(int itemid){
        int max = 0;
        while (itemid>0){
            max = Math.max(max,itemid%10);
            itemid = itemid/10;
        }
        return max;
    }


}

class Q2TM{
    public static void main(String[] args) {
        int arr[] = {10,5,7,88,19};
        System.out.println(smallestStockPrice(arr,3));
    }

   public static int smallestStockPrice(int[] stock, int valuleK){
        Arrays.sort(stock);

        return stock[valuleK-1];
    }


}
