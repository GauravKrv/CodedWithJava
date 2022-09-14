package ENUMS;

public class EnumTry2 {
    String name;

    public EnumTry2(String name) {
        this.name = name;

    }

    public enum stage{
        OS("OS_STAGE"),
        RM("OS_STAGE");

        public final String label;
        private stage(String label) {
            this.label = label;
        }
    }
}

class TestEnum2{
    public static void main(String[] args) {
        EnumTry2 et2 = new EnumTry2("crn12");


    }
}
