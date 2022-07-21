package com.example.event.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AuditEvent<T> extends ApplicationEvent {

    private T data;

    public AuditEvent(T event) {
        super(event);
    }
}
