package es.jorgegueyer.quarkus.observability.extension.runtime.handler;

import org.jboss.logging.Logger;
import org.jboss.logmanager.ExtHandler;


import java.util.logging.LogRecord;

public class KafkaHandler extends ExtHandler {

    Logger LOGGER = Logger.getLogger(KafkaHandler.class.getName());

    public KafkaHandler() {

    }

    @Override
    public void publish(LogRecord record) {
        LOGGER.info("KafkaHandler - publish");
        super.publish(record);
    }
}
