package io.frispace.elastic.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author esuyorkulov.
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "io.frispace.elastic.repository")
@EnableElasticsearchRepositories(basePackages = "io.frispace.elastic.index")
public class ApplicationConfiguration {
}
