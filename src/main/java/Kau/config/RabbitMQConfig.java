package Kau.config;

public class RabbitMQConfig {
    public final String userName;
    public final String password;
    public final String virtualHost;
    public final String hostName;
    public final int portNumber;

    public RabbitMQConfig() {
        this.userName = "meghajit";
        this.password = "meghajit";
        this.virtualHost = "my_vhost";
        this.hostName = "localhost";
        this.portNumber = 5672;
    }
}
