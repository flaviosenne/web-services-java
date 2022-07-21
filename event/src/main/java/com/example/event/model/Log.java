package com.example.event.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class Log {

    private Map<String, String> data;
}
