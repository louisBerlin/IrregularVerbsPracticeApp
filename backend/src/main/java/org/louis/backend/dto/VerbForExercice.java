package org.louis.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.louis.backend.model.Verb;

@Data
@AllArgsConstructor
public class VerbForExercice {

    private   String userId;
    private   String verbId;
    private   String infinitive;
    private   String table2;
    private   String table3;
    private int level;// 0 to 100
    private int nbOfGoodAnswers;
    private int nbOfBadAnswers;


    public  VerbForExercice(Verb verb, String userId) {
        this.userId = userId;
        this.verbId = verb.getId();
        this.infinitive = verb.getInfinitive();
        this.table2 = verb.getTable2();
        this.table3 = verb.getTable3();

        this.level = 1;
        this.nbOfGoodAnswers = 0;
        this.nbOfBadAnswers = 0;
    }





}
