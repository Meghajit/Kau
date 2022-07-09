package Kau.handler.letter;

import Kau.data.letter.Letter;
import Kau.job.ResultQueueJob;
import Kau.queue.commandqueue.publisher.base.ConcurrentPublisher;
import Kau.service.UserSessionDiscovery;

import java.io.Closeable;

import static Kau.QueueConstants.RESULT_QUEUE_SUFFIX;
import static Kau.job.JobType.DELIVER_TO_RECIPIENT;

public class RecipientDeliveryHandler implements Closeable {
    private final ConcurrentPublisher publisher;

    public RecipientDeliveryHandler() {
        this.publisher = new ConcurrentPublisher();
    }

    synchronized public void submitRecipientDeliveryJob(Letter letter) {
        String sessionServer = UserSessionDiscovery.findSessionServer(letter.getLetterMetadata().getReceiverUUID());
        /* publish job only if recipient is online since only then can the App master consume this job and deliver to the recipient */
        if (sessionServer != null) {
            String queueName = getResultQueueNameFromSessionServer(sessionServer);
            ResultQueueJob resultQueueJob = new ResultQueueJob(DELIVER_TO_RECIPIENT, letter);
            publisher.insert(resultQueueJob, queueName);
        }
    }

    private static String getResultQueueNameFromSessionServer(String sessionServer) {
        return String.join("_", sessionServer, RESULT_QUEUE_SUFFIX);
    }

    @Override
    public void close() {
        publisher.close();
    }
}
