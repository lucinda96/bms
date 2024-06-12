package com.leeeunsol.bms.user.view;

import com.leeeunsol.bms.user.controller.UserController;
import com.leeeunsol.bms.common.dto.CompanyDTO;

import java.util.Scanner;

public class UserMenu {

    private Scanner sc = new Scanner(System.in);
    private UserController userController = new UserController();

    public void userMainMenu(String userId){

        while (true){
            System.out.println("""
                    ==========================
                    사용자 메뉴
                    ==========================ㅋ
                    1. 상품 목록 표시
                    2. 판매자 전환 신청
                    3. 회원 탈퇴
                    9. 로그아웃""");
            System.out.print("메뉴를 입력해주세요: ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1:
                    // 등록된 상품목록 표시
                    break;
                case 2:
                    // 판매자 전환신청
                    // 판매자 전환 신청메뉴(
                    transferToSellerAuth(userId);
                    break;
                case 3:
                    //회원탈퇴
                    break;
                case 9:
                    //로그아웃
                    System.out.println("성공적으로 로그아웃이 되었습니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
                    break;
            }
        }
    }

    private void transferToSellerAuth(String userId ) {

        // 판매자 권한 변경 신청여부 조회
        if(userController.checkRegisterSellerAuth(userId)){
            return;
        }
        while(true){
            // 권한신청 정보 등록
            CompanyDTO companyDTO = inputTransferToSellerAuthInfo(userId);
            userController.registerCompanyInfo(companyDTO);
        }


    }

    private CompanyDTO inputTransferToSellerAuthInfo(String userId) {
        
        System.out.print("회사명을 입력해주세요: ");
        String companyName =sc.nextLine();

        System.out.print("사업자 번호를 입력해주세요: ");
        String companyNum = sc.nextLine();

        System.out.print("회사 전화번호를 입력해주세요: ");
        String companyPhone = sc.nextLine();

        System.out.print("회사 주소를 입력해주세요: ");
        String companyAddress = sc.nextLine();

        return new CompanyDTO(userId,companyName,companyNum,companyPhone,companyAddress);

    }


}
