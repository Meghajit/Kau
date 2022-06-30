package Kau.data.letter;

import Kau.data.Metadata;

import java.util.UUID;

/*
 * We only save the UUID of sender and receiver. This is to maintain smaller payload of the letter in general.
 * The UI can fetch once and cache a map of UUID -> User. There afterwards, it can show the appropriate UI when showing messages
 *
 * Times is an array which will save the times of various receipts like sent, received and delivered.
 * It's important to note that even though user might have turned off delivery receipts, Kau
 * will still associate and save the Times info for all different types of receipts
 * to a Letter all the time. We do this because we might need it for analytics and security reasons.
 * At the gateway layer, elements of this array will be mutated as per user preferences saved in the
 * User object (User object will be cached in memory after fetching from ETCD) so that user can only see delivery receipts as per his
 * preference.
 * */

public class LetterMetadata extends Metadata {
    private final UUID senderUUID;
    private final UUID receiverUUID;
    private final Times[] times;

    public LetterMetadata(UUID senderUUID, UUID receiverUUID, Times[] times) {
        super();
        this.senderUUID = senderUUID;
        this.receiverUUID = receiverUUID;
        this.times = times;
    }
}
