package com.example.informationsystem.controller;

import com.example.informationsystem.dto.RequestResponse;
import com.example.informationsystem.entity.Users;
import com.example.informationsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/auth/register")
    public ResponseEntity<RequestResponse> register(@RequestBody RequestResponse reg){
        return ResponseEntity.ok(usersService.register(reg));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<RequestResponse> login(@RequestBody RequestResponse req){
        return ResponseEntity.ok(
                usersService.login(req));
    }

    @GetMapping("/homepage/get-profile")
    public ResponseEntity<RequestResponse> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        RequestResponse response = usersService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/admin/users-list")
    public ResponseEntity<RequestResponse> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers());

    }

    @GetMapping("/admin/get-users-list/{userId}")
    public ResponseEntity<RequestResponse> getUSerByID(@PathVariable Long userId){
        return ResponseEntity.ok(usersService.getUsersById(userId));

    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<RequestResponse> updateUser(@PathVariable Long userId, @RequestBody Users reqres){
        return ResponseEntity.ok(usersService.updateUser(userId, reqres));
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<RequestResponse> deleteUser(@PathVariable Long userId){
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }
    @PostMapping("/auth/refresh")
    public ResponseEntity<RequestResponse> refreshToken(@RequestBody RequestResponse req){
        return ResponseEntity.ok(usersService.refreshToken(req));
    }

}
