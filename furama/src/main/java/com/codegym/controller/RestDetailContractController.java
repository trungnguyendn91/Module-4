package com.codegym.controller;

import com.codegym.model.contract.DetailContract;
import com.codegym.service.contract.IDetailContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restDetailContract")
public class RestDetailContractController {
    private IDetailContractService detailContractService;
    @GetMapping("/list/{id}")
    public ResponseEntity<List<DetailContract>> getAllContractDetail(@PathVariable Integer id ){
        List<DetailContract> contractDetails = this.detailContractService.finAllByIDContract(id);
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetails , HttpStatus.OK);
    }
}
