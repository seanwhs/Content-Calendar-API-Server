package sean.contentcalendarapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import sean.contentcalendarapi.model.Content;
import sean.contentcalendarapi.model.Status;
import sean.contentcalendarapi.model.Type;
import sean.contentcalendarapi.repository.ContentRepository;

@RestController
@CrossOrigin
@RequestMapping("api/v1/content")
public class ContentController {
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }
    
    //find all content
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }
    
    @GetMapping("{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
        .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        repository.save(content);
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findByTitleContaining(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List <Content>findByStatusList(@PathVariable Status status){
        return repository.findByStatus(status);
    }

    @GetMapping("/filter/type/{type}")
    public List <Content>findByType(@PathVariable Type type){
        return repository.findByType(type);
    }
}

