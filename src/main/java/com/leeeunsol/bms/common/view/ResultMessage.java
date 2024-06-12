package com.leeeunsol.bms.common.view;

public class ResultMessage {

    public void successMsg(String code){
        switch (code){
            case "login":
                System.out.println("로그인 성공!");
                break;
            case "register":
                System.out.println("회원가입 성공!");
                break;
            case "transferAuthApplication":
                System.out.println("판매자 권한 변경 신청완료!");
                break;
        }
    }

    public void failMsg(String code){
        switch (code){
            case "notInputPassword":
                System.out.println("비밀번호를 입력해주세요.");
                break;
            case "notInputId":
                System.out.println("아이디를 입력해주세요.");
                break;
            case "notInputName":
                System.out.println("이름을 입력해주세요.");
                break;
            case "register":
                System.out.println("회원가입에 실패했습니다.\n다시 진행해주세요.");
                break;
            case "exitsUserId":
                System.out.println("이미 존재하는 아이디 입니다.");
                break;
            case "mismatchPassword":
                System.out.println("비밀번호는 영어,숫자,특수문자 포함 8자 이상입력해주세요.");
                break;
            case "login":
                System.out.println("일치하는 계정이없습니다.\n아이디와 비밀번호를 확인해주세요.");
                break;
            case "checkRegisterSellerAuth":
                System.out.println("판매자 권한 변경을 이미 신청하셨습니다.\n담당자 승인까지 시간이 걸리니 기다려주세요.");
                break;
            case "transferAuthApplication":
                System.out.println("판매자 권한 변경 신청에 실패하셨습니다.\n다시 신청해주세요.");
                break;
        }
    }
}
