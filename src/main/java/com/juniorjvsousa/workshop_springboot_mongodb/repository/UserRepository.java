package com.juniorjvsousa.workshop_springboot_mongodb.repository;

import com.juniorjvsousa.workshop_springboot_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
