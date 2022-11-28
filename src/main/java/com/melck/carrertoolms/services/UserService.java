package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.UserDTO;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.UserRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User insert(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);
    }
}
