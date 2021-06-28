package com.org.cardservice.utility;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.model.Card;

import java.util.ArrayList;
import java.util.List;

public class MockObjectUtility {

    public static List<Card> getMockCardList(){
        List<Card> mockCard = new ArrayList<Card>();
        Card card= new Card();
        card.setId(1);
        card.setName("testUser1");
        card.setCreditCardNumber("12345674");
        card.setBalance(12);
        card.setLimit(1000);
        mockCard.add(card);

        return mockCard;
    }


    public static CardDetailRequest getCardDetailRequest(){
        CardDetailRequest cdr= new CardDetailRequest();
        cdr.setName("test1");
        cdr.setCreditCardNumber("12345674");
        cdr.setLimit(1000);
        return cdr;
    }

    public static CardDetailRequest getInValidCardDetailRequest(){
        CardDetailRequest cdr= new CardDetailRequest();
        cdr.setName("test1");
        cdr.setCreditCardNumber("123456");
        cdr.setLimit(1000);
        return cdr;
    }

    public static Card getMockCard(){
        Card card= new Card();
        card.setId(1);
        card.setName("testUser1");
        card.setCreditCardNumber("12345674");
        card.setBalance(12);
        card.setLimit(1000);
        return card;
    }
}
