package Kau.job;

import java.io.Serializable;

public class Job implements Serializable {
    private final JobType type;
    private final Object details;

    public Job(JobType type, Object details) {
        this.type = type;
        this.details = details;
    }
}
