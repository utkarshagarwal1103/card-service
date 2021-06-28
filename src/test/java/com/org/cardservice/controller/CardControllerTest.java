package com.org.cardservice.controller;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.service.impl.CardServiceImpl;
import com.org.cardservice.utility.MockObjectUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardServiceImpl cardService;



    @Test
    public void shouldReturnCardDetailListWhenValidRequestisMade() throws Exception {
        Mockito.when(cardService.getAllCardList()).thenReturn(MockObjectUtility.getMockCardList());
        final  String expected = "[{\"id\":1,\"name\":\"testUser1\"," +
                "\"creditCardNumber\":\"12345674\",\"balance\":12,\"limit\":1000}]";

        RequestBuilder request = MockMvcRequestBuilders
                .get("/getcardlist")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    public void shouldReturnSuccessResponseWhenValidCardAdded() throws Exception{

        doNothing().when(cardService).addCard(Mockito.any(CardDetailRequest.class));

        final  String requestJson = "{\"name\":\"testUser1\"," +
                "\"creditCardNumber\":\"12345674\",\"limit\":1000}";

        RequestBuilder request = MockMvcRequestBuilders
                .post("/add")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());

    }

    @Test
    public void shouldReturnBadRequestResponseWhenRequestIsNotProper() throws Exception{

        doNothing().when(cardService).addCard(Mockito.any(CardDetailRequest.class));

        final  String requestJson = "{\"creditCardNumber\":\"12345674\",\"limit\":1000}";

        RequestBuilder request = MockMvcRequestBuilders
                .post("/add")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());

    }
}
