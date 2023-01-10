package com.reactiveresttemplate.webclient.service;

import com.reactiveresttemplate.webclient.model.PatientRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Log4j2
@Service
public class PatientService {
    private final WebClient.Builder webClient;
    @Value("${base.url}")
    private String baseurl;

    public PatientService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }


//    public Mono<PatientResponse> addPatient(Mono<PatientRequest> patientRequest) {
//        return webClient.build().post()
//                .uri(baseurl+"/person")
//                .body(Mono.just(patientRequest), PatientRequest.class)
//                .retrieve()
//                .bodyToMono(Pa.class);
//    }

    public Flux<PatientRequest> getAllPatient() {
        return webClient.build().get()
                .uri(baseurl+"/patients")
                .retrieve()
                .bodyToFlux(PatientRequest.class);
    }

    public Mono<PatientRequest> getById(int patientId) {

        return webClient.build().get()
                .uri(baseurl+"/patients/{id}",patientId)
                .retrieve()
                .bodyToMono(PatientRequest.class);
    }



    public Mono<Void> deletePatient(int patientId) {

        return webClient.build().delete()
                .uri(baseurl+"/patients/{id}" ,patientId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}











