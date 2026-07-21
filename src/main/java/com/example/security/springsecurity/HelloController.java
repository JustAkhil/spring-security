package com.example.security.springsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @GetMapping("/user/hello")
    public String sayAdminHello(){
        return "Hello User";
    }

    @GetMapping("/admin/hello")
    public String sayUserHello(){
        return "Hello Admin";
    }

}
