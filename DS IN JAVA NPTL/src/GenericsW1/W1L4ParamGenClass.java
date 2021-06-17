package GenericsW1;

class W1L4ParamGenClass<T, V> {
    T x;
    V y;

    W1L4ParamGenClass(T a, V b) {  //a constructor
        x = a;
        y = b;
    }

    public T getTValue() {
        return x;
    }

    public V getVValue() {
        return y;
    }

    public void print() {  //a local method
        System.out.println(getTValue() + "," + getVValue());
    }
}

class MultiParamGenTest {  //driverclass using GC2
    public static void main(String[] args) {
W1L4ParamGenClass<String, String> a = new W1L4ParamGenClass<>("gaurav","verma");
a.print();
//works with any type of objects..

        W1L4ParamGenClass<String, Integer> b= new W1L4ParamGenClass<>("gaurav",25);
        b.print();
    }
}
