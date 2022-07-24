package com.co.sofka.backendzt.tourFrance.team.mapper;

import com.co.sofka.backendzt.tourFrance.team.collection.Team;
import com.co.sofka.backendzt.tourFrance.team.dto.TeamDto;
import org.springframework.stereotype.Component;

/**
 * Team Mapper
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class TeamMapper {

    public TeamDto teamToTeamDto(Team team) {
        return new TeamDto(
                team.getId(),
                team.getTeamName(),
                team.getIdTeam(),
                team.getCountry(),
                team.getRiders()
        );
    }

    public Team teamDtoToTeam(TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getTeamName(),
                teamDto.getIdTeam(),
                teamDto.getCountry(),
                teamDto.getRiders()
        );
    }
}
