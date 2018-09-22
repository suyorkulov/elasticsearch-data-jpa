package io.frispace.elastic.dto.developer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author esuyorkulov.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDeveloperRequestDto {

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    @NotBlank
    @Size(max = 255)
    private String position;

    @NotNull
    private List<AddDeveloperSkillsRequestDto> skills;
}
