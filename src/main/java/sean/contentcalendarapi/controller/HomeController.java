package sean.contentcalendarapi.controller;

import java.lang.module.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sean.contentcalendarapi.config.ContentCalendarProperties;

@ConfigurationProperties
@RestController
public class HomeController {

    private final ContentCalendarProperties properties;
   
    
    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }


    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }
}
