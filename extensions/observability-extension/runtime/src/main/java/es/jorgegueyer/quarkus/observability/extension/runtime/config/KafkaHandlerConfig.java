package es.jorgegueyer.quarkus.observability.extension.runtime.config;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@ConfigMapping(prefix = "log.handler.kafka")
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public interface KafkaHandlerConfig {

    /**
     * Determine whether to enable the Kafka logging handler
     */
    @WithDefault("false")
    boolean enabled();

    /**
     * List of brokers
     */
    @WithName("broker-list")
    Optional<List<String>> brokerList();

    /**
     * Topic
     */
    Optional<String> topic();

    /**
     * Kafka Producer properties
     */
    Map<String, Object> properties();
}
