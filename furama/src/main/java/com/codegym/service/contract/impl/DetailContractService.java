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
    public List<DetailContract> finAllByIDContract(Integer id) {
        return detailContractRepository.findAllByContract_IdContract(id);
    }

    @Override
    public void create(DetailContract detailContract) {
        detailContractRepository.save(detailContract);
    }
}
