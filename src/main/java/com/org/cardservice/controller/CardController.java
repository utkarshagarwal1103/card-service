package com.org.cardservice.controller;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.model.Card;
import com.org.cardservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class CardController {

    @Autowired
    private CardService cardService;

@PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> addCardDetails(
        HttpServletRequest request,
        @Valid @RequestBody CardDetailRequest cardDetailRequest) throws Exception {
    cardService.addCard(cardDetailRequest);
    return new ResponseEntity<>(HttpStatus.OK);

}

    @GetMapping("/getcardlist")
    public ResponseEntity<List<Card>> getTeam(){
        List<Card> cardListResponse = cardService.getAllCardList();
        return new ResponseEntity<>(cardListResponse,HttpStatus.OK);
    }

}
