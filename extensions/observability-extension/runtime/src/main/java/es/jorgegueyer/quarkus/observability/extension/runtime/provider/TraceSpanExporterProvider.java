package es.jorgegueyer.quarkus.observability.extension.runtime.provider;

import es.jorgegueyer.quarkus.observability.extension.runtime.span.exporter.TraceSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.internal.AutoConfigureListener;
import io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider;
import io.opentelemetry.sdk.trace.export.SpanExporter;

import java.util.List;

public class TraceSpanExporterProvider implements ConfigurableSpanExporterProvider, AutoConfigureListener {

    @Override
    public void afterAutoConfigure(OpenTelemetrySdk openTelemetrySdk) {

    }

    @Override
    public SpanExporter createExporter(ConfigProperties configProperties) {
        List<String> broker_list = configProperties.getList("log.handler.kafka.broker-list");
        return new TraceSpanExporter(broker_list);
    }

    @Override
    public String getName() {
        return "";
    }
}
