package snow.pass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class PassApplication {
	// Dotenv dotenv = Dotenv.load();

	// private static final Logger log = LoggerFactory.getLogger(PassApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PassApplication.class, args);
	}

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder builder) {
	// 	return builder.build();
	// }

	// @Bean
	// public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	// 	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	// 	return args -> {
	// 		Weather weather = restTemplate.getForObject(
	// 				"https://api.weatherbit.io/v2.0/forecast/daily?&lat=47.746&lon=-121.089&key=" + dotenv.get("API_KEY"), Weather.class);
	// 		log.info(ow.writeValueAsString(weather));
	// 	};
	// }

}
