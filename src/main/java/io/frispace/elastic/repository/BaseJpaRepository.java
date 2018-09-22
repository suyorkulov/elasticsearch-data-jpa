package io.frispace.elastic.repository;

import io.frispace.elastic.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author esuyorkulov.
 */
@NoRepositoryBean
interface BaseJpaRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
