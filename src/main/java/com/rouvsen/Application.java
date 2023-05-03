package com.rouvsen;

import com.rouvsen.config.ContentCalendarProperties;
import com.rouvsen.model.Content;
import com.rouvsen.model.Status;
import com.rouvsen.model.Type;
import com.rouvsen.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(value = ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context =
				SpringApplication.run(Application.class, args);
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//		RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
//		System.out.println(restTemplate);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository){
//		return args -> {
//			Content content = new Content(null,
//					"First Title - Chat Gpt",
//					"First Description - Chat Gpt",
//					Status.IDEA,
//					Type.ARTICLE,
//					LocalDateTime.now(),
//					null,
//					"");
//			repository.save(content);
//		};
//
//	}

}
