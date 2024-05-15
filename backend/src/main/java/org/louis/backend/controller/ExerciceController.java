package org.louis.backend.controller;


import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.AnswerUpdate;
import org.louis.backend.model.Answer;
import org.louis.backend.model.Verb;
import org.louis.backend.service.AnswerService;
import org.louis.backend.service.VerbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciceController {




    private final VerbService verbService;
    private final AnswerService answerService;
    private final org.louis.backend.service.DataService dataService;

    @GetMapping("api/addverbs")
    public String addVerbs () {
        verbService.addVerbs();
        return "ok ;-)";
    }



    @GetMapping("api/getverbs")
    public List<Verb> getVerbs () {
        return verbService.getAllVerbs();
    }


    @GetMapping("api/getverbswithuserrating")
    public List<org.louis.backend.dto.VerbWithUserLevelRating> getVerbsWithUserLevelRating (String userId) {
        return dataService.getVerbsWithUserLevelRating(userId);}


    @GetMapping("api/get10verbswithuserrating")
    public List<org.louis.backend.dto.VerbWithUserLevelRating> get10VerbsWithUserLevelRating (String userId) {
        return dataService.get10VerbsWithUserLevelRating(userId);
    }


    @GetMapping("api/get10verbsforexercice")
    public List<org.louis.backend.dto.VerbForExercice> get10verbsforexercice (String userId) {
        return dataService.get10VerbsForExercice(userId);
    }




    @PostMapping ("api/setanswer")
    public void setAnswer (@RequestBody List<Answer> answers) {
        answerService.addAllAnswer(answers);
    }


    @PostMapping ("api/setanswers")
    public void setAnswers (@RequestBody List<AnswerUpdate> answers) {
        answerService.addAnswerUpdates(answers);
    }




}
