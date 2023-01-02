package Patterns.factory;

public class CopperCoin implements Coin{
    @Override
    public void getDescription() {
        System.out.println("This is a cheap copper coin");
    }
}
