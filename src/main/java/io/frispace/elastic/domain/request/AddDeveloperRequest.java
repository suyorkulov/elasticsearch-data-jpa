package io.frispace.elastic.domain.request;

import io.frispace.elastic.domain.Skill;
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
public class AddDeveloperRequest {
    private String position;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
}
