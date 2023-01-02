package Patterns.strategy;

public class DragonSlayer {

    DragonSlayingStrategy dragonSlayingStrategy;

    public DragonSlayer(DragonSlayingStrategy dragonSlayingStrategy) {
        this.dragonSlayingStrategy = dragonSlayingStrategy;
    }

    void changeStrategy(DragonSlayingStrategy dragonSlayingStrategy){
        this.dragonSlayingStrategy = dragonSlayingStrategy;
        System.out.println();
    }

    void attack(){
        dragonSlayingStrategy.execute();
    }

    public static void main(String[] args) {
        DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
        //an object uses different algorithm to do a work at different time
        dragonSlayer.attack();
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.attack();
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.attack();
    }
}
