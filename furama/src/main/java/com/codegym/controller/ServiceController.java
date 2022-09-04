package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IRentTypeService;
import com.codegym.service.facility.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/facility")
public class ServiceController {
  @Autowired
    private IFacilityService facilityService;
  @Autowired
    private IRentTypeService rentTypeService;
  @Autowired
    private IServiceTypeService serviceTypeService;

  @GetMapping (value = {"", "/search"})
    public String showFacility (Model model){
    model.addAttribute("facilityList", facilityService.findAll());
    model.addAttribute("rentType", rentTypeService.findAll());
    model.addAttribute("serviceType",serviceTypeService.findAll());
    return "/service/list_service";
  }
  @GetMapping ("/addService")
    public String goFormAddService(Model model){
      model.addAttribute("facility", new Facility());
      model.addAttribute("serviceTypeList", serviceTypeService.findAll());
      model.addAttribute("rentalTypeList", rentTypeService.findAll());
      return "/service/new_service";
  }
  @PostMapping ("/saveService")
  public String addNewService(@ModelAttribute Facility facility) {
      facilityService.save(facility);
      return "redirect:/facility/";
  }
    @GetMapping("/editService")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentTypeService.findAll());
        return "/service/edit_service";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/";
    }
    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Integer id){
        facilityService.delete(id);
        return "redirect:/facility/";
    }

    @GetMapping("/showRom")
    public String showRom(){
        return "service/list_room";
    }

}
