package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ServiceController {
    @GetMapping("/service")
    public String showService(){
        return "service/list_service";
    }
    @GetMapping("/showRom")
    public String showRom(){
        return "service/list_room";
    }
    @GetMapping("/editService")
    public String showEditService(){
        return "service/edit_service";
    }
    @GetMapping("/addService")
    public String showAddService(){
        return "service/new_service";
    }
    @GetMapping("/contract")
    public String showcontract(){
        return "contract/contract_list";
    }

}
