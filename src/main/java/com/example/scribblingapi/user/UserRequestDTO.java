package com.example.scribblingapi.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRequestDTO {

    @Data
    @NoArgsConstructor
    public static class putNameDTO {
        String name;

        @Builder
        public putNameDTO(String name) {
            this.name = name;
        }
    }
}
