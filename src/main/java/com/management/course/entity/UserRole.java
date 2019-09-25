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
 * @date 2019/9/24 23:17
 */
@Data
@Entity
@Table(name = "user_role")
@ApiModel(value = "用户角色关系表")
public class UserRole extends BaseEntity {
    @ApiModelProperty(value = "用户id")
    private String workId;
    @ApiModelProperty(value = "角色id")
    private String roleId;
}
