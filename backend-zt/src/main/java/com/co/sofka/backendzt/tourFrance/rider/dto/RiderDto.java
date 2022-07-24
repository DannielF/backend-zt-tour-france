package com.co.sofka.backendzt.tourFrance.rider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Rider DTO
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RiderDto {
    private String id;
    @NotBlank
    private String fullName;
    @Size(max = 3)
    @NotBlank
    private String idRider;
    @NotBlank
    private String teamCode;
    @NotBlank
    private String country;
}
