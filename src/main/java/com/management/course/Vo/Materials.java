package com.management.course.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/15 10:51
 */
@Data
public class Materials implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "选课代码")
    private String selectionCode;
    @ApiModelProperty(value = "教师工作手册")
    private String workbook;
    @ApiModelProperty(value = "成绩册")
    private String reportCard;
    @ApiModelProperty(value = "教学大纲")
    private String syllabus;
    @ApiModelProperty(value = "大作业")
    private String homework;
    @ApiModelProperty(value = "上机报告")
    private String report;
}
