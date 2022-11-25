package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.UserRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User user) {
        return repository.save(user);
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
