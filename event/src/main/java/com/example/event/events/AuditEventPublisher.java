package com.example.event.events;

import com.example.event.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class AuditEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishEvent(String message) {
        Map<String,String> dataMap = new LinkedHashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        dataMap.put("host", request.getHeader("host"));
        dataMap.put("user-agent", request.getHeader("User-Agent"));
        dataMap.put("message", message);

        eventPublisher.publishEvent(new AuditEvent<Log>(Log.builder().data(dataMap).build()));

    }
}
