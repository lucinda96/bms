package com.leeeunsol.bms.view;

import com.leeeunsol.bms.common.Role;
import com.leeeunsol.bms.controller.UserController;
import com.leeeunsol.bms.dto.UserDTO;

import java.util.Scanner;

public class MenuView {

    private Scanner sc = new Scanner(System.in);
    private UserController userController = new UserController();

    public void mainMenu(){
        while (true){
            System.out.println("""
                1. 회원가입
                2. 로그인
                9. 시스템 종료""");
            System.out.print("메뉴를 선택해주세요: ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch(menu){
                case 1:
                    joinMember();
                    break;
                case 2:
                    userController.login(inputLoginInfo());
                    break;
                case 9:
                    System.out.println("시스템을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("메뉴를 다시 확인해주세요");
                    break;
            }
        }
    }

    private void joinMember() {
        System.out.println("회원가입메뉴");
    }

    private UserDTO inputLoginInfo() {
        String role = selectRole("로그인 할 ");
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        return new UserDTO(id,password,role);
    }

    private String selectRole(String text){

        while (true){
            System.out.println("""
                1. 관리자
                2. 판매자
                3. 구매자""");
            System.out.print(text+"권한을 선택해주세요: ");
            int role = sc.nextInt();
            sc.nextLine();
            switch (role){
                case 1:
                    return Role.admin.name();
                case 2:
                    return Role.seller.name();
                case 3:
                    return Role.user.name();
                default:
                    System.out.println("권한을 다시 확인해 주세요");
                    break;
            }
        }

    }
}
