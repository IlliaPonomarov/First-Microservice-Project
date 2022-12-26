package com.micro.cards.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.cards.models.Card;
import com.micro.cards.repo.CardRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CardService {
    
    private CardRepo cardRepo;

    @Autowired
    public CardService(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public List<Card> findAll() {
        return cardRepo.findAll();
    }

    public Optional<Card> findById(Long cardId) {
        return cardRepo.findById(cardId);
    }

    public List<Card> getCardsByCustomerId(Long customerId) {
        return cardRepo.findByCustomerId(customerId);
    }

    @Transactional
    public Card save(Card card) {
        return cardRepo.save(card);
    }

    @Transactional
    public void deleteCardById(Long cardId) {
        cardRepo.deleteById(cardId);
    }

}
