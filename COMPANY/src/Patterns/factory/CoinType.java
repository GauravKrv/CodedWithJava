package Patterns.factory;

import java.util.function.Supplier;

/*@RequiredArgsConstructor
@Getter*/
public enum CoinType {
    GOLD(GoldCoin::new),
    COPPER(CopperCoin::new);

    CoinType(Coin coin, Supplier<Coin> constructor) {

        this.constructor = constructor;
    }

    CoinType(Supplier<Coin> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Coin> getConstructor() {
        return constructor;
    }

    private final Supplier<Coin> constructor;

}
