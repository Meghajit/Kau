package Kau.queue.commandqueue.redis;

import Kau.Job;
import Kau.queue.commandqueue.CommandQueueProcessor;

public class RedisCommandQueueProcessor implements CommandQueueProcessor {
    @Override
    public boolean putJob(Job job) {
        return false;
    }

    @Override
    public Job getJob() {
        return null;
    }
}
