package com.spring.cassandra.api.controller;

import com.spring.cassandra.api.model.UserDetail;
import com.spring.cassandra.api.repository.UserSyncRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sync")
@RequiredArgsConstructor
public class SyncUserController {

    private final UserSyncRepository userSyncRepository;

    @GetMapping("/getUserBId/{id}")
    public ResponseEntity<UserDetail> getUserById(@PathVariable Integer id) {
       return new ResponseEntity<>(userSyncRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDetail> saveUserDetail(@RequestBody UserDetail userDetail) {
        return new ResponseEntity<>(userSyncRepository.save(userDetail), HttpStatus.OK);
    }
}
