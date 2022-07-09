package Kau.queue;

import Kau.job.Job;

import java.io.Closeable;

public interface Publisher extends Closeable {
    void insert(Job job, String queueName);
}
