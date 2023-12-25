package sean.contentcalendarapi;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sean.contentcalendarapi.model.Content;
import sean.contentcalendarapi.model.Status;
import sean.contentcalendarapi.model.Type;
import sean.contentcalendarapi.repository.ContentRepository;

@SpringBootApplication
public class ContentCalendarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApiApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ContentRepository repository){
        return args -> {
			System.out.println("\n---Trying to insert from Command Line Runner---\n");
			Content content = new Content(
				null, 
				"Inserted From Command Line Runner", 
				"Testing Programmatic Data Insertion",
				Status.IDEA, 
				Type.ARTICLE, 
				LocalDateTime.now(), // Assuming you want the current date and time
				null, 
				"http://example.com", // Replace with the actual URL
				Set.of("tag1", "tag2") // Replace with the actual tags
			);
			repository.save(content);
    };
}
}