# Developer notes and guides

## Tips and Tricks

### List of Classes

1. io.quarkus.runtime.logging.LogMetricsHandler
2. io.quarkus.runtime.logging.LogMetricsHandlerRecorder
3. io.quarkus.deployment.builditem.LogHandlerBuildItem
4. io.quarkus.runtime.logging.LoggingSetupRecorder
5. io.quarkus.deployment.logging.LoggingResourceProcessor
6. io.quarkus.builder.item.SimpleBuildItem.LoggingSetupBuildItem
7. io.quarkus.opentelemetry.runtime.exporter.otlp.OTelExporterRecorder
8. io.quarkus.opentelemetry.runtime.exporter.otlp.tracing.LateBoundBatchSpanProcessor
9. io.opentelemetry.exporter.otlp.internal.OtlpConfigUtil
10. io.opentelemetry.sdk.trace.export.SpanExporter
11. io.opentelemetry.sdk.trace.export.MultiSpanExporter
12. io.opentelemetry.exporter.otlp.internal.OtlpSpanExporterProvider
13. io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter
14. io.quarkus.opentelemetry.runtime.exporter.otlp.tracing.VertxHttpSpanExporter
15. io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider
