package Kau.queue.rabbitmq;

import Kau.config.MegaConfig;
import com.rabbitmq.client.Channel;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import static Kau.config.MegaConfig.getGenericObjectPoolConfig;

public class ChannelPoolFactory {
    public static GenericObjectPool<Channel> newChannelPool() {
        return newChannelPool(1);
    }

    public static GenericObjectPool<Channel> newChannelPool(int numChannels) {
        GenericObjectPoolConfig<Channel> config = getGenericObjectPoolConfig();
        config.setMaxTotal(numChannels);
        return new GenericObjectPool<>(getChannelFactory(), config);
    }

    public static ChannelFactory getChannelFactory() {
        return new ChannelFactory(MegaConfig.getRabbitMQConfig());
    }
}
