package com.demo.springkafkamongodemo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.springkafkamongodemo.document.User;
import com.demo.springkafkamongodemo.model.UserDto;
import com.demo.springkafkamongodemo.repository.UserRespository;

@Service
public class UserConsumerService {

	@Autowired
	private UserRespository userRepository;
	
	
	@KafkaListener(topics = "spring-kafka-mongodb_demo", groupId = "group_json",
	containerFactory="userKafkaListenerContainerFactory")
	public UserDto users(UserDto user) {
		System.out.println("message succussfully consumed :: "+user);
		User docUsr = new User();
		BeanUtils.copyProperties(user, docUsr);
		System.out.println("inserting data to mongodb :: ");
		userRepository.save(docUsr);
		System.out.println("succussfully inserted data to mongodb :: ");
		Optional<User> docU = userRepository.findById(user.getId());
		System.out.println(docU.get());
		return user;
	}
}
