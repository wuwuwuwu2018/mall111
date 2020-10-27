package com.firenay.mall.member.vo;

import lombok.Data;

@Data
public class SocialUser {

    private String accessToken; //通过code得到的访问令牌

    private String remindIn;

    private Long expiresIn; //访问令牌的过期时间

    private String uid; //社交用户的id

    private String isrealname;
}