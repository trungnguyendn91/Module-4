package com.example.controller;
import com.example.model.Person;
import com.example.repository.IPersonRepository;
import com.example.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/setting/")
public class MedicalDeclarationController {
    @Autowired
    private IPerson iPerson;
    @RequestMapping(value = "/showList", method = RequestMethod.GET)
    public String showList (ModelMap modelMap){
        modelMap.addAttribute("personList", this.iPerson.findAll());
        return "/setting/list";
    }


    @RequestMapping(value = "/updateList", method = RequestMethod.GET)
    public String update (@RequestParam int id, Model model){
        List<String> yearList = iPerson.year();
        List<String> dayList = iPerson.day();
        List<String> monthList = iPerson.month();
        List<String> genderList = iPerson.gender();
        List<String> nationList = iPerson.nationality();
        List<String> vehicleList = iPerson.informationVehicle();
        Person person = iPerson.findById(id);
        model.addAttribute("person", person);
        model.addAttribute("yearList", yearList);
        model.addAttribute("dayList", dayList);
        model.addAttribute("monthList", monthList);
        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("vehicleList", vehicleList);
        return "/setting/update";
    }
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("medical", new Person());
        model.addAttribute("day", this.iPerson.day());
        model.addAttribute("year", this.iPerson.year());
        model.addAttribute("month", this.iPerson.month());
        model.addAttribute("gender", this.iPerson.gender());
        model.addAttribute("nationality", this.iPerson.nationality());
        model.addAttribute("informationVehicle", this.iPerson.informationVehicle());
        return "/setting/create";
    }
    @PostMapping(value = "/save")
    public String createPerson (@ModelAttribute Person person, RedirectAttributes redirectAttributes){
        this.iPerson.save(person);
        redirectAttributes.addFlashAttribute("msg","Register successfully!");
        return "redirect:/setting/showList";
    }

    @PostMapping(value ="/update")
    public String update(@ModelAttribute Person person){
        iPerson.update(person);
        return "redirect:/setting/showList";

    }


    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String detail(@ModelAttribute("setting") Person declaration, ModelMap model) {
        model.addAttribute("declaration",declaration);
        model.addAttribute("setting", new Person());
        return "/setting/info";
    }

}
