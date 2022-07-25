package com.example.flyway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    COMMON(1), ADMIN(2);

    private static Map<String, RoleEnum> map = new LinkedHashMap<>();

    static {
        for (RoleEnum value: values()){
            map.put(value.name(), value);
        }
    }

    public static RoleEnum getRole(String description){
        return map.get(description);
    }

    private Integer code;
}
