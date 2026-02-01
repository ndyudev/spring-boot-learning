package com.ndyudev.lab6.service;

import com.ndyudev.lab6.common.BaseService;
import com.ndyudev.lab6.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService extends BaseService<Account, String> {
}
