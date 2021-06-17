package HASHING;

public class TrivialHashing_1 {
    // Java program to implement direct index mapping with negative values allowed.
    public  static int Max = 20;//Max Size of the boolean array

  public   static boolean[][] has = new boolean[Max +1][2]; // Since array is global, it is initialized as 0.

    TrivialHashing_1(int Max,boolean has[][]){
        this.Max = Max;
        this.has = has;
    }

    public void insert(int arr[],int n){
        for (int i=0;i<n;i++){
            if (arr[i] >=0 ){
                has[arr[i]][0] = true;
            }
            else {
                has[Math.abs(arr[i])][1] = true;
            }
        }
    }

    public boolean search(int x){
        if (x>=0 &&  has[x][0]){
           return true;
        }
        if (x<0 && has[Math.abs(x)][1]){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int a[] = {-1, 9, -5, -8, -5, -2};
        int n = a.length;

        TrivialHashing_1 th = new TrivialHashing_1(20,has);

        th.insert(a,n);
       // insert(a, n);

        int x = -1;

        if (th.search(x) == true)
        {
            System.out.println("Present");
        }
        else
        {
            System.out.println("Not Present");
        }
     }
}

/*
*
Assign all the values of the hash matrix as 0.
Traverse the given array:
    If the element ele is non negative assign
        hash[ele][0] as 1.
    Else take the absolute value of ele and
         assign hash[ele][1] as 1.
To search any element x in the array.

If X is non-negative check if hash[X][0] is 1 or not. If hash[X][0] is one then the number is present else not present.
If X is negative take absolute value of X and then check if hash[X][1] is 1 or not. If hash[X][1] is one then the number is present*/
//TC Searching == O(1)

//Present