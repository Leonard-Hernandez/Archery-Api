package com.TrueArchery.Archery.infra.security;

import org.springframework.stereotype.Service;

@Service
public interface EncryptService {

    String encrypt(String password);

    boolean validate(String password, String hash);

}
