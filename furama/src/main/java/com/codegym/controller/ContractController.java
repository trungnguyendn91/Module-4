package com.codegym.controller;


import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.contract.IDetailContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        model.addAttribute("detailContract", new Contract());
        model.addAttribute("attachFacilityList", new AttachService());
        model.addAttribute("customerList", customerService.findAllByName(keyword, pageable));
        model.addAttribute("facilityList", facilityService.findByFacilityName(keyword, pageable));
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        return "contract/contract_list";
    }
    @GetMapping("showListAttach/{id}")
    public String showListAttach(@PageableDefault(value = 5) Pageable pageable,
                                 @PathVariable int id, Model model) {
        model.addAttribute("contract", contractService.totalMoneyContract(pageable));
        model.addAttribute("detailContract", new Contract());
        model.addAttribute("attachFacilityList", attachFacilityService.findAllById(id));
        model.addAttribute("customerList", customerService.findAll(pageable));
        model.addAttribute("facilityList", facilityService.findAll(pageable));
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        model.addAttribute("flag", 1);
        return "contract/contract_list";
    }
    @GetMapping("showCreate")
    public String showCreate(Model model, Pageable pageable) {
        model.addAttribute("detailContract", new Contract());
        model.addAttribute("customerList", customerService.findAll(pageable));
        model.addAttribute("facilityList", facilityService.findAll(pageable));
        return "contract/contract_list";
    }
    @PostMapping("createContract")
    public ResponseEntity<?> create(@RequestBody Contract contract) {
        contractService.create(contract);
        List<Contract> contracts = contractService.findAllContract();
        int idContract = 0;
        for (Contract item : contracts) {
            idContract = item.getIdContract();
        }
        return new ResponseEntity(idContract, HttpStatus.OK);
    }
}
