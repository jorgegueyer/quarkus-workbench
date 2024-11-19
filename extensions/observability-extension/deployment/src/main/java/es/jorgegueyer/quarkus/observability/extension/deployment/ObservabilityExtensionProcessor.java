package es.jorgegueyer.quarkus.observability.extension.deployment;

import es.jorgegueyer.quarkus.observability.extension.runtime.recorder.KafkaHandlerRecorder;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.LogHandlerBuildItem;

class ObservabilityExtensionProcessor {

    private static final String FEATURE = "observability-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    void registerKafkaHandler(KafkaHandlerRecorder recorder, BuildProducer<LogHandlerBuildItem> logHandler) {
        logHandler.produce(new LogHandlerBuildItem(recorder.initializeHandler()));
    }
}
