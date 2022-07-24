package com.co.sofka.backendzt.tourFrance.team.usecase.interf;

import com.co.sofka.backendzt.tourFrance.team.dto.TeamDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamUseCases {
    Mono<TeamDto> createTeam(TeamDto teamDto);

    Mono<TeamDto> updateTeam(TeamDto teamDto);

    Flux<TeamDto> findAllTeam();

    Mono<TeamDto> findTeam(String idTeam);

    Flux<TeamDto> findAllTeamByCountry(String country);

    Mono<Void> deleteTeam(String id);
}
