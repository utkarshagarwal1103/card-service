package com.org.cardservice.service;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.exception.CardException;
import com.org.cardservice.model.Card;

import java.util.List;

public interface CardService {

    public List<Card> getAllCardList();

    public void addCard(CardDetailRequest cardDetailRequest) throws CardException;
}
