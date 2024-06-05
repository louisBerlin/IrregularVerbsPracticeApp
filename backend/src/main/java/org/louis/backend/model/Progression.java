package org.louis.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@Document
public class Progression {

    @Id
    private String id;
    private String userId;
    private long totalPoints;
    private LocalDateTime timestamp;

    public Progression(String userId, long totalPoints) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.totalPoints = totalPoints;
        this.timestamp = LocalDateTime.now();
    }

}
