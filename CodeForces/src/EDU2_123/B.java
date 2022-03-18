package EDU2_123;

import CodeForces.CodeForces;

public class B extends CodeForces {
//LEARNINGS: KNOW HOW AND WHEN TO USE TIME COMPLEXITIES
    //BACKUP
    static void swap(int[] a,int j,int i){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void solution(int n){
        int t=n-1,c = n-1;
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i+1;
        }
        for (int i = n-1; i >=0; i--) {
            System.out.print(ar[i]+" ");
        }
        System.out.println();
        while (t-->0){
            int j = n-1;
            swap(ar,c,c-1);
            while(j>=0){
                System.out.print(ar[j]+" ");
                j--;
            }
            swap(ar,c,c-1);
            c--;
            System.out.println();


        }
    }

    public static void main(String[] args) {
        int t=I();
        while (t-->0){
        int n = I();
        solution(n);

        }
    }
//lengthy and didnt worked --

    static void solution2(int n){
        int c;
        int l = n,t=n;
        boolean f = false;
//idea is to print 3 from last to first except where it should be i.e on 3rd position => gives n-1 sequences
        while (t-->0){
            c = 1;;
            for (int j = 1; j <=n; j++) {
                if (l==3&&f==true){
                    l--;//decrease l if l = 3 and dont print this sequence
                    break;
                }
                f = false;

                if (c==3){
                    c++;

                }
                if (c==l) {
                    System.out.print("3 ");
                    l--;
                }
                else{

                    System.out.print(c+" ");
                    c++;
                }

                if (j==n){
                    System.out.println();
                }

            }
            f = true;

        }
        //case only for n = 3
        if (n==3){
            System.out.print(3+" ");
            System.out.print(2+" ");
            System.out.print(1);
        }
        //case only for n = 4
        if (n==4){
            System.out.print(2+" ");
            System.out.print(4+" ");
            System.out.print(1+" ");
            System.out.print(3);
        }

        //printing the last or nth sequence if n != 3 or 4
        for (int i =1;(i<=n&&n!=3&&n!=4);i++){
            if (i==3){
                System.out.print(n+" ");
            }else  if (i==n){
                System.out.print(3);
                System.out.println();
            }else{
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    static void solution3(int n){
        int c;
        int l = n;
        boolean f = false;
//idea is to print 3 from last to first except where it should be i.e on 3rd position => gives n-1 sequences
        for (int i = 0; i < n; i++) {
            c = 1;

            int pre = 0;
            for (int j = 1; j <=n; j++) {
                if (l==3&&f==true){
                    l--;//decrease l if l = 3 and dont print this sequence
                    break;
                }
                f = false;
                if (l==c) {
                    System.out.print("3 ");
                    l--;
                    c++;
                }else if (c==3){
                    c++;

                    System.out.print(c+" ");


                }
                else{
                    System.out.print(c+" ");
                    c++;
                }

                if (j==n){
                    System.out.println();
                }

            }
            f = true;

        }
        //case only for n = 3
        if (n==3){
            System.out.print(3+" ");
            System.out.print(2+" ");
            System.out.print(1);
        }
        //case only for n = 4
        if (n==4){
            System.out.print(2+" ");
            System.out.print(4+" ");
            System.out.print(1+" ");
            System.out.print(3);
        }

        //printing the last or nth sequence if n != 3 or 4
        for (int i =1;(i<=n&&n!=3&&n!=4);i++){
            if (i==3){
                System.out.print(n+" ");
            }else  if (i==n){
                System.out.print(3);
                System.out.println();
            }else{
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}