package com.secretescapes.tracker.repositories;

import com.secretescapes.tracker.domains.TdEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdEventRepository extends MongoRepository<TdEvent, String> {


}