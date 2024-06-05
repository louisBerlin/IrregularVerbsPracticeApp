package org.louis.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.louis.backend.model.Answer;
import org.louis.backend.model.Verb;

@Data
@AllArgsConstructor
public class VerbWithUserLevelRating {


    private   String userId;
    private   String verbId;
    private   String infinitive;
    private   String table2;
    private   String table3;
    private   String urlAudio;
    private int levelRating; // 1 to 5
    private int levelPoints;  // 0 to 100
    private int nbOfGoodAnswers;
    private int nbOfBadAnswers;

    public void setVerb(Verb verb) {
        this.verbId = verb.getId();
        this.infinitive = verb.getInfinitive();
        this.table2 = verb.getTable2();
        this.table3 = verb.getTable3();
        this.urlAudio = verb.getUrlAudio();
    }

    public void setAnswer(Answer answer) {
        this.levelRating = answer.getLevelRating();
        this.levelPoints = answer.getLevelPoints();
        this.nbOfGoodAnswers = answer.getNbOfGoodAnswers();
        this.nbOfBadAnswers = answer.getNbOfBadAnswers();
    }

}
