package io.frispace.elastic.dto.developer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author esuyorkulov.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private List<SkillDto> skills;
}
