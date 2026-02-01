package com.ndyudev.lab6.controller;

import com.ndyudev.lab6.model.Account;
import com.ndyudev.lab6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lab6/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/index")
    public String index(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("items", accountService.findAll());
        return "lab6/account/AccountManager";
    }

    @GetMapping("/edit/{username}")
    public String edit(@PathVariable("username") String username, Model model) {
        Account account = accountService.findById(username);
        model.addAttribute("account", account);
        model.addAttribute("items", accountService.findAll());
        return "lab6/account/AccountManager";
    }

    @PostMapping("/create")
    public String create(Account account, Model model) {
        accountService.save(account);
        model.addAttribute("message", "Thêm tài khoản thành công!");
        return "redirect:/lab6/account/index";
    }

    @PostMapping("/update")
    public String update(Account account, Model model) {
        accountService.save(account);
        model.addAttribute("message", "Cập nhật thành công!");
        return "redirect:/lab6/account/edit/" + account.getUsername();
    }

    @PostMapping("/delete")
    public String delete(Account account, Model model) {
        try {
            accountService.delete(account.getUsername());
            model.addAttribute("message", "Xóa thành công!");
        } catch (Exception e) {
            model.addAttribute("message", "Không thể xóa tài khoản này!");
        }
        return "redirect:/lab6/account/index";
    }
}