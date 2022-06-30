package Kau.letter.blob;

import Kau.Metadata;
import Kau.user.User;

public class LetterBlobMetadata extends Metadata {
    private final User sender;
    private final User receiver;

    public LetterBlobMetadata(User sender, User receiver) {
        super();
        this.receiver = receiver;
        this.sender = sender;
    }
}
