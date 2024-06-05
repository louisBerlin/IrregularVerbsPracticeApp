package org.louis.backend.service;

import lombok.RequiredArgsConstructor;
import org.louis.backend.model.Progression;
import org.louis.backend.repository.ProgressionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProgressionService {

    private final ProgressionRepository progressionRepository;

    public void addProgression(String userId, long points) {
        Progression progression = getLastProgression(userId);
        if (progression == null ) {
            progressionRepository.save(new Progression(userId, points));
        }
        // if the last progression was made today
        else if(progression.getTimestamp().toLocalDate().equals(LocalDate.now())) {
            progression.setTotalPoints(progression.getTotalPoints() + points);
            progressionRepository.save(progression);
        }
        else {
            progressionRepository.save(new Progression(userId,progression.getTotalPoints() + points));
        }
    }


    public List<Progression> getProgressions(String userId) {
        System.out.println("userId "+userId+"findAllByUserId"+progressionRepository.findAllByUserId(userId));
        return progressionRepository.findAllByUserId(userId);
    }



    public Progression getLastProgression(String userId) {
     return progressionRepository.findTopByUserIdOrderByTimestampDesc(userId);
    }






}
