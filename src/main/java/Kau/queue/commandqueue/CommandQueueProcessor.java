package Kau.queue.commandqueue;

import Kau.Job;

public interface CommandQueueProcessor {
    boolean putJob(Job job);

    Job getJob();
}
