package Kau.queue.commandqueue.database;

import Kau.queue.commandqueue.CommandQueueProcessor;
import Kau.queue.commandqueue.CommandQueueProcessorProvider;

public class Provider implements CommandQueueProcessorProvider {
    @Override
    public CommandQueueProcessor CommandQueueProcessor() {
        return null;
    }
}
