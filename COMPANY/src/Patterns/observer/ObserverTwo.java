package Patterns.observer;

public class ObserverTwo implements WeatherObserver{
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("\nUpdating weather for ObserverTwo to : "+weatherType);
    }
}
