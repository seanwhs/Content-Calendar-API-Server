package sean.contentcalendarapi.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import sean.contentcalendarapi.model.Content;
import sean.contentcalendarapi.model.Status;
import sean.contentcalendarapi.model.Type;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }
    
    public boolean existById(Integer id){
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    public void init() {
        Set<String> contentTags = new HashSet<>(List.of(
            "coding", "full stack", "java", "javascript",
            "react", "spring boot", "web", "journal"
        ));

        Content content = new Content(
                1,
                "Blog Post on My Coding Journey",
                "Describes what I've learnt in the coding bootcamp",
                Status.PUBLISHED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "https://myblog.com",
                contentTags);

        contentList.add(content);

    }


}
