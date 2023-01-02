package Patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherMain {

    private WeatherType currentWeather;
    private final List<WeatherObserver> observers;

    public WeatherMain() {
        currentWeather = WeatherType.SUNNY;
        observers = new ArrayList<>();
    }

    public void addObserver(WeatherObserver weatherObserver){
        observers.add(weatherObserver);
    }

    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    /**
     * Makes time pass for weather.
     */
    public void timePasses() {
        var enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.println("The weather changed to "+ currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        for (var obs : observers) {
            obs.update(currentWeather);

        }
    }


    public static void main(String[] args) {
        var weather = new WeatherMain();
        weather.addObserver(new ObserverOne());
        weather.addObserver(new ObserverTwo());
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }
}
