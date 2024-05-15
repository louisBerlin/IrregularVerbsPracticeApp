package org.louis.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.louis.backend.model.user.UserRole;

import java.util.Set;


@Data
@AllArgsConstructor
public class UserWOUserId {

    private String username;
    private String email;
    private String password;
    private Set<UserRole> userRoles;
}
