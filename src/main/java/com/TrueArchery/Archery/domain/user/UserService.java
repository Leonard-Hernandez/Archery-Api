package com.TrueArchery.Archery.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueArchery.Archery.infra.security.EncryptServiceImpl;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EncryptServiceImpl encryptService;

    public void saveUser(@Valid AuthenticationDTO data) {
        
        String login = data.login();
        String password = encryptService.encrypt(data.password());

        User user = new User(login, password);

        userRepository.save(user);

    }



}
