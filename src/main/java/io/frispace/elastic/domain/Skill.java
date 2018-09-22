package io.frispace.elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author esuyorkulov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "skills")

@Document(indexName = "skills", type = "skill")
public class Skill extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
}
