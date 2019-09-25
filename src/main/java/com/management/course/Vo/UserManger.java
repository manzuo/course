package com.management.course.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/18 10:56
 */
@Data
public class UserManger implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty(value = "工号")
    private String workid;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "职务")
    private String job;
    @ApiModelProperty(value = "部门")
    private String department;
}
