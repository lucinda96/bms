package com.leeeunsol.bms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDTO {
    private String userId;
    private String password;
    private String userName;
    private String role;

    public UserDTO(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }
}
