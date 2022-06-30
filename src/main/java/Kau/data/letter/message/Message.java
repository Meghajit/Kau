package Kau.data.letter.message;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Message implements Serializable {
    private final byte[] text;
    private final Charset textCharset;
    private final MessageMetadata metadata;

    public Message(byte[] text, Charset textCharset, MessageMetadata metadata) {
        this.text = text;
        this.textCharset = textCharset;
        this.metadata = metadata;
    }

    public Message(byte[] text, MessageMetadata metadata) {
        this.text = text;
        this.textCharset = StandardCharsets.UTF_8;
        this.metadata = metadata;
    }
}
