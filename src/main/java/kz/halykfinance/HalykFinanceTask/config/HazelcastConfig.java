package kz.halykfinance.HalykFinanceTask.config;

import com.hazelcast.config.*;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {
    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName("hazelcast-instance");

        NetworkConfig networkConfig = config.getNetworkConfig();
        JoinConfig joinConfig = networkConfig.getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).addMember("127.0.0.1");

        QueueConfig queueConfig = new QueueConfig("messageQueue");
        queueConfig.setBackupCount(1);
        queueConfig.setMaxSize(0);
        queueConfig.setStatisticsEnabled(true);
        queueConfig.setSplitBrainProtectionName("splitbrainprotectionname");

        queueConfig.setQueueStoreConfig(new QueueStoreConfig()
                .setEnabled(true)
                .setClassName("com.hazelcast.QueueStoreImpl")
                .setProperty("binary", "false"));

        config.addQueueConfig(queueConfig);

        HazelcastInstance instance = com.hazelcast.core.Hazelcast.newHazelcastInstance(config);
        return instance;
    }
}
