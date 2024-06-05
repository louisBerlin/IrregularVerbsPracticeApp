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























    public void addVerbs () {
        verbRepository.deleteAll();

        verbRepository.saveAll(List.of(
       //9          new Verb("1", "buy",	    "bought",	"bought",   "/verbsAudio/1to_buy.mp3","",""),
       //13         new Verb("2", "come",	    "came",	    "come",     "/verbsAudio/2to_come.mp3","",""),
        //17        new Verb("3", "do",	        "did",	    "done",     "/verbsAudio/3to_do.mp3","",""),
         //18       new Verb("4", "drink",	    "drank",    	"drunk",    "/verbsAudio/4to_drunk.mp3","",""),
       //20         new Verb("5", "eat",	    "ate",	    "eaten",    "/verbsAudio/5to_eat.mp3","",""),
       //24         new Verb("6", "fly",	    "flew",	    "flown",    "/verbsAudio/6to_fly.mp3","",""),
       //22         new Verb("7", "feel",	    "felt",	    "felt",     "/verbsAudio/7to_feel.mp3","",""),
       //23         new Verb("8", "find",	    "found",	    "found",    "/verbsAudio/8to_find.mp3","",""),
        //30        new Verb("9", "have",	    "had",	    "had",      "/verbsAudio/9to_have.mp3","",""),
        //34        new Verb("10", "keep",	    "kept",	    "kept",     "/verbsAudio/10to_keep.mp3","",""),

                new Verb("1", "be",        "was",	    "been",     "/verbsAudio/to_be.m4a","",""),
                new Verb("2", "beat",        "beat",	    "beaten",   "/verbsAudio/to_beat.m4a","",""),
                new Verb("3", "become",	"became",	"become",   "/verbsAudio/to_become.m4a","",""),
                new Verb("4", "begin",	    "began",	"begun",    "/verbsAudio/to_begin.m4a","",""),
                new Verb("5", "blow",	    "blew",	    "blown",    "/verbsAudio/to_blow.m4a","",""),
                new Verb("6", "break",	    "broke",	"broken",   "/verbsAudio/to_break.m4a","",""),
                new Verb("7", "bring",	    "brought",	"brought",  "/verbsAudio/to_bring.m4a","",""),
                new Verb("8", "build",	    "built",	"built",    "/verbsAudio/to_build.m4a","",""),
                //new Verb("9", "burn",	    "burnt",	"burnt",    "/verbsAudio/9to_burn.mp3","",""),
                new Verb("9", "buy",	    "bought",	"bought",   "/verbsAudio/to_buy.mp3","",""),
                new Verb("10","can",	    "could",	"been able to","/verbsAudio/to_can.m4a","",""),
                new Verb("11", "catch",	    "caught",	"caught",   "/verbsAudio/to_catch.m4a","",""),
                new Verb("12", "choose",	"chose",	"chosen",   "/verbsAudio/to_choose.m4a","",""),
                new Verb("13", "come",	    "came",	    "come",     "/verbsAudio/to_come.mp3","",""),
                new Verb("14", "cost",	    "cost",	    "cost",     "/verbsAudio/to_cost.m4a","",""),
                new Verb("15", "cut",	    "cut",	    "cut",      "/verbsAudio/to_cut.m4a","",""),
                new Verb("16", "deal",	    "dealt",	"dealt",    "/verbsAudio/to_deal.m4a","",""),
                new Verb("17", "do",	    "did",	    "done",     "/verbsAudio/to_do.mp3","",""),
                //new Verb("18", "draw",	    "drew",	    "drawn",    "/verbsAudio/19to_draw.mp3","",""),
                new Verb("18", "drink",	    "drank",	"drunk",    "/verbsAudio/to_drink.mp3","",""),
                new Verb("19", "drive",	    "drove",	"driven",   "/verbsAudio/to_drive.m4a","",""),
                new Verb("20", "eat",	    "ate",	    "eaten",    "/verbsAudio/to_eat.mp3","",""),
                new Verb("21", "fall",	    "fell",	    "fallen",   "/verbsAudio/to_fall.m4a","",""),
                //new Verb("22", "feed",	    "fed",	    "fed",      "/verbsAudio/24to_feed.mp3","",""),
                new Verb("22", "feel",	    "felt",	    "felt",     "/verbsAudio/to_feel.mp3","",""),
                //new Verb("23", "fight",	    "fought",	"fought",   "/verbsAudio/26to_fight.mp3","",""),
                new Verb("23", "find",	    "found",	"found",    "/verbsAudio/to_find.m4a","",""),
                new Verb("24", "fly",	    "flew",	    "flown",    "/verbsAudio/to_fly.mp3","",""),
                new Verb("25", "forget",	"forgot",	"forgotten", "/verbsAudio/to_forget.m4a","",""),
                //new Verb("26", "forgive",	"forgave",	"forgiven", "/verbsAudio/30to_forgive.mp3","",""),
                //new Verb("27", "freeze",	"froze",	"frozen",   "/verbsAudio/31to_freeze.mp3","",""),
                new Verb("26", "get",	    "got",	    "got",      "/verbsAudio/to_get.m4a","",""),
                new Verb("27", "give",	    "gave",	    "given",    "/verbsAudio/to_give.m4a","",""),
                new Verb("28", "go",	    "went",	    "gone",     "/verbsAudio/to_go.m4a","",""),
                new Verb("29", "grow",	    "grew",	    "grown",    "/verbsAudio/to_grow.m4a","",""),
                //new Verb("30", "hang",	    "hung",	    "hung",     "/verbsAudio/36to_hang.mp3","",""),
                new Verb("30", "have",	    "had",	    "had",      "/verbsAudio/to_have.mp3","",""),
                new Verb("31", "hear",	    "heard",	"heard",    "/verbsAudio/to_hear.m4a","",""),
                //new Verb("32", "hide",	    "hid",	    "hidden",   "/verbsAudio/39to_hide.mp3","",""),
                new Verb("32", "hit",	    "hit",	    "hit",      "/verbsAudio/to_hit.m4a","",""),
                new Verb("33", "hold",	    "held",	    "held",     "/verbsAudio/to_hold.m4a","",""),
                //new Verb("34", "hurt",	    "hurt",	    "hurt",     "/verbsAudio/42to_hurt.mp3","",""),
                new Verb("34", "keep",	    "kept",	    "kept",     "/verbsAudio/to_keep.mp3","",""),
                new Verb("35", "know",	    "knew",	    "known",    "/verbsAudio/to_know.m4a","",""),
                //new Verb("36", "lay",	    "laid",	    "laid",     "/verbsAudio/45to_lay.mp3","",""),
                //new Verb("36", "lead",	    "led",	    "led",      "/verbsAudio/46to_lead.mp3","",""),
                new Verb("36","learn",        "learnt",	"learnt",   "/verbsAudio/to_learn.m4a","",""),
                new Verb("37", "leave",	    "left",	    "left",     "/verbsAudio/to_leave.m4a","",""),
                //new Verb("38", "lend",	    "lent",	    "lent",     "/verbsAudio/49to_lend.mp3","",""),
                new Verb("39", "let",	    "let",	    "let",      "/verbsAudio/to_let.m4a","",""),
                //new Verb("40", "lie",	    "lay",	    "lain",     "/verbsAudio/51to_lie.mp3","",""),
                //new Verb("41", "light",	    "lit",	    "lit",      "/verbsAudio/52to_light.mp3","",""),
                new Verb("40", "lose",	    "lost",	    "lost",     "/verbsAudio/to_lose.m4a","",""),
                new Verb("41", "make",	    "made",	    "made",     "/verbsAudio/to_make.m4a","",""),
                new Verb("42", "mean",	    "meant",	"meant",    "/verbsAudio/to_mean.m4a","",""),
                new Verb("43", "meet",	    "met",	    "met",      "/verbsAudio/to_meet.m4a","",""),
                new Verb("44", "pay",	    "paid",	    "paid",     "/verbsAudio/to_pay.m4a","",""),
                new Verb("45", "put",	    "put",	    "put",      "/verbsAudio/to_put.m4a","",""),
                new Verb("46", "read",	    "read",	    "read",     "/verbsAudio/to_read.m4a","",""),
                //new Verb("47", "ride",	    "rode",	    "ridden",   "/verbsAudio/60to_ride.mp3","",""),
                //new Verb("47", "ring",	    "rang",	    "rung",     "/verbsAudio/61to_ring.mp3","",""),
                new Verb("47", "rise",	    "rose",	    "risen",    "/verbsAudio/to_rise.m4a","",""),
                new Verb("48", "run",	    "ran",	    "run",      "/verbsAudio/to_run.m4a","",""),
                new Verb("49", "say",	    "said",	    "said",     "/verbsAudio/to_say.m4a","",""),
                new Verb("50", "see",	    "saw",	    "seen",     "/verbsAudio/to_see.m4a","",""),
                new Verb("51", "sell",	    "sold",	    "sold",     "/verbsAudio/to_sell.m4a","",""),
                new Verb("52", "send",	    "sent",	    "sent",     "/verbsAudio/to_send.m4a","",""),
                new Verb("53", "set",	    "set",	    "set",      "/verbsAudio/to_set.m4a","",""),
                //new Verb("54", "shake",	    "shook",	"shaken",   "/verbsAudio/69to_shake.mp3","",""),
                //new Verb("55", "shine",	    "shone",	"shone",    "/verbsAudio/70to_shine.mp3","",""),
                //new Verb("56", "shoot",	    "shot",	    "shot",     "/verbsAudio/71to_shoot.mp3","",""),
                new Verb("54", "show",	    "showed",	"shown",    "/verbsAudio/to_show.m4a","",""),
                new Verb("55", "shut",	    "shut",	    "shut",     "/verbsAudio/to_shut.m4a","",""),
                new Verb("56", "sing",	    "sang",	    "sung",     "/verbsAudio/to_sing.m4a","",""),
                //new Verb("60", "sink",	    "sank",	    "sunk",     "/verbsAudio/75to_sink.mp3","",""),
                new Verb("57", "sit",	    "sat",	    "sat",      "/verbsAudio/to_sit.m4a","",""),
                new Verb("58", "sleep",	    "slept",	"slept",    "/verbsAudio/to_sleep.m4a","",""),
                //new Verb("63", "smell",	    "smelt",	"smelt",    "/verbsAudio/78to_smell.mp3","",""),
                new Verb("59", "speak",       "spoke",	"spoken",   "/verbsAudio/to_speak.m4a","",""),
                new Verb("60", "spend",	    "spent",	"spent",    "/verbsAudio/to_spend.m4a","",""),
                //new Verb("60", "stand",	    "stood",	"stood",    "/verbsAudio/81to_stand.mp3","",""),
                new Verb("61","swim",       "swam",	    "swum",     "/verbsAudio/to_swim.m4a","",""),
                new Verb("62", "take",	    "took",	    "taken",    "/verbsAudio/to_take.m4a","",""),
                new Verb("63", "teach",	    "taught",	"taught",   "/verbsAudio/to_teach.m4a","",""),
                new Verb("64", "tell",	    "told",	    "told",     "/verbsAudio/to_tell.m4a","",""),
                new Verb("65", "think",	    "thought",	"thought",  "/verbsAudio/to_think.m4a","",""),
                new Verb("66", "throw",	    "threw",	"thrown",   "/verbsAudio/to_throw.m4a","",""),
                //new Verb("67", "understand",	"understood","understood","/verbsAudio/88to_understand.mp3","",""),
                //new Verb("68", "wake",	    "woke",	    "woken",    "/verbsAudio/89to_wake.mp3","",""),
                //new Verb("69", "wear",	    "wore",	    "worn",     "/verbsAudio/90to_wear.mp3","",""),
                new Verb("67", "win",	    "won",	    "won",      "/verbsAudio/to_win.m4a","",""),
                new Verb("68", "write",	    "wrote",	"written",  "/verbsAudio/to_write.m4a","","")











               /* new Verb("11", "know",	    "knew",	    "known",    "/verbsAudio/","",""),
                new Verb("12", "leave",	    "left",	    "left",     "/verbsAudio/","",""),
                new Verb("13", "lose",	    "lost",	    "lost",     "/verbsAudio/","",""),
                new Verb("14", "make",	    "made",	    "made",     "/verbsAudio/","",""),
                new Verb("15", "meet",	    "met",	    "met",      "/verbsAudio/","",""),
                new Verb("16", "pay",	    "paid",	    "paid",     "/verbsAudio/","",""),
                new Verb("17", "read",	    "read",	    "read",     "/verbsAudio/","",""),
                new Verb("18", "run",	    "ran",	    "run",      "/verbsAudio/","",""),
                new Verb("19", "say",	    "said",	    "said",     "/verbsAudio/","",""),
                new Verb("20", "see",	    "saw",	    "seen",     "/verbsAudio/","","")

                */
                ));
    }















}
