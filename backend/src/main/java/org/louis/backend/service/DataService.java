package org.louis.backend.service;


import lombok.AllArgsConstructor;
import org.louis.backend.dto.VerbForExercice;
import org.louis.backend.dto.VerbWithUserLevelRating;
import org.louis.backend.model.Answer;
import org.louis.backend.model.Verb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataService {
    /*


    private final org.louis.backend.repository.VerbRepository verbRepository;
    private final org.louis.backend.repository.AnswerRepository answerRepository;



    public List<VerbWithUserLevelRating> getVerbsWithUserLevelRating(String userId) {

        List<Answer> answers = answerRepository.findByUserId(userId);
        List<org.louis.backend.model.Verb> verbs = verbRepository.findAll();

        // create a list of VerbWithUserLevelRating objects
        List<VerbWithUserLevelRating> verbsWithUserLevelRating = new ArrayList<>();
        for (Verb verb : verbs) {
            VerbWithUserLevelRating verbWithUserLevelRating = new VerbWithUserLevelRating(userId,"", "", "", "", 1, 0, 0,0);
            verbWithUserLevelRating.setVerb(verb);
            for (Answer answer : answers) {
                if (answer.getVerbId().equals(verb.getId())) {
                    verbWithUserLevelRating.setAnswer(answer);
                    break;
                }
            }
            verbsWithUserLevelRating.add(verbWithUserLevelRating);
        }
        return verbsWithUserLevelRating;
    }


    public List<VerbWithUserLevelRating> get10VerbsWithUserLevelRating(String userId) {

            List<Answer> answers = answerRepository.findByUserId(userId);
            List<org.louis.backend.model.Verb> verbs = verbRepository.findAll();

            // create a list of VerbWithUserLevelRating objects
            List<VerbWithUserLevelRating> verbsWithUserLevelRating = new ArrayList<>();
            for (Verb verb : verbs) {
                VerbWithUserLevelRating verbWithUserLevelRating = new VerbWithUserLevelRating("userId","", "", "", "", 1, 0, 0,0);
                verbWithUserLevelRating.setVerb(verb);
                for (Answer answer : answers) {
                    if (answer.getVerbId().equals(verb.getId())) {
                        verbWithUserLevelRating.setAnswer(answer);
                        break;
                    }
                }
                verbsWithUserLevelRating.add(verbWithUserLevelRating);
                if (verbsWithUserLevelRating.size() == 10) {
                    break;
                }
            }
            return verbsWithUserLevelRating;
    }




    public List<VerbForExercice> get10VerbsForExercice(String userId) {

            List<org.louis.backend.model.Verb> verbs = verbRepository.findAll();

            // create a list of VerbForExercice objects
            List<VerbForExercice> verbsForExercice = new ArrayList<>();
            for (Verb verb : verbs) {
                VerbForExercice verbForExercice = new VerbForExercice(verb, userId );

                verbsForExercice.add(verbForExercice);
                if (verbsForExercice.size() == 10) {
                    break;
                }
            }
            return verbsForExercice;
    }


     */
    }
