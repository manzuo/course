package com.management.course.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/10 20:59
 */
@Data
@Entity
@Table(name = "course")
@ApiModel(value = "课程")
public class Course extends BaseEntity {

    @ApiModelProperty(value = "课程代码")
    private String courseCode;
    @ApiModelProperty(value = "选课代码")
    private String selectionCode;
    @ApiModelProperty(value = "学期")
    private String term;
    @ApiModelProperty(value = "课程名称")
    private String title;
    @ApiModelProperty(value = "授课教师")
    private String teacher;
    @ApiModelProperty(value = "课程类型")
    private String courseType;
    @ApiModelProperty(value = "选课类型")
    private String selectionType;
    @ApiModelProperty(value = "上课时间")
    private String time;
    @ApiModelProperty(value = "上课地点")
    private String place;
    @ApiModelProperty(value = "选课人数")
    private String number;
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
    @ApiModelProperty(value = "状态")
    private Integer state;
    @ApiModelProperty(value = "信息")
    private String message;
}
