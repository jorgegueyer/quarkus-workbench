package es.jorgegueyer.quarkus.observability.extension.runtime.recorder;

import es.jorgegueyer.quarkus.observability.extension.runtime.config.KafkaHandlerConfig;
import es.jorgegueyer.quarkus.observability.extension.runtime.handler.KafkaHandler;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;

import java.util.Optional;
import java.util.logging.Handler;

@Recorder
public class KafkaHandlerRecorder {

    private final KafkaHandlerConfig kafkaHandlerConfig;

    public KafkaHandlerRecorder(KafkaHandlerConfig kafkaHandlerConfig) {
        this.kafkaHandlerConfig = kafkaHandlerConfig;
    }

    public RuntimeValue<Optional<Handler>> initializeHandler() {
        if (this.kafkaHandlerConfig.enabled()) {
            return new RuntimeValue<>(Optional.empty());
        }
        return new RuntimeValue<>(Optional.of(new KafkaHandler()));

    }
}
