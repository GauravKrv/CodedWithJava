package Patterns.decoratorWrapper;

public class ChildClassWrapperImpl implements CommonInterfaceWrapper{
    @Override
    public void getWrapper() {
        System.out.println("Return ChildClassWrapperImpl String");
    }

    @Override
    public int getNumbers() {
        return 53;
    }

    @Override
    public String getStrings() {
        return "ChildClassWrapperImpl, ChildClassWrapperImpl, ChildClassWrapperImpl";
    }
}
