# Shiro
### 目录

1. [ShiroHello](#ShiroHello)
    - [ShiroHello的搭建](#ShiroHello的搭建)
2. [Introduction](#introduction)
	- [简介](#简介)
    - [三大组件](#三大组件应用)
 
3. [认证流程](#认证流程)
    
## ShiroHello
#### 一、ShiroHello的搭建
> 1、读取配置文件，初始化工厂

> 2、获取SecurityManager实例

> 3、SecurityManager绑定到SecurityUtils

> 4、获取到当前的用户

> 5、创建令牌 用户名/密码
```

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


```
##  二、Introduction
#### 简介
> Apache Shiro是一个强大且易用的Java安全框架,执行身份验证、授权、密码和会话管理。使用Shiro的易于理解的API,您可以快速、轻松地获得任何应用程序,从最小的移动应用程序到最大的网络和企业应用程序。
![shiro.PNG](./img/shiro.PNG)

#### 三大组件应用

 |Subject|SecurityManager |Realm|
 | :-----   |  :-----   |  :-----   | 
 |当前用户的安全操作|Shiro通过SecurityManager来管理内部组件实例，并通过它来提供安全管理的各种服务| Realm充当了Shiro与应用安全数据间的“桥梁”或者“连接器”。也就是说，当对用户执行认证（登录）和授权（访问控制）验证时，Shiro会从应用配置的Realm中查找用户及其权限信息|
 
 
 ### 三、认证流程
 
 > 认证/授权基本步骤：
 
![shiro.PNG](./img/认证过程.PNG)
 
  |认证/授权基本步骤|
  | :-----   | 
  | 1. 获取当前的 Subject，调用SecurityUtils.getSubject()|
  | 2. 判断当前用户是否已经认证，调用 Subject 的 isAuthenticated();|
  | 3. 或没有被认证，则把用户名和密码封装为 UserNamePassworkToken 对象|
  | 4. 执行登录，调用 Subject 的 login(AuthencationToken);|
  | 5. 自定义Realm 方法，从数据库中获用户安全数据|


    

 

 


 

 

