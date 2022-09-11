package com.codegym.service.contract;

import com.codegym.model.contract.AttachService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IAttachFacilityService {
    List<AttachService> findAllAttachFacility();
}
