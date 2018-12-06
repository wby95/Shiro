package com.wby;

import com.wby.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2018/12/5 0005
 * Time:14:10
 **/
public class TestRole {
    @Test
    public  void testRole() {
        Subject currenUser=ShiroUtil.login("classpath:shiro_role.ini","wby","123");
        //判断用户是否有该角色
        System.out.println(currenUser.hasRole("role1")+""+ currenUser.hasRole("role2"));
        System.out.println();
        //底层for循环调用hasRole
        boolean[] results=currenUser.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(results[0]);
        System.out.println(results[1]);
        System.out.println(results[2]);
        //只要一个不存在就是false
        boolean result=currenUser.hasAllRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(result);
    }
}
