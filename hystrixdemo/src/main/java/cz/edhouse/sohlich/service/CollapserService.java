package cz.edhouse.sohlich.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import cz.edhouse.sohlich.dto.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * Created by Radomir Sohlich on 2/10/17.
 */
@Service
public class CollapserService {

    // timerDelayInMilliseconds is set only for testing purposes
    @HystrixCollapser(scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            batchMethod = "getWeatherByIds", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "2000")
    })
    public Future<WeatherData> getWeatherById(Integer id) {
        throw new RuntimeException("This method body should not be executed");
    }

    @HystrixCommand
    public List<WeatherData> getWeatherByIds(List<Integer> ids) {
        List<WeatherData> data = new ArrayList<>(ids.size());
        String message = "Batched calls with IDs " + Objects.toString(ids);
        for (Integer id : ids) {
            data.add(new WeatherData("Location: place" + id, message));
        }
        return data;
    }

}
