package com.example.logisticks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.logisticks.dao.UserDAO;
import com.example.logisticks.requests.SignInRequest;
import com.example.logisticks.requests.SignUpRequest;
import com.example.logisticks.responses.SignInResponse;
import com.example.logisticks.responses.UserDeetResponse;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserDAO uDAO;

    @PostMapping("/auth/signup")
    public SignInResponse signUp(@RequestBody SignUpRequest req){
        SignInResponse res = new SignInResponse();
        int key = uDAO.signUp(req.getPhoneNumber(), req.getPassword(), req.getName(), req.getHouseNumber(), req.getLocality(), req.getLocationId());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        System.out.println("3:signup");
        return res;
    }
    @PostMapping("/auth/signin")
    public SignInResponse signIn(@RequestBody SignInRequest req){
        SignInResponse res = new SignInResponse();
        int key =  uDAO.signIn(req.getPhoneNumber(), req.getPassword());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        System.out.println("4:signin");
        return res;
    }

    @GetMapping("/user/{phoneNumber}")
    public UserDeetResponse getUserLocation(@PathVariable String phoneNumber){
        return uDAO.getUserLocation(phoneNumber);
    }
}
