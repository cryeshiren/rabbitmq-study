package com.grapecity.grapeleaf.controller;

import com.grapecity.grapeleaf.service.SenderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Noah
 */

@RestController
public class SenderController {

    @Resource
    private SenderService senderService;

    @RequestMapping("/send")
    public String send(){
        try {
            senderService.publishMessage("Sender test messge");

            return "Sender success";
        } catch (Exception e) {
            return "Sender failed";
        }
    }
}
