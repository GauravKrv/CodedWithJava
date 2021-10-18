package QUEUE;

public class CircularTour__ {
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.

    //GREATER THEN LINEAR COMPLEXITY
    static int tour(int p[], int d[])
    {
        // Your code here
        int n = p.length;

        int front = 0, rear = 0, currp=0;

        while(p[front]<d[front] && front<n){
            front++;
        }

        if(front == n){
            return -1;
        }

        rear = front;

        while(front!=n){
            if(currp<0){
                front++;
                if(front==n) return -1;
                rear = (front+1)%n;
                currp = p[front]-d[front];
            }

            if(currp>=0){
                currp += p[rear];
                currp -= d[rear];

            }
            if(currp>=0){
                rear = (rear+1)%n;
                if(rear==front) return front;
            }


        }
        return -1;
    }
}
