package com.co.sofka.backendzt.tourFrance.rider.mapper;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import com.co.sofka.backendzt.tourFrance.rider.dto.RiderDto;
import org.springframework.stereotype.Component;

/**
 * Rider mapper
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class RiderMapper {

    public RiderDto riderToRiderDto(Rider rider) {
        return new RiderDto(
                rider.getId(),
                rider.getFullName(),
                rider.getIdRider(),
                rider.getTeamCode(),
                rider.getCountry()
        );
    }

    public Rider riderDtoToRider(RiderDto riderDto) {
        return new Rider(
                riderDto.getId(),
                riderDto.getFullName(),
                riderDto.getIdRider(),
                riderDto.getTeamCode(),
                riderDto.getCountry()
        );
    }
}
