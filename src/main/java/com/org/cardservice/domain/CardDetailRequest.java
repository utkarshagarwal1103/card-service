package com.org.cardservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CardDetailRequest implements Serializable {
    @JsonProperty(value="name" ,required=true)
    @NotNull @NotEmpty
    String name;

    @JsonProperty(value="creditCardNumber" ,required=true)
    @NotNull @NotEmpty
    String creditCardNumber;

    @JsonProperty(value="limit" ,required=true)
    @NotNull @PositiveOrZero
    long limit;

}
