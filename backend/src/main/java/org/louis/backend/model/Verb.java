package org.louis.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("verb")
public class Verb {


    @Id
    private   String id;
    private   String infinitive;
    private   String table2;
    private   String table3;
    private   String urlAudio;
    private   String infinitiveDE;
    private   String infinitiveRU;

}
