package io.lab.springdatalab.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.lab.springdatalab.model.user.User;
import io.lab.springdatalab.model.user.UserDto;
import io.lab.springdatalab.security.SecurityConstants;
import io.lab.springdatalab.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/getToken")
    public String login(@RequestBody User user) {

        UserDto userDto = userService.isUserValid(user);

        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .setHeaderParam("typ",SecurityConstants.TOKEN_TYPE)
                .claim("name",userDto.getName())
                .claim("password",userDto.getPasswordHash())
                .claim("role", userDto.getRole())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 30000))
                .compact();

    }
}
