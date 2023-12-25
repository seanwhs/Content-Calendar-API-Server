package sean.contentcalendarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sean.contentcalendarapi.config.ContentCalendarProperties;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApiApplication.class, args);
	}


}