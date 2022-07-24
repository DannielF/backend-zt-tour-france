package com.co.sofka.backendzt.tourFrance.team.repository;

import com.co.sofka.backendzt.tourFrance.team.collection.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Team Reactive Repository
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

    Flux<Team> findAllByCountry(String country);

    Mono<Team> findTeamByIdTeam(String idTeam);
}
