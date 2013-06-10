package com.ninja_squad.tpmvc.api;

import com.google.common.collect.Lists;
import com.ninja_squad.iut.tpjpa.model.Spectacle;
import com.ninja_squad.iut.tpjpa.model.TypeDeSpectacle;
import com.ninja_squad.iut.tpjpa.service.SpectacleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class SpectacleApiControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private SpectacleService mockSpectacleService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void list() throws Exception {
        final List<Spectacle> spectacles = Lists.newArrayList(
                new Spectacle("titre du spectacle 1", "nom de l'artiste 1", TypeDeSpectacle.CONCERT),
                new Spectacle("titre du spectacle 2", "nom de l'artiste 2", TypeDeSpectacle.DANSE),
                new Spectacle("titre du spectacle 3", "nom de l'artiste 3", TypeDeSpectacle.HUMOUR)
        );

        Mockito.when(mockSpectacleService.findAll()).thenReturn(spectacles);

        mockMvc.perform(get("/api/spectacles/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void view() throws Exception {
        final Long id = -1L;
        final Spectacle spectacle = new Spectacle("titre du spectacle", "nom de l'artiste", TypeDeSpectacle.CONCERT);

        Mockito.when(mockSpectacleService.findById(Matchers.eq(id))).thenReturn(spectacle);

        mockMvc.perform(get("/api/spectacles/{id}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("titre").value("titre du spectacle"))
                .andExpect(jsonPath("artiste").value("nom de l'artiste"))
                .andExpect(jsonPath("type").value("CONCERT"));
    }

    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {

        @Bean
        public SpectacleApiController contactController() {
            return new SpectacleApiController();
        }

        @Bean
        public SpectacleService getMockSpectacleService() {
            return Mockito.mock(SpectacleService.class);
        }

    }

}
