package es.jorgegueyer.quarkus.observability.extension.runtime.recorder;

import es.jorgegueyer.quarkus.observability.extension.runtime.span.processor.TraceSpanProcessor;
import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;

import java.util.function.Function;

@Recorder
public class TraceSpanRecorder {

    public Function<SyntheticCreationalContext<TraceSpanProcessor>, TraceSpanProcessor> traceSpanProcessorForObservability() {
        return new Function<>() {
            @Override
            public TraceSpanProcessor apply(SyntheticCreationalContext<TraceSpanProcessor> traceSpanProcessorSyntheticCreationalContext) {
                return new TraceSpanProcessor();
            }
        };
    }
}
