package snow.pass.job;

import java.util.concurrent.TimeUnit;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
// import snow.pass.model.Weather;
// import snow.pass.repository.WeatherRepository;


public class WeatherJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(MessageJob.class);

    // @Autowired
    // private MessageRepository messageRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        /* Get message id recorded by scheduler during scheduling */
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String messageId = dataMap.getString("messageId");

        log.info("Executing job for message id {}", messageId);




        // WeatherService weatherService = new WeatherService();

        // Iterable<Resort> resorts = resortRepository.findAll();
        // for (Resort resort : resorts) {

        //     WeatherData weatherData = weatherService.getWeather(resort.getLongitude(), resort.getLatitude());
        //     DailyWeather[] dailyWeather = weatherData.getData();
            
        //     for (DailyWeather w : dailyWeather) {
        //         Weather weather = new Weather(resort.getId(), w.getDatetime());   
        //         weather.setWeather_code(w.getWeather_code());
        //         weather.setTemp(w.getTemp());
        //         weather.setMin_temp(w.getMin_temp());
        //         weather.setHigh_temp(w.getHigh_temp());
        //         weather.setSnow(w.getSnow());
        //         weather.setSnow_depth(w.getSnow_depth());
        //         weather.setPop(w.getPop());
        //         weather.setWind_gust_spd(w.getWind_gust_spd());

        //         weatherRepository.save(weather);
        //     }
        //     try {
        //         TimeUnit.SECONDS.sleep(2);
        //     } catch (InterruptedException e) {
        //         System.err.format("IOException: %s%n", e);
        //     }

        try {
            context.getScheduler().deleteJob(new JobKey(messageId));

            TriggerKey triggerKey = new TriggerKey(messageId);

            context.getScheduler().unscheduleJob(triggerKey);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
