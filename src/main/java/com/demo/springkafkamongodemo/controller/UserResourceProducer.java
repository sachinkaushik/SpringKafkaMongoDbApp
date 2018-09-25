package com.demo.springkafkamongodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springkafkamongodemo.model.UserDto;
import com.demo.springkafkamongodemo.repository.UserRespository;

@RestController
public class UserResourceProducer {

	@Autowired
	private UserRespository userRepository;
	
	
	@Autowired 
	private KafkaTemplate<String, Object> kafkaTemplate;

    private String kafkaTopic= "spring-kafka-mongodb";

    @PostMapping("/produceUserToKafkaAndSaveToMongo")
    public ResponseEntity<Object> postUser(@RequestBody UserDto user) {
        kafkaTemplate.send(kafkaTopic, user);
        System.out.println("message published to "+kafkaTopic+" topic");
        return new ResponseEntity<Object>("Published and saved successfully", HttpStatus.CREATED);
    }
    
    @GetMapping("/users")
    public ResponseEntity<Object> users(){
    	return new ResponseEntity<Object>(userRepository.findAll(), HttpStatus.OK);
    }
    
}
