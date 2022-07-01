package Kau.queue.commandqueue.database;

import Kau.Job;
import Kau.queue.commandqueue.CommandQueueProcessor;

public class DatabaseCommandQueueProcessor implements CommandQueueProcessor {
    @Override
    public boolean putJob(Job job) {
        return false;
    }

    @Override
    public Job getJob() {
        return null;
    }
}
