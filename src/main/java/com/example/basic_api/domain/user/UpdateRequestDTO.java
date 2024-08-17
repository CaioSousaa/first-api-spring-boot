package com.example.basic_api.domain.user;

import java.util.UUID;

public record UpdateRequestDTO(String name, String email, String password) {
}
