package Kau;

import Kau.letter.blob.ContentType;

import java.io.Serializable;

public class Blob implements Serializable {
    private final ContentType contentType;
    private final String accessURL;
    private final Metadata metadata;

    public Blob(ContentType contentType, String accessURL, Metadata metadata) {
        this.contentType = contentType;
        this.accessURL = accessURL;
        this.metadata = metadata;
    }
}
