package com.cykj.hospitalsystem.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LogMapper {
    int add(Map<String, Object> map);
}
