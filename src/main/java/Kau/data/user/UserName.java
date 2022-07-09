package Kau.data.user;

import java.nio.charset.StandardCharsets;

public class UserName {
    private final byte[] username;
    private final String usernameCharset;

    public UserName(byte[] username, String usernameCharset) {
        this.username = username;
        this.usernameCharset = usernameCharset;
    }

    public UserName(byte[] username) {
        this.username = username;
        this.usernameCharset = StandardCharsets.UTF_8.name();
    }
}
