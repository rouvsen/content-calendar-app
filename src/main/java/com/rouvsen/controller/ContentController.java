package com.rouvsen.controller;

import com.rouvsen.model.Content;
import com.rouvsen.model.Status;
import com.rouvsen.repository.ContentCollectionRepository;
import com.rouvsen.repository.ContentJdbcTemplateRepository;
import com.rouvsen.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;
//    private final ContentJdbcTemplateRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!")
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Content save(@Valid @RequestBody Content content){
        return repository.save(content);
    }

    //If you use update method like return type is Void
    //You can return HttpStatus.No_Content (ResponseBody is empty)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@Valid @RequestBody Content content,
            @PathVariable Integer id) {
        if (!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Content Not Found!"
            );
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }

}
