package com.ndyudev.lab7.service;

import com.ndyudev.lab7.common.BaseService;
import com.ndyudev.lab7.model.Account;
import com.ndyudev.lab7.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService extends BaseService<Account, String> {

}
