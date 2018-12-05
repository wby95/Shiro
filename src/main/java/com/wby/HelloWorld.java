package com.wby;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;



/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2018/12/5 0005
 * Time:14:10
 **/
public class HelloWorld {
    public static void main(String[] args) {
        //1、读取配置文件，初始化工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、获取SecurityManager实例
        SecurityManager securityManager=factory.getInstance();
        //3、SecurityManager绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4、获取到当前的用户
        Subject currentUser =SecurityUtils.getSubject();
        //5、创建令牌 用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken("wby","123");
        //6、
        try{
            currentUser.login(token);
            System.out.println("身份验证成功");
        }catch (AuthenticationException a){
            a.getStackTrace();
            System.out.println("身份验证失败");
        }

    }
}
