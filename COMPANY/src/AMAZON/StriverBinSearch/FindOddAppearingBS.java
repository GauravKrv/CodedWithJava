package AMAZON.StriverBinSearch;

public class FindOddAppearingBS {
    public static void main(String[] args) {

        int ar[] = {1,1,2,3,3,4,4,8,8};
        int n = ar.length;
//        System.out.println("Element appearing single tim = "+findoddEle(ar,n));
        System.out.println("Element appearing single tim = "+findSingleElement(ar));

    }

//    /WORKS -- DIDNT CHECKED FOR OUT OF BOUNDS -- HWY??
    static int findSingleElement(int nums[]) {

        int low = 0;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1])

                    //Shrinking the right half
                    high = mid - 1;
                else
                    // Shrinking the left half
                    low = mid + 1;
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1;
                else
                    // Shrinking the left half
                    low = mid + 1;
            }
        }
        return nums[low];
    }

//    LOOK WHY FAILS
    private static int findoddEle(int[] ar, int n) {
        int  l = 0,h=n-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (mid+1<=h){
                if (ar[mid]!=ar[mid+1]){
                    h = mid;
                }else{
                    l = mid;
                }
            }
            if (mid-1>=l) {
                if (ar[mid]==ar[mid-1]){
                    h = mid;
                }else{
                    l = mid;

                }
            }

        }
        return -1;
    }
}
