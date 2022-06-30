package Kau.user;

import Kau.Blob;
import Kau.user.preference.Preference;

import java.util.UUID;

public class User {
    private final UUID uuid;
    private final PhoneNumber phoneNumber;
    private final UserName userName;
    private final Blob profilePicture;
    private final Status status;
    private final UserMetadata metadata;
    private final Preference[] preferences;

    public User(UUID uuid, PhoneNumber phoneNumber, UserName userName, Blob profilePicture, Status status, UserMetadata metadata, Preference[] preferences) {
        this.uuid = uuid;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.profilePicture = profilePicture;
        this.status = status;
        this.metadata = metadata;
        this.preferences = preferences;
    }
}
