package org.louis.backend.service;


import lombok.RequiredArgsConstructor;
import org.louis.backend.model.Verb;
import org.louis.backend.repository.VerbRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerbService {

    private final VerbRepository verbRepository;




    public List<Verb> getAllVerbs () {
        return verbRepository.findAll();
    }























    @GetMapping("/addverbs")
    public void addVerbs () {
        verbRepository.saveAll(List.of(
                new Verb("1", "buy",	    "bought",	"bought",   "","",""),
                new Verb("2", "come",	    "came",	    "come",     "","",""),
                new Verb("3", "do",	        "did",	    "done",     "","",""),
                new Verb("4", "drink",	    "drank",    	"drunk",    "","",""),
                new Verb("5", "eat",	    "ate",	    "eaten",    "","",""),
                new Verb("6", "fly",	    "flew",	    "flown",    "","",""),
                new Verb("7", "feel",	    "felt",	    "felt",     "","",""),
                new Verb("8", "find",	    "found",	    "found",    "","",""),
                new Verb("9", "have",	    "had",	    "had",      "","",""),
                new Verb("10", "keep",	    "kept",	    "kept",     "","",""),
                new Verb("11", "know",	    "knew",	    "known",    "","",""),
                new Verb("12", "leave",	    "left",	    "left",     "","",""),
                new Verb("13", "lose",	    "lost",	    "lost",     "","",""),
                new Verb("14", "make",	    "made",	    "made",     "","",""),
                new Verb("15", "meet",	    "met",	    "met",      "","",""),
                new Verb("16", "pay",	    "paid",	    "paid",     "","",""),
                new Verb("17", "read",	    "read",	    "read",     "","",""),
                new Verb("18", "run",	    "ran",	    "run",      "","",""),
                new Verb("19", "say",	    "said",	    "said",     "","",""),
                new Verb("20", "see",	    "saw",	    "seen",     "","","")
                ));
    }









}
