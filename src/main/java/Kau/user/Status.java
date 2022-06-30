package Kau.user;

import java.nio.charset.Charset;

public class Status {
    private final byte[] statusText;
    private final Charset statusTextCharset;

    public Status(byte[] statusText, Charset statusTextCharset) {
        this.statusText = statusText;
        this.statusTextCharset = statusTextCharset;
    }
}
