package DP;
/*
Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example,
if the length of the rod is 8 and the values of different pieces are given as the following,
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
8
1, 5, 8, 9, 10, 17, 17, 20

O/p : 22
* */
//doesnt shows correct output - refractor
public class MaxCutRodValue {
    static int solution(int[] prices,int len,int sum,int j){
        if (len==0) return sum;
        if (j==1){ //IF j = 1 return len * p0 [i.e left
            return sum+(prices[0]*len);
        }
//exclude current length i.e dont cut rod of this size
        int nottake = solution(prices, len, sum, j-1);

        int take = -1;

//if include current cut length
   if ((len-j)>=0 ){
            take = solution(prices, len-j, sum+prices[j-1], j); //current cutting length can be repeated
        }
        return Math.max(take,nottake);
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(solution(price,8,0,8));
    }
}
