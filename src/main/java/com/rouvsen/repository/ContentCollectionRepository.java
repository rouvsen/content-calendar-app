package com.rouvsen.repository;

import com.rouvsen.model.Content;
import com.rouvsen.model.Status;
import com.rouvsen.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return this.contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().
                filter(c -> c.id().equals(id)).findFirst();
    }

    public Content save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
        return content;
    }

//    @PostConstruct
    private void init(){
        Content content = new Content(1,
                "First Title",
                "First Description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().
                filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
