package Kau.handler.letter;

import Kau.data.letter.Letter;
import Kau.job.CommandQueueJob;
import Kau.queue.commandqueue.consumer.BaseConsumer;
import Kau.service.NoSQLLetterStorageService;
import Kau.service.RedisLetterStorageService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Closeable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static Kau.QueueConstants.COMMAND_QUEUE_NAME;

public class PersistLetterJobHandler implements Closeable, BaseConsumer.ConsumerFunction {
    private final RedisLetterStorageService redisLetterStorageService;
    private final NoSQLLetterStorageService noSQLLetterStorageService;
    private BaseConsumer commandQueueConsumer;

    public PersistLetterJobHandler() {
        this.redisLetterStorageService = new RedisLetterStorageService();
        this.noSQLLetterStorageService = new NoSQLLetterStorageService();
        initConsumer();
    }

    private void initConsumer() {
        try {
            this.commandQueueConsumer = new BaseConsumer(this, COMMAND_QUEUE_NAME);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    synchronized public void consume(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
        CommandQueueJob commandQueueJob = SerializationUtils.deserialize(body);
        Letter letter = commandQueueJob.getLetter();
        Future<Boolean> redisFuture = redisLetterStorageService.persistLetterToRedis(letter);
        Future<Boolean> dbFuture = noSQLLetterStorageService.persistLetterToNoSQL(letter);
        try {
            if (!redisFuture.get() || !dbFuture.get()) {
                throw new RuntimeException("Persisting in DB or Redis failed for letter: " + letter);
            }
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    synchronized public void close() {
        commandQueueConsumer.close();
    }
}
