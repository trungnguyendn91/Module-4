package com.codegym.controller;


import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.contract.IDetailContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@CrossOrigin
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;
    @Autowired
    IDetailContractService detailContractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("contract")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable,
                           @RequestParam Optional<String> key,
                           Model model) {
        String keyword = key.orElse("");
        model.addAttribute("contract", contractService.totalMoneyContract(pageable));
        model.addAttribute("customerList", customerService.findAllByName(keyword, pageable));
        model.addAttribute("facilityList", facilityService.findByFacilityName(keyword));
        model.addAttribute("attachFacilityList", attachFacilityService.findAllAttachFacility());
        model.addAttribute("detailContractList", detailContractService.findAll());
        return "contract/contract_list";
    }
}
