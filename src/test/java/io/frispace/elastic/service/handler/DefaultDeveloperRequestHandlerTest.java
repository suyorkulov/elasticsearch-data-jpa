package io.frispace.elastic.service.handler;

import io.frispace.elastic.domain.Developer;
import io.frispace.elastic.domain.Skill;
import io.frispace.elastic.domain.request.AddDeveloperRequest;
import io.frispace.elastic.domain.request.DeveloperSearchRequest;
import io.frispace.elastic.dto.developer.*;
import io.frispace.elastic.dto.paging.PageResponseDto;
import io.frispace.elastic.service.domain.DeveloperService;
import io.frispace.elastic.service.domain.SkillService;
import io.frispace.elastic.service.handler.impl.DefaultDeveloperRequestHandler;
import io.frispace.elastic.service.mapper.DeveloperMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author esuyorkulov.
 */
public class DefaultDeveloperRequestHandlerTest {

    private DeveloperService developerService;
    private SkillService skillService;
    private DeveloperMapper developerMapper;

    private DeveloperRequestHandler developerRequestHandler;

    @Before
    public void setUp() {
        developerService = mock(DeveloperService.class);
        skillService = mock(SkillService.class);
        developerMapper = mock(DeveloperMapper.class);

        developerRequestHandler = new DefaultDeveloperRequestHandler(developerService, skillService, developerMapper);
    }

    @Test
    public void add_withoutSkills_returnsExpectedDeveloperDto() {
        //arrange
        AddDeveloperRequestDto request = new AddDeveloperRequestDto();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setPosition("Java Developer");
        request.setSkills(emptyList());

        AddDeveloperRequest domainRequest = new AddDeveloperRequest();
        domainRequest.setFirstName("First");
        domainRequest.setLastName("Last");
        domainRequest.setPosition("Java Developer");
        domainRequest.setSkills(emptyList());

        Developer developer = new Developer();
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");

        DeveloperDto expected = new DeveloperDto();
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");
        expected.setSkills(emptyList());

        when(developerService.save(domainRequest)).thenReturn(developer);
        when(developerMapper.toDto(developer)).thenReturn(expected);

        //act
        DeveloperDto actual = developerRequestHandler.add(request);

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void add_withSkillsGivenSkillNotExist_returnsExpectedDeveloperDto() {
        //arrange
        AddDeveloperRequestDto request = new AddDeveloperRequestDto();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setPosition("Java Developer");
        request.setSkills(singletonList(new AddDeveloperSkillsRequestDto("Unit Testing")));

        Skill skill = new Skill("Unit Testing");
        skill.setId(1L);
        AddDeveloperRequest domainRequest = new AddDeveloperRequest();
        domainRequest.setFirstName("First");
        domainRequest.setLastName("Last");
        domainRequest.setPosition("Java Developer");
        domainRequest.setSkills(singletonList(skill));

        Developer developer = new Developer();
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");
        developer.setSkills(singletonList(skill));

        DeveloperDto expected = new DeveloperDto();
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");
        expected.setSkills(singletonList(new SkillDto(1L, "Unit Testing")));

        when(skillService.findSkill("Unit Testing")).thenReturn(null);
        when(skillService.add("Unit Testing")).thenReturn(skill);
        when(developerService.save(domainRequest)).thenReturn(developer);
        when(developerMapper.toDto(developer)).thenReturn(expected);

        //act
        DeveloperDto actual = developerRequestHandler.add(request);

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void add_withSkillsGivenSkillExist_returnsExpectedDeveloperDto() {
        //arrange
        AddDeveloperRequestDto request = new AddDeveloperRequestDto();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setPosition("Java Developer");
        request.setSkills(singletonList(new AddDeveloperSkillsRequestDto("Unit Testing")));

        Skill skill = new Skill("Unit Testing");
        skill.setId(1L);
        AddDeveloperRequest domainRequest = new AddDeveloperRequest();
        domainRequest.setFirstName("First");
        domainRequest.setLastName("Last");
        domainRequest.setPosition("Java Developer");
        domainRequest.setSkills(singletonList(skill));

        Developer developer = new Developer();
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");
        developer.setSkills(singletonList(skill));

        DeveloperDto expected = new DeveloperDto();
        expected.setFirstName("First");
        expected.setLastName("Last");
        expected.setPosition("Java Developer");
        expected.setSkills(singletonList(new SkillDto(1L, "Unit Testing")));

        when(skillService.findSkill("Unit Testing")).thenReturn(skill);
        when(developerService.save(domainRequest)).thenReturn(developer);
        when(developerMapper.toDto(developer)).thenReturn(expected);

        //act
        DeveloperDto actual = developerRequestHandler.add(request);

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void find_simpleSearchRequest_returnsPageResponseOfDevelopers() {
        //arrange
        DeveloperSearchRequestDto searchRequestDto = new DeveloperSearchRequestDto();
        DeveloperSearchRequest domainRequest = new DeveloperSearchRequest();
        Developer developer = new Developer();
        developer.setFirstName("First");
        developer.setLastName("Last");
        developer.setPosition("Java Developer");

        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setFirstName("First");
        developerDto.setLastName("Last");
        developerDto.setPosition("Java Developer");
        developerDto.setSkills(emptyList());
        PageResponseDto expected = new PageResponseDto(0, singletonList(developerDto));

        when(developerService.findAll(domainRequest)).thenReturn(new PageImpl<>(singletonList(developer)));
        when(developerMapper.toDto(developer)).thenReturn(developerDto);

        //act
        PageResponseDto actual = developerRequestHandler.findAll(searchRequestDto);

        //assert

        assertEquals(expected, actual);
    }
}