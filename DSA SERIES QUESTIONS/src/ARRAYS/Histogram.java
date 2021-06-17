package ARRAYS;

public class Histogram {
    static int[] histogram(int[] survey){
         int hist[] = new int[survey.length];
         for (int i=0;i<survey.length;i++){
             hist[survey[i]]++;
         }

         return hist;
    }

    public static void main(String[] args) {
        int survey[] = {3,4,3,6,3,0,8,1,0,9};
        int res[] = histogram(survey);

        for (int i=0;i<survey.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}

