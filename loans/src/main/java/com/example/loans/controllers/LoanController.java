package com.example.loans.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loans.models.Loan;
import com.example.loans.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Loan>> findAll() {
        return ResponseEntity.ok(loanService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable int id) {

        Optional<Loan> loan = loanService.findById(id);

        if (loan.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        

        return ResponseEntity.ok(loanService.findById(id).get());
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Loan>> findLoansByCustomerId(@PathVariable int id) {

        List<Loan> loans = loanService.findLoansByCustomerId(id);

        if (loans.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        

        return ResponseEntity.ok(loanService.findLoansByCustomerId(id));
    }
    
}
