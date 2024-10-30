package es.jorgegueyer.quarkus.observability.extension.runtime.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

import java.util.List;
import java.util.Map;

@ConfigRoot(phase = ConfigPhase.RUN_TIME, name = "log.handler.kafka")
public class KafkaHandlerConfig {

    /**
     * Determine whether to enable the Kafka logging handler
     */
    @ConfigItem
    public boolean enabled;

    /**
     * List of brokers
     */
    @ConfigItem
    public List<String> brokerList;

    /**
     * Topic
     */
    @ConfigItem
    public String topic;

    /**
     * Kafka Producer properties
     */
    public Map<String, Object> properties;
}
