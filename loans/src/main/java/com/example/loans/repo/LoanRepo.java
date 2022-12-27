package com.example.loans.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loans.models.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer>{
    
    List<Loan> findByCustomerId(int customerId);
    
}
