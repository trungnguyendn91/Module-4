package com.codegym.controller;

import com.codegym.dto.FormDTO;
import com.codegym.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class FormController {
    @Autowired
    private IFormService formService;
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("form", new FormDTO());
        return "create_form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("form") @Valid FormDTO formDTO,
                         BindingResult bindingResult,
                         Model model){
        new FormDTO().validate(formDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "create_form";
        }
        model.addAttribute("mess", "Tạo thành công");
        return "result";
    }

}
