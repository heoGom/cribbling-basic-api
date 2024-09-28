package com.example.scribblingapi.user;

import lombok.Builder;
import lombok.Data;

public class UserResponseDTO {

    @Data
    public static class UserDTO {
        private Integer id;
        private String name;

        @Builder
        public UserDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
    @Data
    public static class UserListDTO {
        private Integer id;

        @Builder
        public UserListDTO(User user) {
            this.id = user.getId();
        }
    }
}
