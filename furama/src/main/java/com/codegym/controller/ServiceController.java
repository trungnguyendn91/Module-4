package com.codegym.controller;

import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IRentTypeService;
import com.codegym.service.facility.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

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
    public String showFacility (Model model, @RequestParam Optional<String> key,
                                @PageableDefault(size = 5) Pageable pageable){
      String keyword = key.orElse("");
    model.addAttribute("facilityList", facilityService.findByFacilityName(keyword, pageable));
    model.addAttribute("keyFacilityWord", keyword);
    model.addAttribute("rentType", rentTypeService.findAll());
    model.addAttribute("serviceType",serviceTypeService.findAll());
    return "/service/list_service";
  }
  @GetMapping ("/addService")
    public String goFormAddService(Model model){
      model.addAttribute("facilityDto", new FacilityDto());
      model.addAttribute("serviceTypeList", serviceTypeService.findAll());
      model.addAttribute("rentalTypeList", rentTypeService.findAll());
      return "/service/new_service";
  }
  @PostMapping ("/saveService")
  public String addNewService(@ModelAttribute(value = "facilityDto") @Valid FacilityDto facilityDto,
                              BindingResult bindingResult, RedirectAttributes redirect,
                              Model model) {
      new FacilityDto().validate(facilityDto, bindingResult);
      if (bindingResult.hasErrors()) {
          model.addAttribute("serviceTypeList", serviceTypeService.findAll());
          model.addAttribute("rentalTypeList", rentTypeService.findAll());
          return "/service/new_service";
      }
      Facility facility = new Facility();
      BeanUtils.copyProperties(facilityDto, facility);
      facilityService.save(facility);
      redirect.addFlashAttribute("messService", "Thêm mới thành công");
      return "redirect:/facility/";
  }
    @GetMapping("/editService")
    public String showEditForm(@RequestParam Integer id, Model model) {
        Facility facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentTypeService.findAll());
        return "/service/edit_service";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute(value = "facilityDto") @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirect, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            model.addAttribute("rentalTypeList", rentTypeService.findAll());
            return "/service/edit_service";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("messService", "Thay đổi thành công");
        return "redirect:/facility/";
    }
    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Integer id, RedirectAttributes redirect){
        facilityService.delete(id);
        redirect.addFlashAttribute("messService", "Xóa thành công");
        return "redirect:/facility/";
    }

    @GetMapping("/showRom")
    public String showRom(){
        return "service/list_room";
    }


    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        return "/service/detail";
    }
}
