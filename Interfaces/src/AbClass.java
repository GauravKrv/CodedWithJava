public abstract class AbClass implements Int2 {

    abstract void f1();

    public static void main(String[] args) {
        AbClass ab = new AbClass() {
            @Override
            void f1() {
                System.out.println("Helo");
            }

            @Override
            public void show() {

            }
        };
    }
}
