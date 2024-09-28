package com.example.scribblingapi.user;

import com.example.scribblingapi.core.aop.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Log
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<UserResponseDTO.UserListDTO> users = userService.유저리스트보여주기();
        return ResponseEntity.ok(users);
    }

    @Log
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        UserResponseDTO.UserDTO user = userService.유저보여주기(id);
        return ResponseEntity.ok(user);
    }

    @Log
    @PutMapping("/users/{id}")
    public ResponseEntity<?> putUser(@PathVariable Integer id, @RequestBody UserRequestDTO.putNameDTO DTO) {
        UserResponseDTO.UserDTO user = userService.유저수정하기(id, DTO);
        return ResponseEntity.ok(user);
    }
}
