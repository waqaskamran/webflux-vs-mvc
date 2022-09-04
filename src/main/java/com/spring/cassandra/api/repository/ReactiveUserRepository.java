package com.spring.cassandra.api.repository;

import com.spring.cassandra.api.model.UserDetail;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import reactor.core.publisher.Flux;

public interface ReactiveUserRepository extends ReactiveCassandraRepository<UserDetail, Integer> {

	Flux<UserDetail> findTopById(int id);

}
