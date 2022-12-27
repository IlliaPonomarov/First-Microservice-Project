package com.example.loans.services;

import java.util.List;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.example.loans.models.Loan;
import com.example.loans.repo.LoanRepo;

@Service
@Transactional(readOnly = true)
public class LoanService {

    private final LoanRepo loanRepo;

    @Autowired
    public LoanService(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    public List<Loan> findAll() {
        return loanRepo.findAll();
    }

    public Optional<Loan> findById(int id) {
        return loanRepo.findById(id);
    }

    public List<Loan> findLoansByCustomerId(int customerId) {
        return loanRepo.findByCustomerId(customerId);
    }

    @Transactional
    public Loan save(Loan loan) {

        loan.setCreateDt(new Date());

        return loanRepo.save(loan);
    }

    @Transactional
    public void deleteById(int id) {
        loanRepo.deleteById(id);
    }
    
}
