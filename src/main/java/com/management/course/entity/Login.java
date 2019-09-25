package com.management.course.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 10:41
 */
@Data
public class Login implements Serializable {
    private static final long serialVersonUID = 1L;
    private String workId;
    private String password;
}
