package com.spring.cassandra.api.repository;

import com.spring.cassandra.api.model.UserDetail;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserSyncRepository extends CassandraRepository<UserDetail,Integer> {
    UserDetail findTopById(Integer id);
}
