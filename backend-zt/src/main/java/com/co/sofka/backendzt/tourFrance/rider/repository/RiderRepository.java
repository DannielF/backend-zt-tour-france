package com.co.sofka.backendzt.tourFrance.rider.repository;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rider reactive repository
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public interface RiderRepository extends ReactiveMongoRepository<Rider, String> {

    Flux<Rider> findAllByTeamCode(String teamCode);

    Flux<Rider> findAllByCountry(String country);

    Mono<Rider> findRiderByIdRider(String idRider);
}
