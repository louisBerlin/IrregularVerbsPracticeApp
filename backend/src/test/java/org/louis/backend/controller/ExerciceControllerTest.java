package org.louis.backend.controller;

import org.junit.jupiter.api.Test;
import org.louis.backend.model.Verb;
import org.louis.backend.repository.VerbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@SpringBootTest

@AutoConfigureMockMvc
class ExerciceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VerbRepository verbRepository;

    @Test
    void getVerbs() throws Exception {

        verbRepository.saveAll(List.of(new Verb("1", "be", "was", "been", "/verbsAudio/to_be.m4a", "", ""),
                new Verb("2", "beat", "beat", "beaten", "/verbsAudio/to_beat.m4a", "", "")
        ));

        mvc.perform(MockMvcRequestBuilders.get("/api/getverbs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                                        [
                                        {"id":"1","infinitive":"be","table2":"was","table3":"been","urlAudio":"/verbsAudio/to_be.m4a","infinitiveDE":"","infinitiveRU":""},
                                        {"id":"2","infinitive":"beat","table2":"beat","table3":"beaten","urlAudio":"/verbsAudio/to_beat.m4a","infinitiveDE":"","infinitiveRU":""}
                                        ]
                     """));

    }


    @Test
    void addVerbs() throws Exception {

      /*  List<Verb> verbs = List.of(new Verb("1", "be", "was", "been", "/verbsAudio/to_be.m4a", "", ""),
                new Verb("2", "beat", "beat", "beaten", "/verbsAudio/to_beat.m4a", "", "")
        );


        mvc.perform(MockMvcRequestBuilders.post("/api/addVerbs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(verbs.)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(verbs.toString()));

       */
    }

    @Test
    void testGetVerbs() {
    }

    @Test
    void getVerbsWithUserLevelRating() {
    }

    @Test
    void get5verbsforexercice() {
    }

    @Test
    void setAnswers() {
    }
}