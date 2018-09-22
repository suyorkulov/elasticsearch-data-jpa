package io.frispace.elastic.service.mapper;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.dto.developer.DeveloperDto;
import io.frispace.elastic.dto.developer.SkillDto;
import io.frispace.elastic.service.mapper.impl.DefaultDeveloperMapper;
import io.frispace.elastic.service.mapper.impl.DefaultSkillMapper;
import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author esuyorkulov.
 */
public class DefaultDeveloperMapperServiceTest {

    private SkillMapper skillMapper;

    private DeveloperMapper developerMapper;

    @Before
    public void setUp() {
        skillMapper = mock(DefaultSkillMapper.class);
        developerMapper = new DefaultDeveloperMapper(skillMapper);
    }

    @Test
    public void toDto_developerWithoutSkills_returnsExpectedDto() {
        //arrange
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");

        DeveloperDto expected = new DeveloperDto();
        expected.setId(1L);
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");
        expected.setSkills(emptyList());

        //act
        DeveloperDto actual = developerMapper.toDto(developer);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void toDto_developerWithSkills_returnsExpectedDto() {
        //arrange
        Skill skill = new Skill();
        skill.setName("Unit Testing");
        skill.setId(1L);

        Developer developer = new Developer();
        developer.setId(1L);
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");
        developer.setSkills(singletonList(skill));

        SkillDto skillDto = new SkillDto();
        skillDto.setId(1L);
        skillDto.setName("Unit Testing");
        DeveloperDto expected = new DeveloperDto();
        expected.setId(1L);
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");
        expected.setSkills(singletonList(skillDto));

        when(skillMapper.toDto(skill)).thenReturn(skillDto);

        //act
        DeveloperDto actual = developerMapper.toDto(developer);

        //assert
        assertEquals(expected, actual);
    }
}
