public interface Int2 {
    void show();

   // void shows(int a,int b);
}

class User{
    public static void main(String[] args) {
        Int2 ref = () -> {
            System.out.println("hello");
        };

        ref.show();
    }
}
