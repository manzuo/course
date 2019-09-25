package com.management.course.controller;

import com.management.course.entity.User;
import com.management.course.service.UserService;
import com.management.course.Vo.Result;
import com.management.course.Vo.ResultUtil;
import com.management.course.Vo.UserManger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/18 10:47
 */
@RestController
@RequestMapping("/user")
@Api("用户管理接口")
public class UserController {
    @Autowired
    UserService userService;
    @ApiOperation("用户管理")
    @RequestMapping(value = "/userManger", method = RequestMethod.GET)
    public Result<List<UserManger>> UserManger(){
        List<User> users= userService.findAll();
        List<UserManger> list = new ArrayList<>();
        for (User u:users) {
            UserManger userManger = new UserManger();
            userManger.setId(u.getId());
            userManger.setName(u.getName());
            userManger.setJob(u.getJob());
            userManger.setDepartment(u.getDepartment());
            userManger.setWorkid(u.getWorkId());
            list.add(userManger);
        }
        return new ResultUtil<List<UserManger>>().setData(list);
    }
    @ApiOperation("查看用户个人信息")
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Result<User> UserInfo(@RequestParam String workid){
        User user = userService.findByWorkId(workid);
        user.setPassword(null);
        return new ResultUtil<User>().setData(user);
    }
    @ApiOperation(value = "更改用户个人信息",notes = "工号和密码、权限等不能修改")
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public Result<Object> updateUser(@ModelAttribute User user){
        User old = userService.findByWorkId(user.getWorkId());
        user.setPassword(old.getPassword());
        user.setIsExpert(old.getIsExpert());
        user.setStatus(old.getStatus());
        user.setAuthority(old.getAuthority());
        user.setOrigin(old.getOrigin());
        old = userService.update(user);
        if (old==null){
            return  new ResultUtil<Object>().setErrorMsg("更新失败");
        }
        return new ResultUtil<Object>().setSuccessMsg("更新成功");
    }
    @ApiOperation(value = "停用用户")
    @RequestMapping(value = "/stopUser", method = RequestMethod.POST)
    public Result<Object> stopUser(@RequestParam String workid){
        User user = userService.findByWorkId(workid);
        if (user!=null){
            //state 为0 说明正常使用，state 为1 说明停用
            if (user.getStatus()!=1){
                user.setStatus(1);
                userService.update(user);
            }
            return new ResultUtil<Object>().setSuccessMsg("停用成功");
        }
        return new ResultUtil<Object>().setErrorMsg("用户不存在");
    }


}
