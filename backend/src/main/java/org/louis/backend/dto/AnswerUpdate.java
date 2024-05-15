package org.louis.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerUpdate {
    private String userId;
    private String verbId;
    private int addPoint;
    private int nbOfGoodAnswers;
    private int nbOfBadAnswers;
}

