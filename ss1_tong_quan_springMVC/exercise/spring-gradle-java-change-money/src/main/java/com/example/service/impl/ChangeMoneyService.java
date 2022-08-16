package com.example.service.impl;

import com.example.repository.IChangeMoneyRepository;
import com.example.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyService implements IChangeMoneyService {
    @Autowired
    private IChangeMoneyRepository iChangeMoneyRepository;
    @Override
    public int changeMoney(int usd) {
        return iChangeMoneyRepository.changeMoney(usd);
    }
}
