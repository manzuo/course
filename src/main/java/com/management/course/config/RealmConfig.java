package com.management.course.config;

import com.management.course.dao.RedisSessionDAO;
import com.management.course.entity.User;
import com.management.course.entity.UserRole;
import com.management.course.service.RoleService;
import com.management.course.service.UserRoleService;
import com.management.course.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/24 22:30
 * 自定义realm
 */
public class RealmConfig extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    //为当前登录成功的用户授予权限和分配角色
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisSessionDAO  redisSessionDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String workId = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        List<UserRole> userRoles = userRoleService.findByWorkId(workId);
        for (UserRole u :userRoles){
            roles.add(roleService.findByRoleId(u.getRoleId()).getName());
        }
        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }
    //用来验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String workId = (String) authenticationToken.getPrincipal();
        String password = (String)authenticationToken.getCredentials();
        User user = userService.findByWorkId(workId);
        if (user==null||!(user.getPassword().equals(password))){
            throw new AuthenticationException("用户名错误或者密码错误");
        }
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"jdbc");
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return authcInfo;
    }
}
