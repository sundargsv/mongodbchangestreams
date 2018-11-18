package com.sundar.demo.mongochangestreams.api;

import com.sundar.demo.mongochangestreams.model.User;
import com.sundar.demo.mongochangestreams.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * @author Sundar Gsv
 * @Date 18/11/18
 * @ClassDescription
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserApi {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    //REST Controller
    @GetMapping(value = "/health")
    public Mono<String> health(){
        return Mono.just("UP");
    }

    //REST Controller
    @GetMapping
    public Flux<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> stream(){
        return Flux.interval(Duration.ofSeconds(1))
                .flatMap(tick -> {
                    return userRepository.findAll();
                });
    }

    @GetMapping(path = "/detectChanges", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ChangeStreamEvent<User>> detectChanges(){
        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .build();

        return reactiveMongoTemplate.changeStream("user", options, User.class)
                .log();

    }

}
