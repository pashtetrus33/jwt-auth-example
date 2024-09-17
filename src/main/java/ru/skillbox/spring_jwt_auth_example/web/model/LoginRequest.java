package ru.skillbox.spring_jwt_auth_example.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skillbox.spring_jwt_auth_example.entity.RoleType;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String username;

    private String password;
}
