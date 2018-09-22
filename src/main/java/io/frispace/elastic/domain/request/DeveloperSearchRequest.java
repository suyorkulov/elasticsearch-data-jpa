package io.frispace.elastic.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author esuyorkulov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperSearchRequest {
    private String text;
}
