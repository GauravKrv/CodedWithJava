package April;

/* package codechef; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
/*
Chef found a matrix A with N rows (numbered 1 through N) and M columns (numbered 1
through M), where for each row r and column c, the cell in row r and column c (denoted by
 (r,c)) contains an integer Ar,c.

This matrix has two interesting properties:

The integers in each row form a non-decreasing sequence, i.e. for each valid i,
Ai,1≤Ai,2≤…≤Ai,M.
The integers in each column also form a non-decreasing sequence, i.e. for each valid j, A1,j≤A2,j≤…≤AN,j.
A K-worthy submatrix is a square submatrix of A, i.e. a submatrix with l rows and l columns, for any integer l, such that the average of all the integers in this submatrix is ≥K.

Chef wants you to find the number of K-worthy submatrices of A.


MAIN THISMNGv :
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains three space-separated integers N, M and K.
N lines follow. For each valid i, the i-th of these lines contains M space-separated integers Ai,1,Ai,2,Ai,3,…,Ai,M.
Output
For each test case, print a single line containing one integer ― the number of K-worthy submatrices of A.



* */
class WorthyMatrix
{
    public static boolean isworthy(long matrix[][],int i,int j,int l,long k,long sum[][])
    {

        int p=i-l+1;
        int q=j;
        int r=i;
        int s=j+l-1;
        long total = sum[r][s];

        if (q - 1 >= 0) {
            total -= sum[r][q - 1];
        }

        if (p - 1 >= 0) {
            total -= sum[p - 1][s];
        }

        if (p - 1 >= 0 && q - 1 >= 0) {
            total += sum[p - 1][q - 1];
        }
	    /*
	    long sum=prefix[r][s];
	    //String mat="";
	    if(p-1>=0) sum-=prefix[p-l][s];
	    if(q-1>=0) sum-=prefix[r][q-1];
	    if(p-1>=0 && q-1>=0) sum+=prefix[p-1][q-1];
	    //System.out.println(mat);*/
        double avg=total/(l*l);
        //System.out.println(l+" "+sum+" "+avg+" "+(avg>=k));
        return avg>=k;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            long k=sc.nextLong();
            long worthy=0;
            long mat[][]=new long[n][m];
            //long prefix[][]=new long[n][m];
            long sum[][]=new long[n][m];
            for(int s=0;s<n;s++)
            {
                for(int p=0;p<m;p++)
                {
                    long a=sc.nextLong();
                    mat[s][p]=a;
                    //if(p==0) prefix[s][p]=a;
                    //else prefix[s][p]=a+prefix[s][p-1];
                    if(a>=k) worthy+=1;
                }
            }
            sum[0][0] = mat[0][0];

            for (int j = 1; j < mat[0].length; j++) {
                sum[0][j] = mat[0][j] + sum[0][j - 1];
            }

            for (int i = 1; i < mat.length; i++) {
                sum[i][0] = mat[i][0] + sum[i - 1][0];
            }

            for (int i = 1; i < mat.length; i++)
            {
                for (int j = 1; j < mat[0].length; j++)
                {
                    sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
                            - sum[i - 1][j - 1];
                }
            }
            for(int l=2;l<=n;l++)
            {
                int i=n-1;
                int j=0;
                while(i-l+1>=0 && j+l-1<m)
                {
                    if(isworthy(mat,i,j,l,k,sum))
                    {
                        worthy+=m-(j+l-1);
                        i-=1;
                        //System.out.println(worthy);
                    }
                    else
                    {
                        j+=1;
                    }
                }
            }
            System.out.println(worthy);
        }
    }
}
