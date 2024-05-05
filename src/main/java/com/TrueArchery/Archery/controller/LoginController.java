package com.TrueArchery.Archery.controller;

import com.TrueArchery.Archery.domain.user.AuthenticationDTO;
import com.TrueArchery.Archery.domain.user.User;
import com.TrueArchery.Archery.domain.user.UserService;
import com.TrueArchery.Archery.infra.security.JWTTokenDTO;
import com.TrueArchery.Archery.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid AuthenticationDTO data){

        userService.saveUser(data);

        return ResponseEntity.ok().build();
        
    }

    @PostMapping
    public ResponseEntity<JWTTokenDTO> authenticationUser(@RequestBody @Valid AuthenticationDTO data){
        Authentication authToken = new UsernamePasswordAuthenticationToken(data.login(),data.password());

        var userAuthenticated= authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generateToken((User) userAuthenticated.getPrincipal());

        return ResponseEntity.ok(new JWTTokenDTO(JWTToken));
    }


}
