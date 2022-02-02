package ARRAYS;

public class SmallestMissingNumber {
    static int missingNumber(int arr[], int n)
    {
        int max = 0;
        for(int i =0;i<n; i++){
            max = Integer.max(max,arr[i]);
        }
        if(max>0){
            boolean[] hash = new boolean[max+1]; //just a brute force thing as we are creating an array of max elemts size -- so that we can apply hashing
            for(int i =0;i<n; i++){
                if(arr[i]>=0){
                    hash[arr[i]] = true;
                }

            }
            //alternate -- if we just find the mAX ELEMENT THEN CAN WE JSUT MOD AND STORE?? -- NO
            for(int i =1;i<=max; i++){
                if(!hash[i])
                {
                    return i;
                }
                if(i==max){
                    return max+1;
                }

            }
            // Your code here
        }

        return 1;
    }

    public static void main(String[] args) {
        int A[] = {1,3,5,2,2};
        int num = missingNumber(A,5);
        System.out.println(num);
    }
}
