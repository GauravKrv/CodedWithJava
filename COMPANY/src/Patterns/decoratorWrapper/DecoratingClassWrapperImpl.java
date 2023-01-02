package Patterns.decoratorWrapper;

public class DecoratingClassWrapperImpl implements CommonInterfaceWrapper{

    ChildClassWrapperImpl childClassWrapper;

    public DecoratingClassWrapperImpl(ChildClassWrapperImpl childClassWrapper) {
        this.childClassWrapper = childClassWrapper;
    }

    @Override
    public void getWrapper() {
        childClassWrapper.getWrapper();
        System.out.println("Extra wrapping features");
    }

    @Override
    public int getNumbers() {
        return 10+childClassWrapper.getNumbers();
    }

    @Override
    public String getStrings() {
        return childClassWrapper.getStrings();
    }
}
