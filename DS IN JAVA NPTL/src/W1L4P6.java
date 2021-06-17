public class W1L4P6<T extends  Number> {
    //IMP.6
    T[] arr;
    W1L4P6(T[] t){
        arr = t;
    }
    double average (){
        double sum = 0.0;
        for(int i =0;i<arr.length;i++)
            sum += arr[i].doubleValue();//it will be compilation error
        // if we write prog without doubleVallue use becoz arr can store any
        //type of value and we need here only  diubke
                    return sum/arr.length;
    }
}
class W1L4P6Test{
    public static void main(String[] args) {
        Integer intArr[] = {1,2,3,4,5};
        W1L4P6<Integer> intData = new W1L4P6<>(intArr);
        double avgInt = intData.average();
        System.out.println(avgInt);//this works fine


       /* String strArr[] = {"1","2"};-->gives error becoz it is not the part of number class
       which our generic class extends/
        W1L4P6<String> stringData = new W1L4P6<>(intArr);
*/
    }
}
