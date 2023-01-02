package Patterns.decoratorWrapper;

public class DecoratorMain {

    public static void main(String[] args) {
        System.out.println("Simple child class features");
        ChildClassWrapperImpl childClassWrapper = new ChildClassWrapperImpl();
        childClassWrapper.getWrapper();
        System.out.println(childClassWrapper.getNumbers());
        System.out.println(childClassWrapper.getStrings());

        System.out.println("\n\n Wrapped child class features");
        DecoratingClassWrapperImpl decoratingClassWrapper = new DecoratingClassWrapperImpl(childClassWrapper);
        decoratingClassWrapper.getWrapper();
        System.out.println(decoratingClassWrapper.getNumbers());
        System.out.println(decoratingClassWrapper.getStrings());
    }
}
