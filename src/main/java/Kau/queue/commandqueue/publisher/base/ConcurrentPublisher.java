package Kau.queue.commandqueue.publisher.base;

import Kau.job.Job;
import Kau.queue.Publisher;
import Kau.queue.rabbitmq.ChannelPoolFactory;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentPublisher implements Publisher {
    private final ExecutorService threadPool;
    private final GenericObjectPool<Channel> channelPool;

    public ConcurrentPublisher() {
        this.threadPool = Executors.newFixedThreadPool(8);
        this.channelPool = ChannelPoolFactory.newChannelPool();
    }

    private static void reportError(Throwable t) {
        t.printStackTrace();
    }

    private final Thread.UncaughtExceptionHandler handler = (thread, throwable) -> reportError(throwable);

    @Override
    synchronized public void insert(Job job, String queueName) {
        Runnable runnable = () -> {
            try {
                Thread.currentThread().setUncaughtExceptionHandler(handler);
                Channel channel = channelPool.borrowObject(); // this is thread safe, hence multiple threads can borrow at the same time
                channel.queueDeclare(queueName, false, false, true, null);
                channel.basicPublish("", queueName, null, SerializationUtils.serialize(job));
                channelPool.returnObject(channel);
                System.out.println("Published message");
            } catch (Exception e) {
                reportError(e);
            }
        };
        threadPool.execute(runnable);
    }

    @Override
    public void close() {
        threadPool.shutdown();
        channelPool.close();
    }
}
