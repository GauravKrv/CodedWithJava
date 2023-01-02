package Patterns.nullobject;

public class DemoClassNull implements DemoObjectInterface{
    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getSpecs() {
        return "null";
    }

    @Override
    public String toString() {
        return "DemoClassNull: "+getName()+", "+getSpecs()+", "+getAmount();
    }

    @Override
    public Double getAmount() {
        return -1.0;
    }
}
