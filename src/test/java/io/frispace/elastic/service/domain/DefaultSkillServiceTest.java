package io.frispace.elastic.service.domain;

import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.index.ElasticSkillRepository;
import io.frispace.elastic.repository.SkillRepository;
import io.frispace.elastic.service.domain.impl.DefaultSkillService;
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
public class DefaultSkillServiceTest {

    private SkillRepository skillRepository;
    private ElasticSkillRepository elasticSkillRepository;

    private SkillService skillService;

    @Before
    public void setUp() {
        skillRepository = mock(SkillRepository.class);
        elasticSkillRepository = mock(ElasticSkillRepository.class);
        skillService = new DefaultSkillService(skillRepository, elasticSkillRepository);
    }

    @Test
    public void add_nameUnitTesting_returnsExpectedSkillWithSameName() {
        //arrange
        Skill expected = new Skill();
        expected.setName("Unit testing");
        expected.setId(1L);

        when(skillRepository.save(any(Skill.class))).thenReturn(expected);

        //act
        Skill actual = skillService.add("Unit testing");

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void get_nameUnitTesting_returnsSkillWithSameName() {
        //arrange
        Skill expected = new Skill();
        expected.setName("Unit testing");
        expected.setId(1L);

        when(elasticSkillRepository.findByName("Unit testing")).thenReturn(expected);

        //act
        Skill actual = skillService.findSkill("Unit testing");

        //assert
        assertEquals(expected, actual);
    }
}
