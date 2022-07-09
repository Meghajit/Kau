package Kau.queue.commandqueue.publisher.base;

public class ConcurrentPublisherProvider {
    private static ConcurrentPublisher publisher;

    public static ConcurrentPublisher getConcurrentPublisher() {
        if (publisher == null) {
            publisher = new ConcurrentPublisher();
        }
        return publisher;
    }
}
