package com.micro.account.controllers;

import java.util.Optional;

import com.micro.account.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.account.models.Account;
import com.micro.account.services.AccountService;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {

        Optional<Account> account = accountService.findById(id);

        if (account.isEmpty()) {
            return new ResponseEntity("Account does not exist.", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity(account.get(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<String> findByCustomerId(@PathVariable int id) {

        Optional<Account> account = accountService.findByCustomerId(id);

        if (account.isEmpty()) {
            return new ResponseEntity("Account does not exist.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(account.get(), HttpStatus.OK);
    }
    

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Account account, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid account");
        }

        accountService.save(account);
        return ResponseEntity.ok("Account saved");
    }
}
