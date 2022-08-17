package com.example.controller;


import com.example.model.Setting;
import com.example.repository.ISettingEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setting/")
public class SettingEmailController {
    @Autowired
    private ISettingEmailRepository iSettingEmailRepository;
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("setting", new Setting());
        model.addAttribute("language", this.iSettingEmailRepository.language());
        model.addAttribute("pageSize", this.iSettingEmailRepository.pageSize());
        return "/setting/create";
    }

    @RequestMapping(value = "/addSetting", method = RequestMethod.POST)
    public String submit(@ModelAttribute("setting") Setting setting, ModelMap model) {
        model.addAttribute("language",setting.getLanguage());
        model.addAttribute("pageSize",setting.getPageSize());
        model.addAttribute("spamsFilter", setting.isSpamFilter());
        model.addAttribute("signature", setting.getSignature());
        model.addAttribute("setting", new Setting());
        return "/setting/info";
    }

}
