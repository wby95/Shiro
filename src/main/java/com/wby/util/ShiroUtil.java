package com.wby.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {

    public  static Subject login(String configFile,String userName,String password ){

        //1、读取配置文件，初始化工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configFile);
        //2、获取SecurityManager实例
        SecurityManager securityManager=factory.getInstance();
        //3、SecurityManager绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4、获取到当前的用户
        Subject currentUser =SecurityUtils.getSubject();
        //5、创建令牌 用户名/密码
        UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
        //6、
        try{
            currentUser.login(token);
            System.out.println("身份验证成功");
        }catch (AuthenticationException a){
            a.getStackTrace();
            System.out.println("身份验证失败");
        }
      return currentUser;
    }
}
