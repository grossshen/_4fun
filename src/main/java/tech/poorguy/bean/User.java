package tech.poorguy.bean;

import tech.poorguy.annotation.Bean;

/**
 * @Date 9/28/2019 2:08 PM
 * @Mail 494939649@qq.com
 **/
@Bean
public class User {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
