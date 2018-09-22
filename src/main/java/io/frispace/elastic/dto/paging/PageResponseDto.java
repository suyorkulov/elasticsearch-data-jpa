package io.frispace.elastic.dto.paging;

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
public class PageResponseDto {
    private Integer totalCount;
    private List content;
}
