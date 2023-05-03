package com.rouvsen.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rouvsen.model.Content;
import com.rouvsen.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//you can write matches, negative matches, or list of matches
//@Profile("!dev")//dev (development-time) olmayan zaman ishlesin Bean
//@Profile({"dev", "production"}) //dev ve production zamani ishlesin

@Component //or you can use directly @Configuration
//because @Configuration contains @Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;//from Jackson

    public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
        this.repository = contentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json"))
        {
            /**
             repository.count() == 0 ifadesi,
             veri deposunda kaydedilmiş hiçbir öğe olmadığını kontrol eder.
             Eğer veri deposunda öğe yoksa,
             repository.saveAll() metodu çağrılır.
             */
            if (repository.count() == 0){
                repository.saveAll(
                        objectMapper.readValue(
                                inputStream,
                                new TypeReference<List<Content>>(){}
                        )
                );
            }
        }
    }
}

