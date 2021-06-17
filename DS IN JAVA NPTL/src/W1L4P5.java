public class W1L4P5<T, S> {
    //Dec;aring two arrays which can store any type T, OR S of data
    T a[];//defing that the array a[] can store one type of data

    S b[];//defing that the array a[] can store another any similar type of data

    W1L4P5(T x[], S y[]){
    a = x;
    b = y;
    }
    T getDataT(int i){
        return a[i];
    }
    S getDataS(int i){
        return  b[i];
    }
    void printDataT(T t[]){
        for(int i=0;i<t.length;i++){
            System.out.println(getDataT(i) + " ");
        }
        System.out.println();
    }
    void printDataS(S s[]){
        for(int i=0;i<s.length;i++){
            System.out.println(getDataS(i) + " ");
        }
        System.out.println();
    }
    //reversing functions can also be defines
}
class W1L4P5Test{
    public static void main(String[] args) {
        String t[] = {"A","B","C"};
       // W1L4P4 arr = new W1L4P4("neha",2,3,4);
    W1L4P4 ar[] = new W1L4P4[3];
        ar[0] = new W1L4P4("gaurav",1,2,3);
        ar[1] = new W1L4P4("gaurav",1,2,3);
        ar[2] = new W1L4P4("gaurav",1,2,3);


/*

        s[0] = new W1L4P4("Gaurav ",11,12,13);
        s[1] = new W1L4P4("Gaurav ",11,12,13);
        s[2] = new W1L4P4("Gaurav ",11,12,13);
        s[3] = new W1L4P4("Gaurav ",11,12,13);
        s[4] = new W1L4P4("Gaurav ",11,12,13);*/

            W1L4P5<String,W1L4P4> arrData = new W1L4P5<String, W1L4P4>(t,ar);

       //DO BELOW ON YOUR OWN
        //arrData.printData(t);
        //arr.Data.reverseArray(t);
        //arrData.printData(ar);
        //arr.Data.reverseArray(ar);
        //arrData.printData(t);
        //arrData.printData(s);
    }
}
