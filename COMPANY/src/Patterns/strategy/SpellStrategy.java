package Patterns.strategy;

public class SpellStrategy implements DragonSlayingStrategy{
    @Override
    public void execute() {
        System.out.println("Cast a spell and turn dragon to dust");
    }
}
