package Kau.data.letter.message;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Message implements Serializable {
    private final byte[] text;
    private final String textCharset;
    private final MessageMetadata metadata;

    public Message(byte[] text, String textCharset, MessageMetadata metadata) {
        this.text = text;
        this.textCharset = textCharset;
        this.metadata = metadata;
    }

    public Message(byte[] text, MessageMetadata metadata) {
        this.text = text;
        this.textCharset = StandardCharsets.UTF_8.name();
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        String messageText = null;
        try {
            messageText = new String(text, textCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("{ text : %s,\n textCharset: %s,\n metadata: %s\n}", messageText, textCharset, metadata);
    }
}
