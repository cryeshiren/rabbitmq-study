package com.grapecity.grapeleaf.controller;

import com.grapecity.grapeleaf.service.ConsumerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Noah
 */

@RestController
public class ConsumerController {

    @Resource
    private ConsumerService consumerService;

    @RequestMapping("/consumer")
    public void consume(){
        try {
            consumerService.ConsumeMessage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
