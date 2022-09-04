package com.spring.cassandra.api.controller;

import com.spring.cassandra.api.model.UserDetail;
import com.spring.cassandra.api.repository.ReactiveUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
@RequiredArgsConstructor
public class ReactiveUserController {

	private final ReactiveUserRepository userRepository;

	@GetMapping("/getUserBId/{id}")
	public Mono<UserDetail> getUserById(@PathVariable Integer id) {
		return userRepository.findById(id);
	}

	@PostMapping("/saveUser")
	public Mono<UserDetail> saveUserDetail(@RequestBody UserDetail userDetail) {
		return userRepository.save(userDetail);
	}


}
