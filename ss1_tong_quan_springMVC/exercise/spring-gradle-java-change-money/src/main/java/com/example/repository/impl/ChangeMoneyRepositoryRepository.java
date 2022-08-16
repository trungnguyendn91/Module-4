package com.example.repository.impl;

import com.example.repository.IChangeMoneyRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyRepositoryRepository implements IChangeMoneyRepository {
    @Override
    public int changeMoney(int usd) {
        int result = usd * 23000;
        return result;
    }
}
