package com.example.event.events;

import com.example.event.model.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler {

    @SneakyThrows
    @EventListener
    @Async
    public void handlerEvent(AuditEvent<Log> auditEvent){
        System.out.println(new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(auditEvent));
    }
}
