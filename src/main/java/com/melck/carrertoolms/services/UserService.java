package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User user) {
        return repository.save(user);
    }
}
