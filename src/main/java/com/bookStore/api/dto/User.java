package com.bookStore.api.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    private String id;
    private String name;
    private String email;
}

