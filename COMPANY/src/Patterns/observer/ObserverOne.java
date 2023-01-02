package Patterns.observer;

public class ObserverOne implements WeatherObserver{
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("\nUpdating weather for ObserverOne to : "+weatherType);
    }
}
