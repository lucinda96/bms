package com.leeeunsol.bms.mapper;

import com.leeeunsol.bms.dto.UserDTO;

public interface UserMapper {
    UserDTO login(UserDTO userDTO);

    int existUserId(String userId);

    int registerUserInfo(UserDTO userDTO);
}
