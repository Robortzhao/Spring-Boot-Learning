package com.springbootlearning.mybatis.controller;


import com.springbootlearning.mybatis.entity.Account;
import com.springbootlearning.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhaoyanhai
 * @date 2019-10-02
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/addAccount",method = RequestMethod.POST)
    //@PostMapping("/addAccount")
    public String addAccount(@RequestParam(value = "name")String name,@RequestParam(value ="money")double money){
        int result = accountService.add(name,money);
        if(result==1){
            return "success!";
        }else{
            return "fail!";
        }
    }

    @RequestMapping(value ="/deleteAccount",method = RequestMethod.DELETE)
    public String deleteAccount(@RequestParam(value = "id")int id){
        int result= accountService.delete(id);
        if(result==1){
            return "success!";
        }else{
            return "fail!";
        }
    }

    @RequestMapping(value = "/selectAccountList", method = RequestMethod.GET)
    public List<Account> selectAccountList() {
        return accountService.selectAccountList();
    }

    @RequestMapping(value = "/selectAccountById", method = RequestMethod.GET)
    public Account selectAccountById(@RequestParam(value = "id")int id) {
        return accountService.selectAccountById(id);
    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
    public String updateAccount(@RequestParam(value = "id")int id, @RequestParam(value = "name") String name,
                                @RequestParam(value = "money") double money) {
        int result= accountService.update(name,money,id);
        if(result==1){
            return "success!";
        }else{
            return "fail!";
        }
    }



}
