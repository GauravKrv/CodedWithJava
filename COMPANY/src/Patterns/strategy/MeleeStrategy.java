package Patterns.strategy;

public class MeleeStrategy implements DragonSlayingStrategy{
    @Override
    public void execute() {
        System.out.println("Cut dragons head with sword");
    }
}
