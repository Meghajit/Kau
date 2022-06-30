package Kau.letter;

import Kau.Blob;
import Kau.letter.message.Message;

import java.io.Serializable;

public class Letter implements Serializable {
    private final Message message;
    private final Blob blob;
    private final LetterMetadata metadata;

    public Letter(Message message, Blob blob, LetterMetadata metadata) {
        this.message = message;
        this.blob = blob;
        this.metadata = metadata;
    }
}