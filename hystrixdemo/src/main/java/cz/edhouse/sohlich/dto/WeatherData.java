package cz.edhouse.sohlich.dto;

/**
 * Created by Radomir Sohlich on 2/6/17.
 */
public class WeatherData {
    private String location;
    private String temperature;
    private WeatherMain main;

    public WeatherData() {
    }

    public WeatherData(String location, String temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }
}
