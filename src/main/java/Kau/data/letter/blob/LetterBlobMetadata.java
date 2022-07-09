package Kau.data.letter.blob;

import Kau.data.Metadata;
import Kau.data.user.User;

public class LetterBlobMetadata extends Metadata {
    private final User sender;
    private final User receiver;

    public LetterBlobMetadata(User sender, User receiver) {
        super();
        this.receiver = receiver;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return String.format("{\nsender : %s,\n receiver: %s\n}", sender, receiver);
    }
}
