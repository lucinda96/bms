package com.leeeunsol.bms.controller;

import com.leeeunsol.bms.dto.UserDTO;
import com.leeeunsol.bms.service.UserService;
import com.leeeunsol.bms.view.ResultMessage;

public class UserController {

    private UserService userService = new UserService();
    private ResultMessage resultMessage = new ResultMessage();
    private final String REG_PASSWORD = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/";

    public void login(UserDTO userDTO) {

        if(userDTO.getUserId() == null || userDTO.getUserId().isEmpty()){
            //아이디를 입력하지 않은경우
            resultMessage.failMsg("notInputId");
        } else if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            //비밀번호를 입력하지 않은경우
            resultMessage.failMsg("notInputPassword");
        } else {
            UserDTO result = userService.login(userDTO);
            if(result == null || result.getUserName() == null || result.getUserName().isEmpty()){
                // 계정이 없는 경우
                resultMessage.failMsg("login");
            }else {
                resultMessage.successMsg("login");
            }
        }
    }

    public void joinMember(UserDTO userDTO) {

        if(userDTO.getUserId() == null || userDTO.getUserId().isEmpty()){
            //아이디를 입력하지 않은경우
            resultMessage.failMsg("notInputId");
        } else if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            //비밀번호를 입력하지 않은경우
            resultMessage.failMsg("notInputPassword");
        } else if (userDTO.getUserName() == null || userDTO.getUserName().isEmpty()) {
            //이름을 입력하지 않은 경우
            resultMessage.failMsg("notInputName");
        }else{
            boolean existUserId = userService.existUserId(userDTO.getUserId());
            if(existUserId){
                resultMessage.failMsg("exitsUserId");
                return;
            }
            if(!userDTO.getPassword().matches(REG_PASSWORD)){
                resultMessage.failMsg("mismatchPassword");
                return;
            }
            boolean result = userService.joinMember(userDTO);
            if(result){
                resultMessage.successMsg("register");
            }else{
                resultMessage.failMsg("register");
            }
        }
    }
}
