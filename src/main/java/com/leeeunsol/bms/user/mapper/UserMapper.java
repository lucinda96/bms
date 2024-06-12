package com.leeeunsol.bms.user.mapper;

import com.leeeunsol.bms.common.dto.CompanyDTO;
import com.leeeunsol.bms.common.dto.UserDTO;

public interface UserMapper {
    UserDTO login(UserDTO userDTO);

    int existUserId(String userId);

    int registerUserInfo(UserDTO userDTO);

    int registerCompanyInfo(CompanyDTO companyDTO);

    int existCompanyInfo(String userId);
}
