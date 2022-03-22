package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.mapper.LogMapper;

import com.cykj.hospitalsystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public Map<String, Object> add(Map<String, Object> map) {
        int i = logMapper.add(map);
        if(i>=1){
            //日志插入成功
            map.put("code","1");
        }else{
            map.put("code","0");
        }
        return map;
    }
}
