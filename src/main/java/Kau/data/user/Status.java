package Kau.data.user;

import java.nio.charset.StandardCharsets;

public class Status {
    private final byte[] statusText;
    private final String statusTextCharset;

    public Status(byte[] statusText, String statusTextCharset) {
        this.statusText = statusText;
        this.statusTextCharset = statusTextCharset;
    }

    public Status(byte[] statusText) {
        this.statusText = statusText;
        this.statusTextCharset = StandardCharsets.UTF_8.name();
    }
}
