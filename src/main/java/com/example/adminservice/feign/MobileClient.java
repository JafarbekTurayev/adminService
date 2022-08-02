package com.example.adminservice.feign;

import com.example.adminservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "mobileclient", url = "${mobile.host}")
public interface MobileClient {

    //ixtiyoriy bitta zapros berasz
    @GetMapping("/product")
    ResponseEntity<?> getAllProducts();

    @PostMapping(value = "/createUser",produces = "application/json")
    ResponseEntity<?> createUser(@RequestHeader("Authorization") String token,
                                 @RequestBody User user);


}
