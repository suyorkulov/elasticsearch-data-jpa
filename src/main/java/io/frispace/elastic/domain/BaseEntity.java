package io.frispace.elastic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.frispace.elastic.common.component.ElasticActivityListener;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author esuyorkulov.
 */
@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, ElasticActivityListener.class})
public abstract class BaseEntity implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date")
    private LocalDateTime createdDate = null;
}
