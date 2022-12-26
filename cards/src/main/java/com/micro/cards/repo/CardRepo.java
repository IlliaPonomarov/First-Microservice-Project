package com.micro.cards.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micro.cards.models.Card;
import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<Card, Long>{
    
    List<Card> findByCustomerId(Long customerId);

}
