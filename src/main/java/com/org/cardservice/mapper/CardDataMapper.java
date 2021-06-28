package com.org.cardservice.mapper;

import com.org.cardservice.domain.CardDetailRequest;
import com.org.cardservice.model.Card;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface CardDataMapper {

    Card cardDetailMapperRequest(CardDetailRequest card);

}
