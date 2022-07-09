package Kau.job;

import Kau.data.letter.Letter;

public class CommandQueueJob extends Job {
    private final Letter letter;

    public CommandQueueJob(JobType type, Letter letter) {
        super(type, letter);
        this.letter = letter;
    }

    public Letter getLetter() {
        return letter;
    }
}
