package org.louis.backend.controller;


import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.AnswerUpdate;
import org.louis.backend.model.Answer;
import org.louis.backend.model.Verb;
import org.louis.backend.service.AnswerService;
import org.louis.backend.service.ProgressionService;
import org.louis.backend.service.SentenceService;
import org.louis.backend.service.VerbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciceController {



    final ProgressionService progressionService;
    private final VerbService verbService;
    private final AnswerService answerService;
    private final SentenceService sentenceService;
    private final org.louis.backend.service.DataService dataService;

    @GetMapping("api/addverbs")
    public String addVerbs () {
        verbService.addVerbs();
        sentenceService.addSentenses();
        return "ok ;-)";
    }




    @GetMapping("api/getverbs")
    public List<Verb> getVerbs () {
        return verbService.getAllVerbs();
    }




    @PostMapping("api/getverbswithuserrating")
    public List<org.louis.backend.dto.VerbWithUserLevelRating> getVerbsWithUserLevelRating (@RequestBody String username) {
        return dataService.getVerbsWithUserLevelRating(username.replace("=", ""));}



    /*
    @GetMapping("api/get10verbswithuserrating")
    public List<org.louis.backend.dto.VerbWithUserLevelRating> get10VerbsWithUserLevelRating (@RequestBody String userId) {
        return dataService.get10VerbsWithUserLevelRating(userId);
    }

     */


    @PostMapping("api/get5verbsforexercice")
    public List<org.louis.backend.dto.VerbForExercice> get5verbsforexercice (@RequestBody String username) {
        return dataService.get5VerbsForExercice(username.replace("=", ""));
    }






    @PostMapping ("api/setanswers")
    public void setAnswers (@RequestBody List<AnswerUpdate> answers) {
        progressionService.addProgression(answers.get(0).getUserId(), answerService.calculateTotalPoints(answers));
        answerService.addAnswerUpdates(answers);
    }




}
