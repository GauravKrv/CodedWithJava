public class ReachHeight {
    /*
You are given a strictly increasing integer array rungs that represents the height of rungs on a ladder. You are currently on the floor at height 0, and you want to reach the last rung.

You are also given an integer dist. You can only climb to the next highest rung if the distance between where you are currently at (the floor or on a rung) and the next rung is at most dist. You are able to insert rungs at any positive integer height if a rung is not already there.

Return the minimum number of rungs that must be added to the ladder in order for you to climb to the last rung.
    * */
    //Correct solutoin
    public int addRungsAccepted(int[] rungs, int dist) {
        int count = 0;
        int currdiff = rungs[0];
        for (int i=0;i<rungs.length;i++){
            if (currdiff>dist){
                if(currdiff%dist ==0){
                    count = count+(currdiff / dist) -1;
                }
                else{
                    count = count+(currdiff / dist);
                }

            }
            if (i+1<rungs.length) {
                currdiff = rungs[i + 1] - rungs[i];
            }
        }

        return count;
    }

    //TAKE AWAYS - TRY REDUCING WRONG APPROACH OF KNOWLEDGE FOR THE QUESTION
    //it is modified version solution of above question like - min count
    //i tried diff possiblities to get this solution which has redundant calculations but was fun
    //instead of using rugs use a block - if we insert a block in between then we have to adjust block so as...check
    static int reachHeight(int[] arr, int dist){
        int count = 0;
        int covered = dist;
        int currdiff = arr[0];
        for (int i=0;i<arr.length;i++){
            while (currdiff>dist){
                covered+=dist;
                currdiff -= dist;
                count++;
            }
            if (covered<arr[i]){
                arr[i] += dist - (arr[i] - covered);
                covered = arr[i];
            }
            else if(covered>dist){
                arr[i] = covered;
            }
            if (i+1<arr.length) {
                currdiff = arr[i + 1] - arr[i];
            }
        }

        return count;
    }
//wrong code in handling corner cases
    public static int addRungs(int[] rungs, int dist) {
        int count = 0;
        int currdiff = rungs[0];
        for (int i=0;i<rungs.length;i++){
            while (currdiff>dist){
                currdiff = currdiff - dist;
                count++;
            }

            if (i+1<rungs.length) {
                currdiff = rungs[i + 1] - rungs[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {

       // int arr[] = {2,6,7,9,13,17};
        int arr[] = {1,3,5,10};
        int dist = 2;;
        System.out.println(reachHeight(arr,dist));
        System.out.println(addRungs(arr,dist)); //OP = 2
    }
}
