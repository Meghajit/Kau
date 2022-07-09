package Kau.handler.letter;

import Kau.data.letter.Letter;
import Kau.job.CommandQueueJob;
import Kau.queue.commandqueue.publisher.base.ConcurrentPublisher;

import java.io.Closeable;

import static Kau.QueueConstants.COMMAND_QUEUE_NAME;
import static Kau.job.JobType.PERSIST_LETTER;

/* Only create a singleton of this class wherever required. This class is designed to work more like an event loop
* and will use the ConcurrentPublisher object to submit IO jobs to the ExecutorService IO threads. Access is synchronized and
* hence jobs will be put into the queue on FIFO basis as clients send letters. */

public class PersistLetterJobCreator implements Closeable {
    private final ConcurrentPublisher publisher;

    public PersistLetterJobCreator() {
        this.publisher = new ConcurrentPublisher();
    }

    synchronized public void submitPersistLetterJob(Letter letter) {
        CommandQueueJob commandQueueJob = new CommandQueueJob(PERSIST_LETTER, letter);
        publisher.insert(commandQueueJob, COMMAND_QUEUE_NAME);
    }

    @Override
    synchronized public void close() {
        publisher.close();
    }
}
