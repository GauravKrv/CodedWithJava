package Patterns.factory;

import java.util.function.Supplier;

public class CoinFactory {

    public static Coin getCoin(CoinType type) {
        return type.getConstructor().get();
    }

    public static Coin getNewCoin(CoinType type) {
        if (type==CoinType.COPPER){
            return new CopperCoin();
        }
        return new GoldCoin();
    }

    public static void main(String[] args) {
//given efficient
        System.out.println("The alchemist begins his work.");
        var coin1 = CoinFactory.getCoin(CoinType.COPPER);
        var coin2 = CoinFactory.getCoin(CoinType.GOLD);
        coin1.getDescription();
        coin2.getDescription();
//my easy
        var coin3 = getNewCoin(CoinType.COPPER);
        var coin4 = getNewCoin(CoinType.GOLD);
        coin3.getDescription();
        coin4.getDescription();

    }


}
