package com.management.course.config;

import com.management.course.dao.RedisSessionDAO;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 1:34
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
// 定义 shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        // 设置自定义的 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登录的 URL，身份认证失败会访问该 URL
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 设置未授权界面，权限认证失败会访问该 URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String,String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-*/**", "anon");
        filterChainMap.put("/swagger-ui.html/**", "anon");
        // 登录 URL 放行
        filterChainMap.put("/login", "anon");

        // 以“/course/” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/course/*", "authc");
        // 以“/course/” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/user/*", "authc");
//        // “/user/student” 开头的用户需要角色认证，是“admin”才允许
//        filterChainMap.put("/user/student*/**", "roles[admin]");
//        // “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
//        filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");


        // 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //去除url中的jsessionid
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }
    @Bean
    public RedisSessionDAO redisSessionDAO(){
        return  new RedisSessionDAO();
    }
}
