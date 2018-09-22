package io.frispace.elastic.dto.developer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author esuyorkulov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDeveloperSkillsRequestDto {
    private String name;
}