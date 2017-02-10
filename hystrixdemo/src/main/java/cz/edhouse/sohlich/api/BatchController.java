package cz.edhouse.sohlich.api;

import cz.edhouse.sohlich.dto.WeatherData;
import cz.edhouse.sohlich.service.CollapserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by Radomir Sohlich on 2/6/17.
 */
@RestController
@RequestMapping("/api/batch")
public class BatchController {

    Logger log = LoggerFactory.getLogger(BatchController.class);

    private final Random r = new Random();

    @Autowired
    private CollapserService service;


    @GetMapping(path = "{id}")
    public WeatherData getWeatherEndpoint(@PathVariable("id") Integer id)
            throws
            ExecutionException,
            InterruptedException {
        try {
            log.info("Called batch with id {}", id);
            return service.getWeatherById(id).get();
        } catch (Exception e) {
            log.error("Got exception ", e);
            throw e;
        }
    }

}
