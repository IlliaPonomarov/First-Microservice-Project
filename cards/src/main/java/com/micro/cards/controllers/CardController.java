package com.micro.cards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.micro.cards.models.Card;
import com.micro.cards.services.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {
    
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Card>> findAll() {
        System.out.println(cardService.findAll().toString());
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        Optional<Card> card = cardService.findById(id);

        if (card.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        System.out.println(card.get().toString());
        return new ResponseEntity<>(card.get(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Card>> getCardsByCustomerId(@PathVariable Long customerId) {
        List<Card> cards = cardService.getCardsByCustomerId(customerId);

        if (cards.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);



        
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
