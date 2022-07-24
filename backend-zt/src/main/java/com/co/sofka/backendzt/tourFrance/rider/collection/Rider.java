package com.co.sofka.backendzt.tourFrance.rider.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Rider collection
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rider {
    @Id
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
