/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Kau;

import Kau.data.letter.Letter;
import Kau.data.letter.LetterMetadata;
import Kau.data.letter.Times;
import Kau.data.letter.message.Message;
import Kau.data.letter.message.MessageMetadata;
import Kau.handler.letter.PersistLetterJobCreator;
import Kau.handler.letter.PersistLetterJobHandler;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        PersistLetterJobCreator jobCreator = new PersistLetterJobCreator();
        jobCreator.submitPersistLetterJob(buildLetter());
        new PersistLetterJobHandler();
    }

    private static Letter buildLetter() {
        Message message = new Message("First call of Kau".getBytes(StandardCharsets.UTF_8),
                new MessageMetadata());
        LetterMetadata letterMetadata = new LetterMetadata(UUID.randomUUID(), UUID.randomUUID(), new Times[0]);
        return new Letter(message, null, letterMetadata);
    }
}
