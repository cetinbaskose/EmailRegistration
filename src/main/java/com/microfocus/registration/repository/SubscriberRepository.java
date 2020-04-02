package com.microfocus.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microfocus.registration.entity.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

	List<Subscriber> findAll();
	
	Optional<Subscriber> findByEmailAddress(String emailAdress);
	
	

}
