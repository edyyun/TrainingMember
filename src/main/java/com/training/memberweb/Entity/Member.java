package com.training.memberweb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name="memberId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberId;

    @Column(name="memberName")
    private String memberName;

    @Column(name="memberPassword")
    private String memberPassword;

    @Column(name="memberEmail")
    private String memberEmail;

    @Column(name="memberAddress")
    private String memberAddress;

    @Column(name="memberGender")
    private String memberGender;
}
