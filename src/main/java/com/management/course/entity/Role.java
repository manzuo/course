package com.management.course.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/24 23:02
 */
@Data
@Entity
@Table(name = "role")
@ApiModel(value = "用户")
public class Role extends BaseEntity {
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "角色名称")
    private String name;
    @ApiModelProperty(value = "角色描述")
    private String description;
    @ApiModelProperty(value = "状态：1 有效；2 删除")
    private String status;
}
