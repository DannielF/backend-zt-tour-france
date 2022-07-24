package com.co.sofka.backendzt.tourFrance.config;

import com.mongodb.reactivestreams.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * Reactive mongo template
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
@AllArgsConstructor
public class ReactiveMongoConfig {

    private final MongoClient mongoClient;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, "tour_france");
    }
}
