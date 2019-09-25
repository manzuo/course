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
 * @date 2019/9/24 23:07
 */
@Data
@Entity
@Table(name = "permission")
@ApiModel(value = "权限")
public class Permission extends BaseEntity {
    @ApiModelProperty(value = "权限id")
    private String permissionId;
    @ApiModelProperty(value = "权限名称")
    private String name;
    @ApiModelProperty(value = "权限描述")
    private String description;
    @ApiModelProperty(value = "权限访问路径")
    private String url;
    @ApiModelProperty(value = "权限标识")
    private String perms;
    @ApiModelProperty(value = "父级权限id")
    private String parentId;
    @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
    private String type;
    @ApiModelProperty(value = "排序")
    private int orderNum;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "状态：1有效；2删除")
    private String status;

}
