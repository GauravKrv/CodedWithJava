package Patterns.nullobject;

public class DemoClassNonNull implements DemoObjectInterface{

    String name;
    String specs;
    Double amount;

    public DemoClassNonNull(String name, String specs, Double amount) {
        this.name = name;
        this.specs = specs;
        this.amount = amount;
    }

    public DemoClassNonNull() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSpecs() {
        return this.specs;
    }

    @Override
    public Double getAmount() {
        return this.amount;
    }
}
