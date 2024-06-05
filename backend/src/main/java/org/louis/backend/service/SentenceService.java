package org.louis.backend.service;


import lombok.RequiredArgsConstructor;
import org.louis.backend.model.Sentence;
import org.louis.backend.repository.SentenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SentenceService {

    private final SentenceRepository sentenceRepository;




    public void addSentenses () {
        sentenceRepository.deleteAll();
        sentenceRepository.saveAll(List.of(
                new Sentence("1", "I want to @ a better person.", "Yesterday, I @ my best.", "I have @ my best for years."),
                new Sentence("1", "She likes to @ happy.", "Last week, she @ unhappy.", "She has @ happy since then."),

                new Sentence("2", "I want to @ the high score.", "Yesterday, I @ my own record.", "I have @ my own record."),
                new Sentence("2", "She likes to @ her rivals.", "Last week, she @ them all.", "She has @ her rivals every time."),

                new Sentence("3", "I want to @ a doctor.", "Yesterday, I @ a teacher.", "I have @ a good person."),
                new Sentence("3", "She likes to @ someone new.", "Last week, she @ a friend.", "She has @ a great friend."),

                new Sentence("4", "I want to @ my day early.", "Yesterday, I @ my day at dawn.", "I have @ my mornings early for years."),
                new Sentence("4", "She likes to @ a new project.", "Last week, she @ a new job.", "She has @ many projects."),

                new Sentence("5", "I want to @ out the candles.", "Yesterday, I @ out the candles.", "I have @ out all the candles."),
                new Sentence("5", "She likes to @ bubbles.", "Last week, she @ bubbles for fun.", "She has @ bubbles since childhood."),

                new Sentence("6", "I want to @ my bad habits.", "Yesterday, I @ my phone.", "I have @ bad habits over time."),
                new Sentence("6", "She likes to @ barriers.", "Last week, she @ the record.", "She has @ many records."),

                new Sentence("7", "I want to @ a gift for you.", "Yesterday, I @ a cake.", "I have @ gifts every year."),
                new Sentence("7", "She likes to @ happiness to others.", "Last week, she @ joy to the party.", "She has @ joy to many events."),

                new Sentence("8", "I want to @ a sandcastle.", "Yesterday, I @ a fort.", "I have @ many sandcastles."),
                new Sentence("8", "She likes to @ her dreams.", "Last week, she @ her portfolio.", "She has @ her career successfully."),

                new Sentence("9", "I want to @ a new phone.", "Yesterday, I @ a book.", "I have @ many things online."),
                new Sentence("9", "She likes to @ groceries.", "Last week, she @ fresh vegetables.", "She has @ organic food every time."),

                new Sentence("10", "I want to @ swim well.", "Yesterday, I @ swim better.", "I have @ swim properly."),
                new Sentence("10", "She likes to @ drive.", "Last week, she @ drive alone.", "She has @ drive carefully."),

                new Sentence("11", "I want to @ the ball.", "Yesterday, I @ the bus.", "I have @ the ball many times."),
                new Sentence("11", "She likes to @ a movie.", "Last week, she @ a cold.", "She has @ many movies."),

                new Sentence("12", "I want to @ the best option.", "Yesterday, I @ a dress.", "I have @ wisely."),
                new Sentence("12", "She likes to @ her meal.", "Last week, she @ a dessert.", "She has @ deliciously."),

                new Sentence("13", "I want to @ to your party.", "Yesterday, I @ home early.", "I have @ to many parties."),
                new Sentence("13", "She likes to @ with us.", "Last week, she @ to visit.", "She has @ many times."),

                new Sentence("14", "I want to @ a new car.", "Yesterday, it @ a lot.", "It has @ the same since then."),
                new Sentence("14", "She likes to @ for quality.", "Last week, it @ too much.", "It has @ a fortune."),

                new Sentence("15", "I want to @ the ribbon.", "Yesterday, I @ the paper.", "I have @ it perfectly."),
                new Sentence("15", "She likes to @ her hair.", "Last week, she @ her nails.", "She has @ her hair often."),

                new Sentence("16", "I want to @ with tough situations.", "Yesterday, I @ with a client.", "I have @ with many challenges."),
                new Sentence("16", "She likes to @ with problems.", "Last week, she @ a hard task.", "She has @ effectively."),

                new Sentence("17", "I want to @ my homework.", "Yesterday, I @ my chores.", "I have @ my best."),
                new Sentence("17", "She likes to @ exercises.", "Last week, she @ yoga.", "She has @ yoga daily."),

                new Sentence("18", "I want to @ a smoothie.", "Yesterday, I @ tea.", "I have @ a lot."),
                new Sentence("18", "She likes to @ with friends.", "Last week, she @ coffee.", "She has @ coffee every morning."),

                new Sentence("19", "I want to @ a fast car.", "Yesterday, I @ to the beach.", "I have @ across the country."),
                new Sentence("19", "She likes to @ carefully.", "Last week, she @ to work.", "She has @ safely."),

                new Sentence("20", "I want to @ healthy food.", "Yesterday, I @ pizza.", "I have @ well."),
                new Sentence("20", "She likes to @ out.", "Last week, she @ sushi.", "She has @ at many places."),

                new Sentence("21", "I want to @ asleep quickly.", "Yesterday, I @ asleep early.", "I have @ asleep instantly."),
                new Sentence("21", "She likes to @ in love.", "Last week, she @ from grace.", "She has @ for him deeply."),

                new Sentence("22", "I want to @ happy.", "Yesterday, I @ sad.", "I have @ wonderful."),
                new Sentence("22", "She likes to @ great.", "Last week, she @ overwhelmed.", "She has @ amazing."),

                new Sentence("23", "I want to @ my keys.", "Yesterday, I @ my wallet.", "I have @ my phone."),
                new Sentence("23", "She likes to @ solutions.", "Last week, she @ a way out.", "She has @ her path."),

                new Sentence("24", "I want to @ a kite.", "Yesterday, I @ to Paris.", "I have @ to many places."),
                new Sentence("24", "She likes to @ high.", "Last week, she @ to New York.", "She has @ across the globe."),

                new Sentence("25", "I want to @ my worries.", "Yesterday, I @ my password.", "I have @ nothing important."),
                new Sentence("25", "She likes to @ everything.", "Last week, she @ her appointment.", "She has @ many details."),

                new Sentence("26", "I want to @ a good job.", "Yesterday, I @ some rest.", "I have @ the answer."),
                new Sentence("26", "She likes to @ what she wants.", "Last week, she @ a promotion.", "She has @ what she desired."),

                new Sentence("27", "I want to @ you a present.", "Yesterday, I @ my friend a ride.", "I have @ my best effort."),
                new Sentence("27", "She likes to @ help.", "Last week, she @ her time.", "She has @ generously."),

                new Sentence("28", "I want to @ to the market.", "Yesterday, I @ to the park.", "I have @ to many places."),
                new Sentence("28", "She likes to @ for a walk.", "Last week, she @ shopping.", "She has @ everywhere."),

                new Sentence("29", "I want to @ a plant.", "Yesterday, I @ some herbs.", "I have @ many vegetables."),
                new Sentence("29", "She likes to @ flowers.", "Last week, she @ tomatoes.", "She has @ beautifully."),

                new Sentence("30", "I want to @ a pet.", "Yesterday, I @ a great day.", "I have @ many opportunities."),
                new Sentence("30", "She likes to @ fun.", "Last week, she @ a meeting.", "She has @ amazing experiences."),

                new Sentence("31", "I want to @ a new song.", "Yesterday, I @ a strange noise.", "I have @ good news."),
                new Sentence("31", "She likes to @ stories.", "Last week, she @ an argument.", "She has @ interesting tales."),

                new Sentence("32", "I want to @ the target.", "Yesterday, I @ the nail.", "I have @ the bullseye."),
                new Sentence("32", "She likes to @ a goal.", "Last week, she @ the mark.", "She has @ it perfectly."),

                new Sentence("33", "I want to @ my baby.", "Yesterday, I @ my drink.", "I have @ my ground."),
                new Sentence("33", "She likes to @ on tight.", "Last week, she @ a meeting.", "She has @ her position."),

                new Sentence("34", "I want to @ my promise.", "Yesterday, I @ my calm.", "I have @ a secret."),
                new Sentence("34", "She likes to @ in touch.", "Last week, she @ track.", "She has @ her goals."),

                new Sentence("35", "I want to @ the answer.", "Yesterday, I @ the truth.", "I have @ the solution."),
                new Sentence("35", "She likes to @ everyone.", "Last week, she @ everything.", "She has @ it all."),

                new Sentence("36", "I want to @ a new skill.", "Yesterday, I @ a lot.", "I have @ quickly."),
                new Sentence("36", "She likes to @ new things.", "Last week, she @ quickly.", "She has @ easily."),

                new Sentence("37", "I want to @ on time.", "Yesterday, I @ my office.", "I have @ early."),
                new Sentence("37", "She likes to @ her home.", "Last week, she @ for vacation.", "She has @ often."),

                new Sentence("39", "I want to @ you help.", "Yesterday, I @ him go.", "I have @ it be."),
                new Sentence("39", "She likes to @ her feelings out.", "Last week, she @ her worries out.", "She has @ it all out."),

                new Sentence("40", "I want to @ my keys.", "Yesterday, I @ my wallet.", "I have @ my patience."),
                new Sentence("40", "She likes to @ weight.", "Last week, she @ her way.", "She has @ her belongings."),

                new Sentence("41", "I want to @ a cake.", "Yesterday, I @ a plan.", "I have @ a decision."),
                new Sentence("41", "She likes to @ crafts.", "Last week, she @ a choice.", "She has @ progress."),

                new Sentence("42", "I want to @ a difference.", "Yesterday, I @ it clear.", "I have @ my mind."),
                new Sentence("42", "She likes to @ a statement.", "Last week, she @ a point.", "She has @ an impact."),

                new Sentence("43", "I want to @ new people.", "Yesterday, I @ my friend.", "I have @ amazing individuals."),
                new Sentence("43", "She likes to @ interesting personalities.", "Last week, she @ a celebrity.", "She has @ her idol."),

                new Sentence("44", "I want to @ attention.", "Yesterday, I @ the bill.", "I have @ respect."),
                new Sentence("44", "She likes to @ for quality.", "Last week, she @ a visit.", "She has @ a lot."),

                new Sentence("45", "I want to @ the book here.", "Yesterday, I @ my phone down.", "I have @ the dishes away."),
                new Sentence("45", "She likes to @ things in order.", "Last week, she @ her bag down.", "She has @ everything in place."),

                new Sentence("46", "I want to @ a new book.", "Yesterday, I @ a mystery novel.", "I have @ many stories."),
                new Sentence("46", "She likes to @ before bed.", "Last week, she @ a magazine.", "She has @ a lot."),

                new Sentence("47", "I want to @ early.", "Yesterday, I @ from my chair.", "I have @ to the challenge."),
                new Sentence("47", "She likes to @ to the occasion.", "Last week, she @ above it all.", "She has @ successfully."),

                new Sentence("48", "I want to @ a marathon.", "Yesterday, I @ to the store.", "I have @ every day."),
                new Sentence("48", "She likes to @ fast.", "Last week, she @ quickly.", "She has @ many races."),

                new Sentence("49", "I want to @ something important.", "Yesterday, I @ goodbye.", "I have @ my thoughts."),
                new Sentence("49", "She likes to @ thank you.", "Last week, she @ hello.", "She has @ a lot."),

                new Sentence("50", "I want to @ a beautiful view.", "Yesterday, I @ a movie.", "I have @ many things."),
                new Sentence("50", "She likes to @ the sunrise.", "Last week, she @ a rainbow.", "She has @ the world."),

                new Sentence("51", "I want to @ my old car.", "Yesterday, I @ my bike.", "I have @ many things."),
                new Sentence("51", "She likes to @ handmade items.", "Last week, she @ a product.", "She has @ successfully."),

                new Sentence("52", "I want to @ a postcard.", "Yesterday, I @ an email.", "I have @ many letters."),
                new Sentence("52", "She likes to @ messages.", "Last week, she @ a package.", "She has @ gifts."),

                new Sentence("53", "I want to @ my priorities.", "Yesterday, I @ my schedule.", "I have @ my goals."),
                new Sentence("53", "She likes to @ the table.", "Last week, she @ the scene.", "She has @ the example."),

                new Sentence("54", "I want to @ you my project.", "Yesterday, I @ my work.", "I have @ my skills."),
                new Sentence("54", "She likes to @ her progress.", "Last week, she @ her talent.", "She has @ many times."),

                new Sentence("55", "I want to @ the door.", "Yesterday, I @ the window.", "I have @ the gate."),
                new Sentence("55", "She likes to @ her mouth.", "Last week, she @ the conversation.", "She has @ it closed."),

                new Sentence("56", "I want to @ a song.", "Yesterday, I @ a melody.", "I have @ many tunes."),
                new Sentence("56", "She likes to @ beautifully.", "Last week, she @ in the choir.", "She has @ her heart out."),

                new Sentence("57", "I want to @ on the couch.", "Yesterday, I @ on a bench.", "I have @ here."),
                new Sentence("57", "She likes to @ comfortably.", "Last week, she @ at the cafe.", "She has @ peacefully."),

                new Sentence("58", "I want to @ early.", "Yesterday, I @ well.", "I have @ through the night."),
                new Sentence("58", "She likes to @ in.", "Last week, she @ soundly.", "She has @ like a baby."),

                new Sentence("59", "I want to @ another language.", "Yesterday, I @ with my friend.", "I have @ fluently."),
                new Sentence("59", "She likes to @ clearly.", "Last week, she @ at a conference.", "She has @ eloquently."),

                new Sentence("60", "I want to @ my money wisely.", "Yesterday, I @ too much.", "I have @ responsibly."),
                new Sentence("60", "She likes to @ time with family.", "Last week, she @ her savings.", "She has @ carefully."),

                new Sentence("61", "I want to @ in the ocean.", "Yesterday, I @ at the pool.", "I have @ like a fish."),
                new Sentence("61", "She likes to @ daily.", "Last week, she @ across the lake.", "She has @ competitively."),

                new Sentence("62", "I want to @ a break.", "Yesterday, I @ a nap.", "I have @ many risks."),
                new Sentence("62", "She likes to @ a photo.", "Last week, she @ a chance.", "She has @ the initiative."),

                new Sentence("63", "I want to @ you French.", "Yesterday, I @ a lesson.", "I have @ many students."),
                new Sentence("63", "She likes to @ kids.", "Last week, she @ her skills.", "She has @ effectively."),

                new Sentence("64", "I want to @ you a story.", "Yesterday, I @ the truth.", "I have @ many tales."),
                new Sentence("64", "She likes to @ secrets.", "Last week, she @ her friends.", "She has @ them everything."),

                new Sentence("65", "I want to @ critically.", "Yesterday, I @ deeply.", "I have @ about it."),
                new Sentence("65", "She likes to @ ahead.", "Last week, she @ about the plan.", "She has @ of a solution."),

                new Sentence("66", "I want to @ a ball.", "Yesterday, I @ a party.", "I have @ many opportunities."),
                new Sentence("66", "She likes to @ ideas.", "Last week, she @ a stone.", "She has @ the competition."),

                new Sentence("67", "I want to @ the lottery.", "Yesterday, I @ a game.", "I have @ many prizes."),
                new Sentence("67", "She likes to @ prizes.", "Last week, she @ a contest.", "She has @ every challenge."),

                new Sentence("68", "I want to @ a book.", "Yesterday, I @ an essay.", "I have @ many stories."),
                new Sentence("68", "She likes to @ letters.", "Last week, she @ a poem.", "She has @ beautifully.")

        ));


    }

}
