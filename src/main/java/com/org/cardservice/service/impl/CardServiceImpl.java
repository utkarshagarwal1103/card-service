package com.org.cardservice.service.impl;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.exception.CardException;
import com.org.cardservice.mapper.CardDataMapper;
import com.org.cardservice.model.Card;
import com.org.cardservice.repository.CardRepository;
import com.org.cardservice.service.CardService;
import com.org.cardservice.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardDataMapper cardDataMapper;


    public List<Card> getAllCardList(){
        List<Card> cardList= new ArrayList<>();
        cardRepository.findAll().forEach(cardList::add);
        return cardList;
    }

    public void addCard(CardDetailRequest cardDetailRequest) throws CardException {
        if(Utility.validateCreditCardNumber(cardDetailRequest.getCreditCardNumber()))
        cardRepository.save(cardDataMapper.cardDetailMapperRequest(cardDetailRequest));
        else
            throw new CardException();
    }

}
