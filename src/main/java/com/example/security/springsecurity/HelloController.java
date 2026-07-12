package com.example.security.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    private String getHello(){
        return "Hello";
    }

    @GetMapping("/user/hello")
    private String sayAdminHello(){
        return "Hello User";
    }

    @GetMapping("/admin/hello")
    private String sayUserHello(){
        return "Hello Admin";
    }

}
