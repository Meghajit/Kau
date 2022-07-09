package Kau.config;

import com.rabbitmq.client.Channel;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class MegaConfig {
    private static RabbitMQConfig rabbitMQConfig;
    private static GenericObjectPoolConfig<Channel> genericObjectPoolConfig;

    public static RabbitMQConfig getRabbitMQConfig() {
        if (rabbitMQConfig == null) {
            rabbitMQConfig = new RabbitMQConfig();
        }
        return rabbitMQConfig;
    }

    public static GenericObjectPoolConfig<Channel> getGenericObjectPoolConfig() {
        if (genericObjectPoolConfig == null) {
            genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        }
        return genericObjectPoolConfig;
    }
}
