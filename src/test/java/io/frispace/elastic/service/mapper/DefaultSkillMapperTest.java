package io.frispace.elastic.service.mapper;

import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.dto.developer.SkillDto;
import io.frispace.elastic.service.mapper.impl.DefaultSkillMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author esuyorkulov.
 */
public class DefaultSkillMapperTest {

    private SkillMapper skillMapper;

    @Before
    public void setUp() {
        skillMapper = new DefaultSkillMapper();
    }

    @Test
    public void toDto_simpleSkill_returnsExpected() {
        //arrange
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("Unit Testing");

        SkillDto expected = new SkillDto();
        expected.setId(1L);
        expected.setName("Unit Testing");

        //act
        SkillDto actual = skillMapper.toDto(skill);

        //assert
        assertEquals(expected, actual);
    }
}
