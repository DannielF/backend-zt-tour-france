package com.co.sofka.backendzt.tourFrance.team.usecase;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import com.co.sofka.backendzt.tourFrance.rider.repository.RiderRepository;
import com.co.sofka.backendzt.tourFrance.team.collection.Team;
import com.co.sofka.backendzt.tourFrance.team.dto.TeamDto;
import com.co.sofka.backendzt.tourFrance.team.mapper.TeamMapper;
import com.co.sofka.backendzt.tourFrance.team.repository.TeamRepository;
import com.co.sofka.backendzt.tourFrance.team.usecase.interf.TeamUseCases;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Team services/usecases
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class TeamUseCase implements TeamUseCases {

    private final TeamRepository repository;
    private final RiderRepository riderRepository;
    private final TeamMapper mapper;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<TeamDto> createTeam(TeamDto teamDto) {

        return repository.save(mapper.teamDtoToTeam(teamDto)).map(mapper::teamToTeamDto);
    }

    @Override
    public Mono<TeamDto> updateTeam(TeamDto teamDto) {

        Query query = new Query().addCriteria(Criteria.where("_id").is(teamDto.getId()));
        Update update = new Update().set("teamName", teamDto.getTeamName())
                .set("idTeam", teamDto.getIdTeam())
                .set("country", teamDto.getCountry())
                .set("riders", teamDto.getRiders());
        return reactiveMongoTemplate
                .findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Team.class)
                .map(mapper::teamToTeamDto);
    }

    @Override
    public Flux<TeamDto> findAllTeam() {

        List<Rider> listRiders = new ArrayList<>();
        var riders = riderRepository.findAll();
        riders.collectList().subscribe(listRiders::addAll);

        return repository.findAll()
                .flatMap(team -> {
                    team.getRiders().addAll(
                            listRiders.stream().filter(
                                            rider -> rider.getTeamCode()
                                                    .equalsIgnoreCase(
                                                            team.getIdTeam()))
                                    .collect(Collectors.toList())
                    );
                    return Mono.just(team);
                })
                .map(mapper::teamToTeamDto);
    }

    @Override
    public Mono<TeamDto> findTeam(String idTeam) {

        List<Rider> listRiders = new ArrayList<>();
        var riders = riderRepository.findAllByTeamCode(idTeam);
        riders.collectList().subscribe(listRiders::addAll);

        return repository.findTeamByIdTeam(idTeam)
                .flatMap(team -> {
                    team.getRiders().addAll(listRiders);
                    return Mono.just(team);
                })
                .map(mapper::teamToTeamDto)
                .switchIfEmpty(Mono.error(new Throwable("There's not such team")));
    }

    @Override
    public Flux<TeamDto> findAllTeamByCountry(String country) {

        List<Rider> listRiders = new ArrayList<>();
        var riders = riderRepository.findAllByCountry(country);
        riders.collectList().subscribe(listRiders::addAll);

        return repository.findAllByCountry(country)
                .flatMap(team -> {
                    team.getRiders().addAll(
                            listRiders.stream().filter(
                                    rider -> rider.getTeamCode().equalsIgnoreCase(team.getIdTeam())
                            ).collect(Collectors.toList())
                    );
                    return Mono.just(team);
                })
                .map(mapper::teamToTeamDto)
                .doOnError(throwable -> Mono.error(throwable.getCause()));
    }

    @Override
    public Mono<Void> deleteTeam(String id) {

        return repository.deleteById(id).doOnError(throwable -> Mono.error(throwable.getCause()));
    }
}
