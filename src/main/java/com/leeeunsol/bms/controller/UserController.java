package com.leeeunsol.bms.controller;

import com.leeeunsol.bms.dto.UserDTO;
import com.leeeunsol.bms.service.UserService;
import com.leeeunsol.bms.view.ResultMessage;

public class UserController {

    private UserService userService = new UserService();
    private ResultMessage resultMessage = new ResultMessage();

    public UserDTO login(UserDTO userDTO) {

        if(userDTO.getUserId() == null || userDTO.getUserId().isEmpty()){
            resultMessage.faillMsg("notInputId");
            return null;
        } else if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            resultMessage.faillMsg("notInputPassword");
            return null;
        } else {
            UserDTO result = userService.login(userDTO);
            if(result == null || result.getUserName() == null || result.getUserName().isEmpty()){
                resultMessage.faillMsg("login");
                return null;
            }else {
                resultMessage.succesMsg("login");
                return result;
            }
        }

    }
}
