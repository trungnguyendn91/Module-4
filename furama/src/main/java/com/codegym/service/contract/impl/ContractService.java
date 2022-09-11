package com.codegym.service.contract.impl;


import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.DetailContract;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.repository.IContractRepository;
import com.codegym.repository.IDetailContractRepository;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Autowired
    private IDetailContractRepository detailContractRepository;


    @Override
    public Page<Contract> findAllContractPage(Pageable pageable) {
        return  contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> totalMoneyContract(Pageable pageable) {
        Page<Contract> contractList = this.findAllContractPage(pageable);
        List<AttachService> attachServiceList = attachServiceRepository.findAll();
        List<DetailContract> detailContractList = detailContractRepository.findAll();
        for (Contract c: contractList){
            double totalDetail = 0;
            double costFacility = 0;
            for (DetailContract dc: detailContractList){
                if (dc.getContract().getIdContract() == c.getIdContract()){
                    for (AttachService as: attachServiceList){
                        if (as.getIdAttachService() == dc.getAttachService().getIdAttachService()){
                            costFacility += as.getCost()*dc.getQuantity();
                        }
                    }
                }
            }
            totalDetail = costFacility + c.getFacility().getFacilityCost();
            c.setTotalMoney(totalDetail);
        }
        return contractList;
    }

    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }
}
