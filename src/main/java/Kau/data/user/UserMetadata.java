package Kau.data.user;

import Kau.data.Metadata;

import java.time.Instant;

public class UserMetadata extends Metadata {
    private String appVersion;
    private Instant registrationTime;
    private String deviceName;
    private String osVersion;
    private String lastOnlineTime;

    public UserMetadata(String appVersion, Instant registrationTime, String deviceName, String osVersion, String lastOnlineTime) {
        super();
        this.appVersion = appVersion;
        this.registrationTime = registrationTime;
        this.deviceName = deviceName;
        this.osVersion = osVersion;
        this.lastOnlineTime = lastOnlineTime;
    }
}
