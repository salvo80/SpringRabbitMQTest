package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @Autowired
    private Send send;
    @PostMapping("/push")
    public void pushMsg(@RequestBody String msg){
        send.simpleSend(msg);
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
