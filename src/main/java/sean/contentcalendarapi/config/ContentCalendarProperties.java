package sean.contentcalendarapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value="cc") //prefix is cc, eg cc.welcomeMessage, cc.about
public record ContentCalendarProperties(String welcomeMessage, String about) {}
