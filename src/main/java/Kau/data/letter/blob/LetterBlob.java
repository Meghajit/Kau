package Kau.data.letter.blob;

import Kau.data.Blob;

public class LetterBlob extends Blob {
    private final LetterBlobMetadata metadata;

    public LetterBlob(ContentType contentType, String accessURL, LetterBlobMetadata metadata) {
        super(contentType, accessURL, metadata);
        this.metadata = metadata;
    }
}