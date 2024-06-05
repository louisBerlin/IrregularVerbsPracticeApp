package org.louis.backend.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.AnswerUpdate;
import org.louis.backend.model.Answer;
import org.louis.backend.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void addAnswer(org.louis.backend.model.Answer answer) {
        answerRepository.save(answer);
    }

    public void addAllAnswer(List<Answer> answer) {
        answerRepository.saveAll(answer);
    }



    public void addAnswerUpdates(List<AnswerUpdate> answerUpdates) {
        for (AnswerUpdate answerUpdate : answerUpdates) {
            addAnswerUpdate(answerUpdate);
        }
    }
    public int calculatePoints(int nbOfBadAnswers) {
        if (nbOfBadAnswers == 0) {
            return 10;
        } else if (nbOfBadAnswers == 1) {
            return 5;
        } else if (nbOfBadAnswers == 2) {
            return 2;
        } else {
            return 0;
        }
    }

    public int calculateTotalPoints(List<AnswerUpdate> answerUpdates) {
        int totalPoints = 0;
        for (AnswerUpdate answerUpdate : answerUpdates) {
            totalPoints += calculatePoints(answerUpdate.getAddPoint());
        }
        return totalPoints;
    }
    public void addAnswerUpdate(AnswerUpdate answerUpdate) {
        Answer answer = answerRepository.findByUserIdAndVerbId(answerUpdate.getUserId(), answerUpdate.getVerbId());
        if (answer == null) {
            answer = new Answer(UUID.randomUUID().toString(), answerUpdate.getUserId(), answerUpdate.getVerbId(), 1,calculatePoints(answerUpdate.getAddPoint()) , answerUpdate.getNbOfGoodAnswers(), answerUpdate.getNbOfBadAnswers());
            answerRepository.save(answer);

        }
        else {
            if((answer.getLevelPoints() + calculatePoints(answerUpdate.getAddPoint()))>=100 && answer.getLevelRating()<5){
                answer.setLevelPoints(0);
                answer.setLevelRating(answer.getLevelRating()+1);
            } else if((answer.getLevelPoints() + calculatePoints(answerUpdate.getAddPoint()))<0 && answer.getLevelRating()>1){
                answer.setLevelPoints(100);
                answer.setLevelRating(answer.getLevelRating()-1);
            } else {
                answer.setLevelPoints(answer.getLevelPoints() + calculatePoints(answerUpdate.getAddPoint()));
            }
            answer.setNbOfGoodAnswers(answer.getNbOfGoodAnswers()+answerUpdate.getNbOfGoodAnswers());
            answer.setNbOfBadAnswers(answer.getNbOfBadAnswers()+answerUpdate.getNbOfBadAnswers());
            answerRepository.save(answer);
        }

    }




}
