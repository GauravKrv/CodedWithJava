public class AnonymousObj {
    String s1;

    public String getS1() {
        return s1;
    }

    public void setS1() {
        s1 = "s1 is a string in default";
    }


    public static void main(String[] args) {  //Thus we can say that anonymous objects cannot refer to more than one functons
        AnonymousObj ao = new AnonymousObj();
        ao.setS1();
        System.out.println(ao.getS1());

        new AnonymousObj().setS1();
        System.out.println( new AnonymousObj().getS1());

    }
}
