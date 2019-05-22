package com.nowcoder.wendaFreemarker.service;

import org.springframework.stereotype.Service;

@Service
public class WendaService {
    public String getMessge(int userId){
        return "Hello Message:" + String.valueOf(userId);
    }
}
