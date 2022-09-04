package com.spring.cassandra.api.controller;

import com.spring.cassandra.api.model.UserDetail;
import com.spring.cassandra.api.repository.UserSyncRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
public class AsyncUserController {


    private final UserSyncRepository userSyncRepository;

    @GetMapping("/getUserBId/{id}")
    public CompletableFuture<UserDetail> getUserById(@PathVariable Integer id) {
       return CompletableFuture.supplyAsync(()-> userSyncRepository.findById(id).orElse(null));
    }

    @PostMapping("/saveUser")
    public CompletableFuture<UserDetail> saveUserDetail(@RequestBody UserDetail userDetail) {
        return CompletableFuture.supplyAsync(() -> userSyncRepository.save(userDetail));
    }
}
