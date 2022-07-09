package Kau.data.letter.blob;

import Kau.data.Blob;

public class LetterBlob extends Blob {
    private final LetterBlobMetadata letterBlobMetadata;

    public LetterBlob(ContentType contentType, String accessURL, LetterBlobMetadata letterBlobMetadata) {
        super(contentType, accessURL, letterBlobMetadata);
        this.letterBlobMetadata = letterBlobMetadata;
    }

    @Override
    public String toString() {
        return String.format("{\nletterBlobMetadata : %s\n}", letterBlobMetadata);
    }
}
