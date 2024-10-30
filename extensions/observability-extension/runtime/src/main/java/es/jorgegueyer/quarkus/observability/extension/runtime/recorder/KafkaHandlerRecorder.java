package es.jorgegueyer.quarkus.observability.extension.runtime.recorder;

import es.jorgegueyer.quarkus.observability.extension.runtime.config.KafkaHandlerConfig;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import org.jboss.logmanager.handlers.AsyncHandler;

import java.util.Optional;
import java.util.logging.Handler;

@Recorder
public class KafkaHandlerRecorder {

    public RuntimeValue<Optional<Handler>> initializeHandler(final KafkaHandlerConfig config) {
        if (!config.enabled) {
            return new RuntimeValue<>(Optional.empty());
        }
        AsyncHandler asyncHandler = new AsyncHandler();

    }
}
