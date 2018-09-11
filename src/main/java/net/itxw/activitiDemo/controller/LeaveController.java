package net.itxw.activitiDemo.controller;

import net.itxw.activitiDemo.service.LeaveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

@RequestMapping("leave")
public class LeaveController {

    @Resource
    private LeaveService leaveService;

    @RequestMapping("apply")
    public String apply(){
        //leaveService.apply();
        return "applying";
    }

}
