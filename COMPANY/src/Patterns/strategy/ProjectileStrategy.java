package Patterns.strategy;

public class ProjectileStrategy implements DragonSlayingStrategy{
    @Override
    public void execute() {
        System.out.println("Hit the dragon with a crossbow");
    }
}
