package Kau.queue.commandqueue;

@FunctionalInterface
public interface CommandQueueProcessorProvider {
    CommandQueueProcessor CommandQueueProcessor();
}
