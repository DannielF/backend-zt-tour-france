package com.co.sofka.backendzt.tourFrance.rider.controller;

import com.co.sofka.backendzt.tourFrance.rider.dto.RiderDto;
import com.co.sofka.backendzt.tourFrance.rider.usecase.RiderUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rider Rest Controller
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(value = "/rider")
@CrossOrigin(origins = "*")
public class RiderController {

    private static final Logger logger = LoggerFactory.getLogger(RiderController.class);
    private final RiderUseCase riderUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<RiderDto> getAllRiders() {
        return riderUseCase.findAllRider();
    }

    @GetMapping(path = "/{idRider}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<RiderDto> getRiderByIdRider(@PathVariable("idRider") String idRider) {
        return riderUseCase.findRider(idRider);
    }

    @GetMapping(path = "/teamCode/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<RiderDto> getAllRiderByTeamCode(@PathVariable("id") String teamCode) {
        return riderUseCase.findAllRiderByTeamCode(teamCode);
    }

    @GetMapping(path = "/country/{country}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<RiderDto> getAllRiderByCountry(@PathVariable("country") String country) {
        return riderUseCase.findAllRiderByCountry(country);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RiderDto> createRider(@RequestBody RiderDto riderDto) {
        return riderUseCase.createRider(riderDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<RiderDto> updateRider(@RequestBody RiderDto riderDto) {
        return riderUseCase.updateRider(riderDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRider(@PathVariable("id") String id) {
        return riderUseCase.deleteRider(id);
    }
}
