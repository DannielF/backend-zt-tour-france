package com.co.sofka.backendzt.tourFrance.team.collection;

import com.co.sofka.backendzt.tourFrance.rider.collection.Rider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Team collection
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
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
