package org.anirudh.spring.helloobservability;

import io.micrometer.core.instrument.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {

    private Counter visitCounter;
    private Timer timer;
    private DistributionSummary httpRequestsDurationHistogram;

    private List<Integer> queue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));


    public TestController(MeterRegistry registry) {
        visitCounter = Counter.builder("visit_counter")
                .tags("counter-tag", "visitors")
                .description("No of Visits/Hits to the API")
                .register(registry);


        timer = Timer.builder("custom_time_recorder")
                .tags("timer-tag", "api-response")
                .description("Time Required for the API")
                .register(registry);

        Gauge.builder("queue-size", queue, queue -> queue.size())
                .register(registry);

        httpRequestsDurationHistogram = DistributionSummary.builder("http_request_histogram_example")
                .description("Histogram")
                .publishPercentileHistogram()
                .register(registry);

    }

    @GetMapping("/visitAPI")
    public String visitCounter(){
        visitCounter.increment();
        return "visitor-API Called: " + visitCounter.count();
    }

    @GetMapping("/getResponseTime")
    public String getResponseTime() throws InterruptedException {
        Timer.Sample sample = Timer.start();

        System.out.println("Mocking Some Random Work......");
        Thread.sleep(getRandomNumber(500, 1000));
        if(!queue.isEmpty()) {
            queue.remove(0);
        }

        double responseTimeInMilliSeconds = timer.record(() -> sample.stop(timer)/1000000);
        System.out.println("Response time in milli seconds: " + responseTimeInMilliSeconds + " ms");
        return "Response-Time Example API Called: " + responseTimeInMilliSeconds;
    }

    @GetMapping("/getQueueSize")
    public String gaugeExample() {
        int number = getRandomNumber(500, 2000);
        queue.add(number);
        return "Gauge Example API Called: " + queue.size();
    }

    @GetMapping("/histogram")
    public String histogramExample() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(getRandomNumber(10, 1000));
        long duration = System.currentTimeMillis() - startTime;

        httpRequestsDurationHistogram.record(duration);
        return "Histogram Example API Called: " + duration;
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
