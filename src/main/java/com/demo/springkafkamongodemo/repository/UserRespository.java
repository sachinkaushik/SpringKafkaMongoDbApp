package com.demo.springkafkamongodemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.springkafkamongodemo.document.User;

public interface UserRespository extends  MongoRepository<User, Long>{

}
