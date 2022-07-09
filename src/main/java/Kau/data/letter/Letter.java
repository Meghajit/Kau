package Kau.data.letter;

import Kau.data.letter.blob.LetterBlob;
import Kau.data.letter.message.Message;

import java.io.Serializable;

public class Letter implements Serializable {
    private final Message message;
    private final LetterBlob letterBlob;
    private final LetterMetadata letterMetadata;

    public Letter(Message message, LetterBlob letterBlob, LetterMetadata letterMetadata) {
        this.message = message;
        this.letterBlob = letterBlob;
        this.letterMetadata = letterMetadata;
    }

    @Override
    public String toString() {
        return String.format("{ message : %s,\n letterBlob: %s,\n letterMetadata: %s\n}", message, letterBlob, letterMetadata);
    }

    public LetterMetadata getLetterMetadata() {
        return letterMetadata;
    }
}
