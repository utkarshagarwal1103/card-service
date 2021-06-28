package com.org.cardservice.service;


import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.exception.CardException;
import com.org.cardservice.mapper.CardDataMapper;
import com.org.cardservice.model.Card;
import com.org.cardservice.repository.CardRepository;
import com.org.cardservice.service.impl.CardServiceImpl;
import com.org.cardservice.utility.MockObjectUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @Mock
    private CardDataMapper cardDataMapper;

    @Mock
    private Iterable<Card> cardData;

    @InjectMocks
    private CardServiceImpl cardService;


    @BeforeTestClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCardListWhenDBHoldsData() {
        cardData = MockObjectUtility.getMockCardList();
        when(cardRepository.findAll()).thenReturn(cardData);
        Assert.assertEquals(cardService.getAllCardList(), cardData);

    }

    @Test
    public void shouldSaveCardDataWhenValidCardDetailProvided() {
        when(cardRepository.save(any(Card.class))).thenReturn(MockObjectUtility.getMockCard());
        long id = 1;
        when(cardDataMapper.cardDetailMapperRequest(any(CardDetailRequest.class)))
                .thenReturn(MockObjectUtility.getMockCard());
        cardService.addCard(MockObjectUtility.getCardDetailRequest());
        verify(cardRepository, times(1)).save(any(Card.class));

    }

    @Test(expected = CardException.class)
    public void shouldThrowExceptionWhenInValidCardDetailProvided() {
        cardService.addCard(MockObjectUtility.getInValidCardDetailRequest());
    }


}
