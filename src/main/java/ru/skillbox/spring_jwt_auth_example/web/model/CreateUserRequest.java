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
@Builder
public class CreateUserRequest {

    private String username;

    private String email;

    private Set<RoleType> roles;

    private String password;
}
