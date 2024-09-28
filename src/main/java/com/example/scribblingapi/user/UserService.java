package com.example.scribblingapi.user;

import com.example.scribblingapi.core.error.ex.ExceptionApi400;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDTO.UserListDTO> 유저리스트보여주기() {
        List<User> all = userRepository.findAll();
        List<UserResponseDTO.UserListDTO> allDTO = new ArrayList<>();
        for (User user : all) {
            allDTO.add(new UserResponseDTO.UserListDTO(user));
        }
        return allDTO;
    }

    public UserResponseDTO.UserDTO 유저보여주기(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ExceptionApi400("없는 유저입니다."));
        return new UserResponseDTO.UserDTO(user);
    }

    @Transactional
    public UserResponseDTO.UserDTO 유저수정하기(Integer id, UserRequestDTO.putNameDTO DTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ExceptionApi400("없는 유저입니다."));
        user.setName(DTO.getName());
        return new UserResponseDTO.UserDTO(user);
    }
}
