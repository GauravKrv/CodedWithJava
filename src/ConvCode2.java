import java.util.Scanner;

public class ConvCode2 {
    //CCEF SEP 3RD Q
    public static void main(String[] args) {
        int n,b=1,w=1,count=1,m,test;
        double t,i1=0,j1=0,vel;
        Scanner s  = new Scanner(System.in);
        test = s.nextInt();
        for(int x=0;x<test;x++){
//	printf("enter n value: ");
            n= s.nextInt();
            int[] a = new int[n];

            for(int i=0;i<n;i++){
                a[i] = s.nextInt();
            }
            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){
                    vel = a[j] - a[i];
                    if(i==j){
                        j1++;
                        continue;
                    }
                    if(a[j]==a[i]){
                        j1++;
                        continue;

                    }else{
                        t = (i1-j1)/vel ;
                        //	printf("case:,t=%lf, i1=%lf j1=%lf, i=%d j=%d , a[j]=%d , a[i]=%d,  vel = %lf \n",t,i1,j1,i,j,a[j],a[i],vel);
                        if(t>=0){


                            count++;
                        }else{
                            j1++;
                            continue;
                        }
                        j1++;
                    }
                }//---> for j loop
                j1=0;

                if(i==0){
                    b=count;
                    w=count;
                }else{
                    if(count<b){//check heree b cases
                        b=count;
                    }
                    if(count>w){//check heree w cases
                        w=count;
                    }
                }
                count = 1;
                i1++;
            }//-->
            System.out.println(b + " " + w);
            i1=0;j1=0;
            m=0;b=1;w=1;count = 1;
        }

    }
}
