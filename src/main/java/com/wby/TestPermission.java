package com.wby;

import com.wby.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2018/12/5 0005
 * Time:14:10
 **/
public class TestPermission {
    @Test
    public  void testRole() {
        Subject currenUser=ShiroUtil.login("classpath:shiro_permission.ini","wby","123");
        //判断用户是否有该权限
        System.out.println(currenUser.isPermitted("user:select"));
        System.out.println(currenUser.isPermitted("user:delete"));

    }
}
