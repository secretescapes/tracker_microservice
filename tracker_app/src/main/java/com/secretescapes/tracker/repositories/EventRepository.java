package com.secretescapes.tracker.repositories;

import com.secretescapes.tracker.domains.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {


}