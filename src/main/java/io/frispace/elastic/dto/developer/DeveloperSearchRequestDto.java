package io.frispace.elastic.dto.developer;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author esuyorkulov.
 */
@Data
public class DeveloperSearchRequestDto {

    private String text = "";
}
