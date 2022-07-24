package com.co.sofka.backendzt.tourFrance.rider.usecase.interf;

import com.co.sofka.backendzt.tourFrance.rider.dto.RiderDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RiderUseCases {
    Mono<RiderDto> createRider(RiderDto riderDto);

    Mono<RiderDto> updateRider(RiderDto riderDto);

    Flux<RiderDto> findAllRider();

    Mono<RiderDto> findRider(String idRider);

    Flux<RiderDto> findAllRiderByTeamCode(String teamCode);

    Flux<RiderDto> findAllRiderByCountry(String country);

    Mono<Void> deleteRider(String id);
}
