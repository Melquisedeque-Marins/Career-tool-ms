package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.dtos.UserDTO;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserDTO dto) {
        UserDTO newUser = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getUserId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User user =service.findById(id);
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<UserDTO> users =service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
