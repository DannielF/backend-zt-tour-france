package com.co.sofka.backendzt.tourFrance.team.dto;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Team DTO
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private String id;
    @NotBlank
    private String teamName;
    @NotBlank
    @Size(max = 3)
    private String idTeam;
    @NotBlank
    private String country;
    @Size(max = 8)
    private List<Rider> riders;
}
