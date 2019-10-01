package com.springbootlearning.jpa.controller;


import com.springbootlearning.jpa.entity.Account;
import com.springbootlearning.jpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-01
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 新增一个账户信息
     *
     * @param name
     * @param money
     * @return
     */
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name") String name, @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        return accountService.add(account).toString();
    }

    /**
     * 更新指定账户信息
     *
     * @param id
     * @param name
     * @param money
     * @return
     */
    @RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
    public String updateAccount(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
                                @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        return accountService.update(account).toString();

    }

    /**
     * 删除指定账户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteAccount", method = RequestMethod.DELETE)
    public void deleteAccount(@RequestParam(value = "id") int id) {
        accountService.delete(id);
    }

    /**
     * 查询所有账户信息
     *
     * @return
     */
    @RequestMapping(value = "/selectAccountList", method = RequestMethod.GET)
    public List<Account> selectAccountList() {
        return accountService.selectAccountList();
    }

    /**
     * 通过Id查询账户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAccountById", method = RequestMethod.GET)
    public Account getAccountById(@RequestParam(value = "id") int id) {
        return accountService.selectAccountById(id);
    }

}
