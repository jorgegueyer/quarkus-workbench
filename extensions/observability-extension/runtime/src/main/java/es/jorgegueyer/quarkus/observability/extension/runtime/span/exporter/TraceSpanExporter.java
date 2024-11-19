package es.jorgegueyer.quarkus.observability.extension.runtime.span.exporter;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.jboss.logging.Logger;

import java.util.Collection;
import java.util.List;

public class TraceSpanExporter implements SpanExporter {

    private final static Logger LOGGER = Logger.getLogger(TraceSpanExporter.class.getName());

    private final List<String> broker_list;

    public TraceSpanExporter(final List<String> broker_list) {
        this.broker_list = broker_list;
    }

    @Override
    public CompletableResultCode export(Collection<SpanData> spans) {
        spans.forEach(spanData -> {
            LOGGER.info(String.format("TraceSpanExporter - export - traceId: %s, parentSpanId: %s, spanId: %s, kind: %s",
                    spanData.getTraceId(),
                    spanData.getParentSpanId(),
                    spanData.getSpanId(),
                    spanData.getKind()));
        });
        this.broker_list.forEach(host -> LOGGER.info(String.format("export - broker: %s", host)));
        return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
