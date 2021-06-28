package com.org.cardservice.repository;

import com.org.cardservice.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card,Long> {
}
