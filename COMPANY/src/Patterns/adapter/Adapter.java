package Patterns.adapter;

import Patterns.state.TV;

public class Adapter implements MemoryCard {
    private final Laptop laptop;
    private final TV tv;

    public Adapter() {
        laptop = new Laptop();
        tv = new TV();
    }

    @Override
    public void makeLaptopCompatible() {
        laptop.acceptDataFromMemoryCard();
        tv.acceptDataFromMemoryCard();
    }
}
