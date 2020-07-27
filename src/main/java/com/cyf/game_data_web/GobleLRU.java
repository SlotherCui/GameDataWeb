package com.cyf.game_data_web;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GobleLRU {
    private HashMap<String,String> LRU = new HashMap();

    public GobleLRU(){

    }

    public void set(String k, String v){
        LRU.put(k,v);
    }

    public String get(String k){
        return LRU.get(k);
    }
}
