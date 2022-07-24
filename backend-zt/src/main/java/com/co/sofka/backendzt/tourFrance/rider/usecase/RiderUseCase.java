package com.co.sofka.backendzt.tourFrance.rider.usecase;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import com.co.sofka.backendzt.tourFrance.rider.dto.RiderDto;
import com.co.sofka.backendzt.tourFrance.rider.mapper.RiderMapper;
import com.co.sofka.backendzt.tourFrance.rider.repository.RiderRepository;
import com.co.sofka.backendzt.tourFrance.rider.usecase.interf.RiderUseCases;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rider services/usecases
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class RiderUseCase implements RiderUseCases {

    private final RiderRepository repository;
    private final RiderMapper mapper;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<RiderDto> createRider(RiderDto riderDto) {

        return repository.save(mapper.riderDtoToRider(riderDto)).map(mapper::riderToRiderDto);
    }

    @Override
    public Mono<RiderDto> updateRider(RiderDto riderDto) {

        Query query = new Query().addCriteria(Criteria.where("_id").is(riderDto.getId()));
        Update update = new Update().set("fullName", riderDto.getFullName())
                .set("idRider", riderDto.getIdRider())
                .set("teamCode", riderDto.getTeamCode())
                .set("country", riderDto.getCountry());

        return reactiveMongoTemplate
                .findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Rider.class)
                .map(mapper::riderToRiderDto);
    }

    @Override
    public Flux<RiderDto> findAllRider() {
        return repository.findAll().map(mapper::riderToRiderDto);
    }

    @Override
    public Mono<RiderDto> findRider(String idRider) {

        return repository.findRiderByIdRider(idRider)
                .map(mapper::riderToRiderDto)
                .switchIfEmpty(Mono.error(new Throwable("There's not such rider")));
    }

    @Override
    public Flux<RiderDto> findAllRiderByTeamCode(String teamCode) {

        return repository.findAllByTeamCode(teamCode)
                .map(mapper::riderToRiderDto)
                .doOnError(throwable -> Mono.error(throwable.getCause()));
    }

    @Override
    public Flux<RiderDto> findAllRiderByCountry(String country) {

        return repository.findAllByCountry(country)
                .map(mapper::riderToRiderDto)
                .doOnError(throwable -> Mono.error(throwable.getCause()));
    }

    @Override
    public Mono<Void> deleteRider(String id) {

        return repository.deleteById(id)
                .doOnError(throwable -> Mono.error(throwable.getCause()));
    }
}
