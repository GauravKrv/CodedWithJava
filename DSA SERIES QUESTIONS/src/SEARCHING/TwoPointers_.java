package SEARCHING;

import ARRAYS.ArrayInput;

import java.util.HashMap;
//WORKS
public class TwoPointers_ {
    //Find the pair with the given sum
    static boolean isPair(int arr[],int n,int x){
        int l = 0;
        int h = n-1;
        while (l<h){
            if (arr[l]+arr[h]==x){
                return true;
            }else if (arr[l]+arr[h]>x){
                h--;
            }else {
                l++;
            }
        }

        return false;
    }

    static int countPairs(int arr[],int n,int x){
        int l = 0;
        int h = n-1;
        int count = 0;
        while (l<h){
            if (arr[l]+arr[h]==x){
               count++;
               l++;
            }else if (arr[l]+arr[h]>x){
                h--;
            }else {
                l++;
            }
        }

        return count;
    }

    static boolean isTriplet(int arr[],int n, int x){
        for (int i = 0;i<n;i++){
            if (isPair(arr,n,x-arr[i])) return true;
        }

        return false;
    }
    static int countTriplets(int arr[],int n, int x){
        int count = 0;
        HashMap<Integer,Boolean> chekOccurence = new HashMap<>(); //USING HASHMAP TO FLAG ELEMENTS SO THAT DUPLICATE TRIPLTETS DOESNT EXIST
        for (int i = 0;i<n;i++){
            chekOccurence.put(arr[i],false);
        }

        for (int i = 0;i<n;i++){

            int pair = x-arr[i];

            int l = 0;
            int h = n-1;
            while (l<h){ //THIS CONFIRMS THE UNIQUENESS OF THE TRIPLETS
                if (arr[l]+arr[h]==pair &&
                        arr[l]!=arr[i] && arr[h] != arr[i] &&
                        (!(chekOccurence.get(arr[l])&&(chekOccurence.get(arr[h])&&(chekOccurence.get(arr[i])))))){
                    chekOccurence.put(arr[l],true);
                    chekOccurence.put(arr[h],true);
                    chekOccurence.put(arr[i],true);
                    System.out.println("Triplet "+count+1+" = "+arr[l]+", "+arr[h]+", " +arr[i]);
                    count++;
                }else if (arr[l]+arr[h]>pair){
                    h--;
                }else {
                    l++;
                }
            }

            /*if (isPair(arr,n,x-arr[i])) {

                System.out.println("Triplet "+(i+1)+" = "+(x-arr[i])+", "+arr[i]);
                count++;
            }*/
        }
        return count;
    }

    static int countTriangles(int arr[],int n){
        int count = 0;
       for (int i = n-1;i>=0;i--){
             int l = 0;
            int h = i-1;
            while (l<h){
                if (arr[l]+arr[h] >arr[i]){
                    count = count + h-l;
                    h--;
                }else {
                    l++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayInput ar = new ArrayInput();

        int n = 7;
        int x = 9;
        int arr[] =  ar.createArray(n);//2 3 4 5 6 8 12

        if (isPair(arr,n,x)) {
            System.out.println("IsPair = Yes");
            System.out.println("Number of pairs = "+countPairs(arr,n,x));

        }
        if (isTriplet(arr,n,x)) {
            System.out.println("Istriplet = Yes");
            System.out.println("Number of triplets = "+countTriplets(arr,n,x));
            System.out.println("Count Triangles now  \n");
            System.out.println("Number of triangles = "+countTriangles(arr,n));


        }
    }
}
