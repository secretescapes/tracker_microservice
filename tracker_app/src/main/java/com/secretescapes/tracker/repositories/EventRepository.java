package com.secretescapes.tracker.repositories;

import com.secretescapes.tracker.domains.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

	List<Event> findByType(String type);

	List<Event> findByTypeAndDateGreaterThan(String type, Date date);

	List<Event> findByTypeAndDateBetween(String type, Date startDate, Date endDate);

	List<Event> findByUserId(int id);

}