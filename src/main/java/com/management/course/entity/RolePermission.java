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
 * @date 2019/9/24 23:20
 */
@Data
@Entity
@Table(name = "role_permission")
@ApiModel(value = "角色权限关系表")
public class RolePermission extends  BaseEntity{
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "权限id")
    private String permissionId;

}
