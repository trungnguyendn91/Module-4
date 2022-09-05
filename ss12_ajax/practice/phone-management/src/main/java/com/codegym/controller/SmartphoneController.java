package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;


    @GetMapping("/list")
    public ResponseEntity<Page<Smartphone>> showAllSmartphone(@PageableDefault (value = 3)
                                                                          Pageable pageable){
        Page<Smartphone> smartphonePage = this.smartphoneService.findAll(pageable);
        if (!smartphonePage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Smartphone phone){
        smartphoneService.save(phone);
        return new ResponseEntity<>(smartphoneService.findAll(Pageable.unpaged()), HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Integer id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

}
