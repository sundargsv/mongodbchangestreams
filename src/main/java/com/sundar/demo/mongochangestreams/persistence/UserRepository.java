package com.sundar.demo.mongochangestreams.persistence;

import com.sundar.demo.mongochangestreams.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sundar Gsv
 * @Date 18/11/18
 * @ClassDescription
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String>{
}
