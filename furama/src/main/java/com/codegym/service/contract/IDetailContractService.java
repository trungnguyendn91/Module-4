package com.codegym.service.contract;

import com.codegym.model.contract.DetailContract;

import java.util.List;

public interface IDetailContractService {

    List<DetailContract> finAllByIDContract(Integer id);

    void create(DetailContract detailContract);
}
