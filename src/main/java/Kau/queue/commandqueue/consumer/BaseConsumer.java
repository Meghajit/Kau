package Kau.queue.commandqueue.consumer;

import Kau.queue.rabbitmq.ChannelPoolFactory;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class BaseConsumer implements Consumer {
    private final Channel channel;
    private final String queueName;
    private final ConsumerFunction consumerFunction;
    private volatile String consumerTag;

    public BaseConsumer(ConsumerFunction consumerFunction, String queueName) throws Exception {
        this.consumerFunction = consumerFunction;
        this.queueName = queueName;
        this.channel = ChannelPoolFactory.getChannelFactory().create();
        register();
    }

    private void register() throws IOException {
        channel.queueDeclare(queueName, false, false, true, null);
        this.consumerTag = channel.basicConsume(queueName, true, this);
    }

    @Override
    public void handleConsumeOk(String consumerTag) {

    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) {

    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
        consumerFunction.consume(consumerTag, envelope, properties, body);
    }

    public void close() {
        try {
            channel.basicCancel(consumerTag);
            channel.close();
        } catch (IOException | TimeoutException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FunctionalInterface
    public interface ConsumerFunction {
        void consume(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body);
    }
}
