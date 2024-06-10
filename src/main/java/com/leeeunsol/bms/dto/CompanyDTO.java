package com.leeeunsol.bms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class CompanyDTO {


    private int companySeq;
    private int uid;
    private String userId;
    private String companyName;
    private String companyPhone;
    private String companyAddress;
    private String companyNum;
    private boolean deleteYn;
    private Timestamp registerDate;

    public CompanyDTO(String userId, String companyName, String companyPhone, String companyAddress, String companyNum) {
        this.userId = userId;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyAddress = companyAddress;
        this.companyNum = companyNum;
    }
}
