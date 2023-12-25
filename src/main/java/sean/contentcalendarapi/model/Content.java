package sean.contentcalendarapi.model;

import java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;


public record Content(
    @Id
    Integer id,
    @NotBlank
    String title,
    String description,
    Status status,
    Type contentType,
    @FutureOrPresent
    LocalDateTime contentCreated,
    @FutureOrPresent
    LocalDateTime contentUpdated,
    @URL
    String url,
    Set<String> tags
) {

}
