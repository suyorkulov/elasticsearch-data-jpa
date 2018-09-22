package io.frispace.elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author esuyorkulov.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "developers")

@Document(indexName = "developers", type = "developer")
public class Developer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "position", nullable = false)
    private String position;

    @ManyToMany
    @JoinTable(
            name = "developers_skills",
            joinColumns = {@JoinColumn(name = "developer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "id")}
    )
    private List<Skill> skills = new ArrayList<>();
}
