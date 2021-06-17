public class Q2 {
    public static void main(String[] args) {
/*MY SOLUTION:DIDNT WORKED:
int i,j,count,prev=0;
for(i=0;i<3;i++){
    count=prev;
    for(j=0;j<10;j++){
        count++;
        System.out.println(count);
    }
    prev=count;
    for(j=0;j<10;j++){
        System.out.println(count);
        count--;
    }
}*/
/*LONG LOOP METHOD::::::::::::::::::::::::::*/
int i,j,k,l,m,n;
for(i=1,j=10,k=11,l=20,m=21,n=30; i<=10;i++,j--,k++,l--,m++,n--){
    System.out.print(i + "  "+j+ "  "+k+ "  "+l+ "  "+m+ "  "+n);
    System.out.println();
        }
    }
}
