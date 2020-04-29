package com.lzy.springbootvalidation.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class User {

    /**
     * userName : lizhiyu
     * password : 123456
     * email : 1035614725@qq.com
     * idCard : 432503199011244526
     */
    @NotEmpty(message="用户名不能为空")
    @Length(min=6,max = 12,message="用户名长度必须位于6到12之间")
    private String userName;

    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    @Email(message="请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
