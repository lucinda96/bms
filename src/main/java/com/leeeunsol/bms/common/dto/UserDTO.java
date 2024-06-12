package com.leeeunsol.bms.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDTO {
    private String userId;
    private String password;
    private String userName;
    private String role;

    public UserDTO(String userId, String password, String userName,String role) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }
}
