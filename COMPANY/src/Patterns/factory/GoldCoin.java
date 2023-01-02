package Patterns.factory;

public class GoldCoin implements Coin{
    @Override
    public void getDescription() {
        System.out.println("This is an expensive gold coin");
    }
}
