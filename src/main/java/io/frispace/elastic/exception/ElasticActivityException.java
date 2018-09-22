package io.frispace.elastic.exception;

/**
 * @author esuyorkulov.
 */
public class ElasticActivityException extends RuntimeException {

    public ElasticActivityException() {
        super();
    }

    public ElasticActivityException(Class clazz) {
        super("Not found Elasticsearch repository for given entity : " + clazz.getName());
    }
}
