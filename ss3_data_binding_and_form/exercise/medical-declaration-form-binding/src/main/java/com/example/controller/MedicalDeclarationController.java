package com.example.controller;
import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setting/")
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationRepository iMedicalDeclarationRepository;
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("Medical", new MedicalDeclaration());
        model.addAttribute("day", this.iMedicalDeclarationRepository.day());
        model.addAttribute("year", this.iMedicalDeclarationRepository.year());
        model.addAttribute("month", this.iMedicalDeclarationRepository.month());
        model.addAttribute("gender", this.iMedicalDeclarationRepository.gender());
        model.addAttribute("nationality", this.iMedicalDeclarationRepository.nationality());
        model.addAttribute("informationVehicle", this.iMedicalDeclarationRepository.informationVehicle());
        return "/setting/create";
    }

    @RequestMapping(value = "/addSetting", method = RequestMethod.POST)
    public String submit(@ModelAttribute("setting") MedicalDeclaration declaration, ModelMap model) {
        model.addAttribute("name",declaration.getName());
        model.addAttribute("year",declaration.getYear());
        model.addAttribute("startYear",declaration.getStartYear());
        model.addAttribute("endYear",declaration.getEndYear());
        model.addAttribute("gender", declaration.getGender());
        model.addAttribute("nationality", declaration.getNationality());
        model.addAttribute("idCard", declaration.getIdCard());
        model.addAttribute("informationVehicle", declaration.getInformationVehicle());
        model.addAttribute("vehicleNumber", declaration.getVehicleNumber());
        model.addAttribute("seatNumber", declaration.getSeatNumber());
        model.addAttribute("startDay", declaration.getStartDay());
        model.addAttribute("endDay", declaration.getEndDay());
        model.addAttribute("startMonth", declaration.getStartMonth());
        model.addAttribute("endMonth", declaration.getEndMonth());
        model.addAttribute("info", declaration.getInfo());
        model.addAttribute("setting", new MedicalDeclaration());
        return "/setting/info";
    }

}
