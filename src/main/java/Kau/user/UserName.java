package Kau.user;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UserName {
    private final byte[] username;
    private final Charset usernameCharset;

    public UserName(byte[] username, Charset usernameCharset) {
        this.username = username;
        this.usernameCharset = usernameCharset;
    }

    public UserName(byte[] username) {
        this.username = username;
        this.usernameCharset = StandardCharsets.UTF_8;
    }
}
