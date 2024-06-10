package com.leeeunsol.bms.controller;

import com.leeeunsol.bms.dto.CompanyDTO;
import com.leeeunsol.bms.dto.UserDTO;
import com.leeeunsol.bms.service.UserService;
import com.leeeunsol.bms.view.AdminMenu;
import com.leeeunsol.bms.view.ResultMessage;
import com.leeeunsol.bms.view.SellerMenu;
import com.leeeunsol.bms.view.UserMenu;

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
                moveMainMenu(userDTO.getRole(),userDTO.getUserId());
            }
        }
    }

    private void moveMainMenu(String role, String userId) {
        switch (role){
            case "admin":
                new AdminMenu().adminMainMenu(userId);
                break;
            case "seller":
                new SellerMenu().sellerMainMenu(userId);
                break;
            case "user":
                new UserMenu().userMainMenu(userId);
                break;
            default:
                System.out.println("권한과 일치하는 메뉴가없습니다.\n관리자에게 문의해주세요.");
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

    public boolean checkRegisterSellerAuth(String userId) {
        boolean result = userService.findTransferAuthApplication(userId);
        if(result){
            resultMessage.failMsg("checkRegisterSellerAuth");
        }
        return result;
    }

    public void registerCompanyInfo(CompanyDTO companyDTO) {

       boolean result = userService.registerCompanyInfo(companyDTO);
       if(result){
           resultMessage.successMsg("transferAuthApplication");
       }else{
           resultMessage.failMsg("transferAuthApplication");
       }

    }
}
