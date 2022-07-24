package com.co.sofka.backendzt.tourFrance.team.controller;

import com.co.sofka.backendzt.tourFrance.team.dto.TeamDto;
import com.co.sofka.backendzt.tourFrance.team.usecase.TeamUseCase;
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
 * Team Rest Controller
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(path = "/team")
@CrossOrigin(origins = "*")
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
    private final TeamUseCase teamUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<TeamDto> getAllTeams() {
        return teamUseCase.findAllTeam();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TeamDto> getTeamByIdTeam(@PathVariable("id") String idTeam) {
        return teamUseCase.findTeam(idTeam);
    }

    @GetMapping(path = "/country/{country}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TeamDto> getAllTeamByCountry(@PathVariable("country") String country) {
        return teamUseCase.findAllTeamByCountry(country);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        return teamUseCase.createTeam(teamDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<TeamDto> updateTeam(@RequestBody TeamDto teamDto) {
        return teamUseCase.updateTeam(teamDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTeam(@PathVariable("id") String id) {
        return teamUseCase.deleteTeam(id);
    }
}
