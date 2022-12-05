package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.UserDTO;
import com.melck.carrertoolms.entities.Role;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.RoleRepository;
import com.melck.carrertoolms.repositories.UserRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.getOne(2L);
        if (role != null) {
        user.getRoles().add(role);
        }
        User newUser = repository.save(user);
        return new UserDTO(newUser);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map( user -> new UserDTO(user)).collect(Collectors.toList());
    }

    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("Usuario não encontrado");
            throw new UsernameNotFoundException("Email não cadastrado");
        }
        logger.info("Usuario encontrado: " + username);
        return user;
    }
}
