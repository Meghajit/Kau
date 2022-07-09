package Kau.queue.rabbitmq;

import Kau.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ChannelFactory extends BasePooledObjectFactory<Channel> {
    private final RabbitMQConfig rabbitMQConfig;

    public ChannelFactory(RabbitMQConfig rabbitMQConfig) {
        this.rabbitMQConfig = rabbitMQConfig;
    }

    @Override
    public Channel create() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(rabbitMQConfig.userName);
        factory.setPassword(rabbitMQConfig.password);
        factory.setVirtualHost(rabbitMQConfig.virtualHost);
        factory.setHost(rabbitMQConfig.hostName);
        factory.setPort(rabbitMQConfig.portNumber);

        /* this needs to be optimised. the connection can be reused for channel creation
        * https://www.cloudamqp.com/blog/part4-rabbitmq-13-common-errors.html */
        return factory.newConnection().createChannel();
    }

    @Override
    public PooledObject<Channel> wrap(Channel obj) {
        return new DefaultPooledObject<>(obj);
    }

    @Override
    public void destroyObject(PooledObject<Channel> p, DestroyMode destroyMode) throws Exception {
        super.destroyObject(p, destroyMode);
        p.getObject().close();
    }
}
