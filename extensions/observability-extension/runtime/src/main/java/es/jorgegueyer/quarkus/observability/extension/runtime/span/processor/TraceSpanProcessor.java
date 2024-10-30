package es.jorgegueyer.quarkus.observability.extension.runtime.span.processor;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TraceSpanProcessor implements SpanProcessor {

    private static final Logger logger = Logger.getLogger(TraceSpanProcessor.class.getName());

    @Override
    public void onStart(Context parentContext, ReadWriteSpan span) {
        // Callback invoked when span is started.
        // Enrich the record with a custom attribute.
        var spanData = span.toSpanData();
        logger.info(String.format("onStart = traceId: %s, parentSpanId: %s, spanId: %s, kind: %s",
                spanData.getTraceId(),
                spanData.getParentSpanId(),
                spanData.getSpanId(),
                spanData.getKind()));
        span.setAttribute("my.custom.attribute", "hello world");
    }

    @Override
    public boolean isStartRequired() {
        // Indicate if onStart should be called.
        return true;
    }

    @Override
    public void onEnd(ReadableSpan span) {
        // Callback invoked when span is ended.
    }

    @Override
    public boolean isEndRequired() {
        // Indicate if onEnd should be called.
        return false;
    }

    @Override
    public CompletableResultCode shutdown() {
        // Optionally shutdown the processor and cleanup any resources.
        return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode forceFlush() {
        // Optionally process any records which have been queued up but not yet processed.
        return CompletableResultCode.ofSuccess();
    }
}
