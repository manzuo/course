package com.management.course.controller;

import cn.hutool.core.util.StrUtil;
import com.management.course.Vo.Result;
import com.management.course.Vo.ResultUtil;
import com.management.course.dao.RedisSessionDAO;
import com.management.course.entity.Login;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 2:00
 */
@RestController
public class BaseController {
    @Autowired
    private RedisSessionDAO redisSessionDAO;
    @ApiOperation(value = "登陆失败")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result<Object> result(){
        return new ResultUtil<Object>().setErrorMsg("请先登陆");
    }

    @ApiOperation(value = "未授权")
    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public Result<Object> unauthorized(){
        return new ResultUtil<Object>().setErrorMsg("你没有该权限");
    }
    @ApiOperation(value = "登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Object> result(@ModelAttribute Login login){
        if (StrUtil.isBlank(login.getWorkId())||StrUtil.isBlank(login.getPassword())){
            System.out.println(login.getWorkId()+" "+login.getPassword());
            return new ResultUtil<Object>().setErrorMsg("账号或者密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(login.getWorkId(),login.getPassword());
        System.out.println(token);
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }catch (Exception e){
            return new ResultUtil<Object>().setErrorMsg(e.getMessage());
        }
        return  new ResultUtil<Object>().setSuccessMsg("登陆成功");
    }

}
