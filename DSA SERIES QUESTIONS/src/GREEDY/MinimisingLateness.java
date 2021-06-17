package GREEDY;

import java.util.Scanner;

public class MinimisingLateness {

    static int[][] minimiseLateness(int[][] jobSeq, int numJobs){
        qSort(0,numJobs,jobSeq);//sort by deadline first

        int[][] schecJobs = new int[numJobs][4];
        int startTime = 0;
        int finishTime = jobSeq[0][1];
        int delayTime = jobSeq[0][0];


        for (int i=0;i<numJobs;i++){
            schecJobs[i][0] = startTime;//0->start time
            schecJobs[i][1] = finishTime;//1->finish time
            schecJobs[i][2] = jobSeq[i][2];//JOB Name or number
            schecJobs[i][3] = delayTime;//delayTime of the job Given
            startTime = finishTime ;//next startTime
            finishTime = startTime + jobSeq[i+1][1];//next FinishTime
            delayTime = jobSeq[i+1][0];
        }
        return schecJobs;

    }
    //static void (){


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numJobs = sc.nextInt();
        int[][] jobSeq = new int[numJobs+1][3];

        for (int i=0;i<numJobs;i++){
            jobSeq[i][1] = sc.nextInt();//1->timeToFinish
            jobSeq[i][0] = sc.nextInt();//0->deadline
            jobSeq[i][2] = i+1;//num of job
        }

        int[][] schecJobs = minimiseLateness(jobSeq,numJobs);//schedule the sorted jobs
        printSchedule(schecJobs,numJobs);


    }

    static void qSort(int l,int h,int arr[][]){
        int j;
        if (l<h){
            j = partition(l,h,arr);
            qSort(l,j,arr);
            qSort(j+1,h,arr);
        }
    }


    static int partition(int l,int h,int arr[][]){
        int pivot = arr[l][0];
        int i=l;
        int j = h;
        while (i < j) {
            do {
                i++;
            }while(i<j && arr[i][0]<=pivot);//if i will give larger elem than the pivot then loop will stop

            do {
                j--;
            } while(arr[j][0]>pivot);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }



    static void swap(int arr[][],int i,int j){

        int temp = arr[i][0]; //swap first rows or L's elem
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;

        int temp2 = arr[i][1];   //swap second rows or U's elem
        arr[i][1] = arr[j][1];
        arr[j][1] = temp2;

        int temp3 = arr[i][2];   //swap second rows or U's elem
        arr[i][2] = arr[j][2];
        arr[j][2] = temp3;

    }

    static void printSchedule(int[][] schedule,int numJob){
        System.out.println("Followoing is the sequenced jobs with minimised lateness");
        System.out.println("JOB NAME || START TIME || ENDTIME || DELAYTIME");
        for (int i=0;i<numJob;i++){
            System.out.println("\t"+schedule[i][2]+ "\t\t\t"+schedule[i][0]+ "\t\t\t"+schedule[i][1]+"\t\t\t"+schedule[i][3]);
        }
    }
}

