package com.reactiveresttemplate.webclient.service;

import com.reactiveresttemplate.webclient.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Log4j2
public class PersonService {
    private final WebClient.Builder webClient;
    @Value("${base.url}")
    private String baseurl;

    public PersonService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public Flux<Person> getAllPerson() {
        return webClient.build().get()
                .uri(baseurl +"/person")
                .retrieve()
                .bodyToFlux(Person.class);
    }

    public Mono<Person> getById(Long id) {

       return webClient.build().get()
           .uri(baseurl+"/person/{id}",id)
           .retrieve()
           .bodyToMono(Person.class);
    }
    public Mono<Person> addPerson(Person person) {
        return webClient.build().post()
                .uri(baseurl+"/person")
                .body(Mono.just(person), Person.class)
                .retrieve()
                .bodyToMono(Person.class);
    }

//    public Mono<Person> updatePerson(Long id, Mono<Person> person) {
//
//        {
//            return webClient.build().put()
//                    .uri(baseurl+"person/{id}" + person.get)
//                    .body(Mono.just(person), Person.class)
//                    .retrieve()
//                    .bodyToMono(Person.class);
//        }
//    }
    public Mono<Void> deletePerson(Long id) {

        return webClient.build().delete()
                .uri(baseurl+"/person/{id}" ,id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
