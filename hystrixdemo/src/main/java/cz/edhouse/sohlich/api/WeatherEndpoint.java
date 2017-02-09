package cz.edhouse.sohlich.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import cz.edhouse.sohlich.dto.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Radomir Sohlich on 2/6/17.
 */
@RestController
@RequestMapping("/api/weather")
public class WeatherEndpoint {

    Logger log = LoggerFactory.getLogger(WeatherEndpoint.class);

    private final Random r = new Random();

    @HystrixCommand(fallbackMethod = "fallBack",
            commandProperties = {})
    @GetMapping(path = "current")
    public WeatherData getWeather() {
        try {

            // Randomly throw exception
            if (r.nextInt(100) > 30)
                throw new RuntimeException("Cannot handle " +
                        "request");

            log.info("Executing true method");
            return new WeatherData("loc", "bla");
        } catch (Exception e) {
            log.error("Got exception ", e);
            throw e;
        }

    }


    public WeatherData fallBack() {
        WeatherData data = new WeatherData();
        log.info("Fallback executed");
        data.setLocation("Not available");
        data.setTemperature("Not available");
        return data;
    }
}
