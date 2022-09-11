package com.codegym.service.contract.impl;

import com.codegym.model.contract.DetailContract;
import com.codegym.repository.IDetailContractRepository;
import com.codegym.service.contract.IDetailContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailContractService implements IDetailContractService {
    @Autowired
    IDetailContractRepository detailContractRepository;
    @Override
    public List<DetailContract> findAll() {
        return detailContractRepository.findAll();
    }

    @Override
    public DetailContract save(DetailContract detailContract) {
        return detailContractRepository.save(detailContract);
    }
}
