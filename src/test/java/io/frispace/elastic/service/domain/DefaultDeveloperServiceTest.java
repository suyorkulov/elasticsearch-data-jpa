package io.frispace.elastic.service.domain;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.request.AddDeveloperRequest;
import io.frispace.elastic.index.ElasticDeveloperRepository;
import io.frispace.elastic.repository.DeveloperRepository;
import io.frispace.elastic.service.domain.impl.DefaultDeveloperService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author esuyorkulov.
 */
public class DefaultDeveloperServiceTest {

    private DeveloperRepository developerRepository;
    private ElasticDeveloperRepository elasticDeveloperRepository;

    private DeveloperService developerService;

    @Before
    public void setUp(){
        developerRepository = mock(DeveloperRepository.class);
        elasticDeveloperRepository = mock(ElasticDeveloperRepository.class);
        developerService = new DefaultDeveloperService(developerRepository, elasticDeveloperRepository);
    }

    @Test
    public void add_simpleRequest_returnsExpectedDeveloper(){
        //arrange
        AddDeveloperRequest request = new AddDeveloperRequest();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setPosition("Java Developer");

        Developer expected = new Developer();
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");

        when(developerRepository.save(any(Developer.class))).thenReturn(expected);

        //act
        Developer actual = developerService.save(request);

        //assert
        assertEquals(expected, actual);
    }
}
