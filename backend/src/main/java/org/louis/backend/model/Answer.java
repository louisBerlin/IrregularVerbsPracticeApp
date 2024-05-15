package org.louis.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("Answer")
public class Answer {
    @Id
    private String id;
    private String userId;
    private String verbId;
    private int levelRating; // 1 to 5
    private int levelPoints;  // 0 to 100
    private int nbOfGoodAnswers;
    private int nbOfBadAnswers;
}
