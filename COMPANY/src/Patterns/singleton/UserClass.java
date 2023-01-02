package Patterns.singleton;

public class UserClass {
    public static void main(String[] args) {
        var instance1 = SingleInstancedClass.SINGLE_INSTANCED_CLASS;
        var instance2 = SingleInstancedClass.SINGLE_INSTANCED_CLASS;
        var ins1 = new UserClass();
        var ins2 = new UserClass();
        System.out.println(instance1.hashCode());//1480010240
        System.out.println(instance2.hashCode());//1480010240

        System.out.println(ins1.hashCode());//81628611
        System.out.println(ins2.hashCode());//1828972342

    }
}
