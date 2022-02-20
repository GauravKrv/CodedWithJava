package DIV2_767;

import CodeForces.CodeForces;

public class B extends CodeForces {
//ACEPTED -- WOFFFF
//    --JUST FOUND A PATTERN AND EXECUTED IT
    //LEARNING - MINIMSE THE EXTRA FUNCTION COMPLEXITY EQUAL TO THE MAIN ALOS COMPPLEXITY
    static int countOdd(int l,int r){
        if (l%2==1 && (r%2==1 || r%2==0)){
         return (r-l)/2 +1;
        }


        if (l%2==0 && r%2==0){
            return (r-l)/2;
        }

        if (l%2==0 && r%2==1){
            return (r-l)/2+1;
        }
// 4 5 6 -1 r-l/2
        //5 6 7 8 9 r-l/2+1
        //5 6 7 8 r-l/2+1
        //4 5 6 7 - 2 r-l/2+1
        //4 5 6 7 -
        return (r-l)/2 +1;
    }

    static void solution(int l,int r,int k){
        if (l==r&&l==1){
            System.out.println("NO");
            return;
        }
        if (l==r&&l>1){
            System.out.println("YES");
            return;
        }
        int co = countOdd(l,r);
        if (co>k){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        int t = I();
        while (t-- > 0) {
            int l = I();
            int r = I();
            int k = I();
            solution(l,r,k);
        }
    }

        }

