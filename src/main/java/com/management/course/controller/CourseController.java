package com.management.course.controller;

import cn.hutool.core.util.StrUtil;
import com.management.course.entity.Course;
import com.management.course.service.CourseService;
import com.management.course.Vo.Materials;
import com.management.course.Vo.Result;
import com.management.course.Vo.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/11 16:30
 */
@RestController
@RequestMapping("/course")
@Api("课程管理接口")
public class CourseController {
    @Autowired
    CourseService courseService;
    @ApiOperation("课程导入")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public Result<Object> importCourses(MultipartFile file) {
        if (file.getSize() == 0 || StrUtil.isBlank(file.getOriginalFilename())) {
            return new ResultUtil<Object>().setErrorMsg("文件为空");
        }
        try {
            Workbook workbook;
            if (file.getOriginalFilename().endsWith(".xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (file.getOriginalFilename().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                return new ResultUtil<Object>().setErrorMsg("文件格式错误");
            }
            List<String> error = new ArrayList<>();
            int count = 0;
            //默认只有一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获得sheet中有多少行
            int rowNumber = sheet.getPhysicalNumberOfRows();
            //第0行是标题行，跳过
            for (int i = 1; i < rowNumber; i++) {
                count++;
                //获取第i行
                Row row = sheet.getRow(i);
                //判断字段是否为空
                if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null || row.getCell(3) == null || row.getCell(4) == null || row.getCell(5) == null || row.getCell(9) == null) {
                    //if (StrUtil.isBlank(row.getCell(0).getStringCellValue())||StrUtil.isBlank(row.getCell(1).getStringCellValue())||StrUtil.isBlank(row.getCell(2).getStringCellValue())||StrUtil.isBlank(row.getCell(3).getStringCellValue())||StrUtil.isBlank(row.getCell(4).getStringCellValue())||StrUtil.isBlank(row.getCell(5).getStringCellValue())||StrUtil.isBlank(row.getCell(9).getStringCellValue())){
                    error.add("第" + (i + 1) + "行导入失败，格式不正确或非空字段为空");
                    continue;
                }
                if (courseService.findBySelectionCode(row.getCell(1).getStringCellValue()) != null) {
                    error.add("第" + (i + 1) + "行导入失败，选课代码重复，该课程已存在");
                    continue;
                }
                Course course = new Course();
                course.setCourseCode(row.getCell(0).getStringCellValue());
                course.setSelectionCode(row.getCell(1).getStringCellValue());
                course.setTitle(row.getCell(2).getStringCellValue());
                course.setTeacher(row.getCell(3).getStringCellValue());
                course.setCourseType(row.getCell(4).getStringCellValue());
                course.setSelectionType(row.getCell(5).getStringCellValue());
                course.setTime(row.getCell(6).getStringCellValue());
                course.setPlace(row.getCell(7).getStringCellValue());
                course.setNumber(row.getCell(8).getStringCellValue());
                course.setTerm(row.getCell(9).getStringCellValue());
                course.setState(0);
                courseService.save(course);
            }
            if (error.size() == 0) {
                String successMessage = "课程导入成功，本次共导入" + (rowNumber - 1) + "门课程";
                return new ResultUtil<Object>().setSuccessMsg(successMessage);
            } else {
                String errorMessage = "本次成功导入" + (rowNumber - 1 - error.size()) + "门课程，有" + error.size() + "行数据导入失败" +
                        "错误原因分别为:" + error.toString();
                return new ResultUtil<Object>().setSuccessMsg(errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultUtil<Object>().setErrorMsg(e.getMessage());
        }
    }
    @ApiOperation("材料提交")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Result<Object> uploadFile(@ModelAttribute Materials materials){
        if (StrUtil.isNotBlank(materials.getWorkbook())&&StrUtil.isNotBlank(materials.getReportCard())&&StrUtil.isNotBlank(materials.getSyllabus())&&(StrUtil.isNotBlank(materials.getReport())||StrUtil.isNotBlank(materials.getHomework()))){
            Course course = courseService.findBySelectionCode(materials.getSelectionCode());
            course.setWorkbook(materials.getWorkbook());
            course.setReportCard(materials.getReportCard());
            course.setSyllabus(materials.getSyllabus());
            if (StrUtil.isNotBlank(materials.getReport())){
                course.setReport(materials.getReport());
            }
            if (StrUtil.isNotBlank(materials.getHomework())){
                course.setHomework(materials.getHomework());
            }
            course.setState(1);
            courseService.update(course);
            return new ResultUtil<Object>().setSuccessMsg("提交成功");
        }
        return new ResultUtil<Object>().setErrorMsg("提交失败，材料不完整");
    }
    @ApiOperation("查看需要审阅的课程")
    @RequestMapping(value = "needCheck", method = RequestMethod.GET)
    public Result<List<Course>> getNeedCheeck(@RequestParam String term){
        List<Course>  courses = courseService.findByTermAndState(term,1);
        return new ResultUtil<List<Course>>().setData(courses);
    }
    @ApiOperation("审核通过")
    @RequestMapping(value = "checkPass", method = RequestMethod.POST)
    public Result<Object> CheeckPass(@RequestParam String selectionCode){
        Course course = courseService.findBySelectionCode(selectionCode);
        course.setState(2);//审核通过
        course.setMessage("审核通过");
        courseService.update(course);
        return new ResultUtil<Object>().setSuccessMsg("审核成功");
    }
    @ApiOperation("退回修改")
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public Result<Object> sendBack(@RequestBody String selectionCode,@RequestBody String message){
        Course course = courseService.findBySelectionCode(selectionCode);
        course.setState(3);//未通过
        course.setMessage(message);
        courseService.update(course);
        return new ResultUtil<Object>().setSuccessMsg("退回成功");
    }

}
