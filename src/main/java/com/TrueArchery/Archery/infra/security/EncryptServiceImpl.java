package com.TrueArchery.Archery.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.TrueArchery.Archery.domain.user.UserRepository;

@Service
public class EncryptServiceImpl implements EncryptService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean validate(String password, String hash) {
        // TODO Auto-generated method stub
        return false;
    }

}
