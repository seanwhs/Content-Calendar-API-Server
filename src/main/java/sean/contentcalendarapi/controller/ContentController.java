package sean.contentcalendarapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import sean.contentcalendarapi.repository.ContentCollectionRepository;

@RestController
@CrossOrigin
@RequestMapping("api/v1/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
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
        if(!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        repository.save(content);
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        repository.delete(id);
    }
}

