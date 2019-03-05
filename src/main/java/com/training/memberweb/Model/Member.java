package com.training.memberweb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int memberId;
    private String memberName;
    private String memberPassword;
    private String memberEmail;
    private String memberAddress;
    private String memberGender;
}
